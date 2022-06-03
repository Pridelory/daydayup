# MyBatis源码解析

JDBC四个步骤

![Screen Shot 2021-06-29 at 7.41.57 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 7.41.57 PM.png)

 MyBatis大体流程图

![Screen Shot 2021-06-29 at 7.43.45 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 7.43.45 PM.png)

共四个步骤：

- 动态代理 Mapper Proxy
- SQL会话 SqlSession
- 执行器 Excutor
- JDBC处理器 StatementHandler

## MyBatis执行过程

SqlSession是门面模式的API

提供基本的API：增删改查

辅助API：提交、关闭会话

![Screen Shot 2021-06-29 at 7.50.03 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 7.50.03 PM.png)

执行器实现一 -- SimpleExecutor

执行器实现二 -- ReuseExecutor

执行器实现三 --- BatchExecutor

​	批处理只针对修改操作

​	批处理操作必须手动刷新

如下：  ![Screen Shot 2021-06-29 at 8.45.24 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 8.45.24 PM.png)

加一些缓存，没有必要在每一个执行器都添加缓存，可以抽象出来，如下图：

![Screen Shot 2021-06-29 at 8.49.51 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 8.49.51 PM.png)

在query里编写关于缓存相关逻辑

在update里编写激励缓存相关逻辑



执行器实现四 -- 二级缓存CachingExecutor

CachingExecutor只专注于二级缓存相关逻辑

装饰者模式：在不改变原有类结构和继承的情况下，通过包装原对象去扩展一个新功能 （责任链模式？）

调用过程：当调用CachingExecutor时，先执行二级缓存相关逻辑，随后转交给下一个executor去执行

详情如下：

![Screen Shot 2021-06-29 at 9.02.11 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 9.02.11 PM.png)

代码如下： ![Screen Shot 2021-06-29 at 9.06.27 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 9.06.27 PM.png)

结果如下：

![Screen Shot 2021-06-29 at 9.08.08 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 9.08.08 PM.png)

CachingExecutor这个类职责单一，只处理二级缓存相关逻辑，其余不相关逻辑转交给其他类去完成。

那么整个流程如下：

![Screen Shot 2021-06-29 at 9.16.48 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 9.16.48 PM.png)



## 一级缓存命中场景

MyBatis一级缓存默认打开

一级缓存是以key:value形式，底层其实就是hashmap

两个场景：

- 运行时参数相关（源码中的key部分可以看到）

  1. sql和参数必须相同
  2. 必须是相同的statementID（不同的方法名会导致statementID不一样）
  3. sqlSession必须一样（会话级缓存）
  4. RowBounds返回行范围必须相同

  ![Screen Shot 2021-06-29 at 9.47.09 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-29 at 9.47.09 PM.png)

  

- 操作与配置相关 

  1. 未手动清空缓存
  2. 未调用flushCache=true的查询
  3. 未执行update（执行update后肯定命中不了一级缓存）
  4. 缓存作用域不是STATEMENT

## 一级缓存源码解析

![Screen Shot 2021-06-30 at 2.36.35 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 2.36.35 PM.png)

流程图发展至下图：

![Screen Shot 2021-06-30 at 2.38.17 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 2.38.17 PM.png)

注意源码中的key很重要，其对应一级缓存命中的各个条件

![Screen Shot 2021-06-30 at 2.54.06 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 2.54.06 PM.png)

命中一级缓存与操作与配置相关的相关条件和对应代码如下：

![Screen Shot 2021-06-30 at 2.50.43 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 2.50.43 PM.png)

![Screen Shot 2021-06-30 at 2.51.25 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 2.51.25 PM.png)

![Screen Shot 2021-06-30 at 2.51.49 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 2.51.49 PM.png)

如上图，第四个条件需要queryStack==0，也就是子查询不会清空缓存。

![Screen Shot 2021-06-30 at 2.53.02 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 2.53.02 PM.png)

![Screen Shot 2021-06-30 at 2.53.15 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 2.53.15 PM.png)

## 一级缓存总结

（回头再看）

## 二级缓存定义与需求分析

![Screen Shot 2021-06-30 at 3.30.38 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 3.30.38 PM.png)

二级缓存定义

![Screen Shot 2021-06-30 at 3.31.30 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 3.31.30 PM.png)

二级缓存扩展性需求

![Screen Shot 2021-06-30 at 3.41.20 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 3.41.20 PM.png)

## 二级缓存组件结构

装饰器+责任链 设计模式

![Screen Shot 2021-06-30 at 3.44.47 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 3.44.47 PM.png)

![Screen Shot 2021-06-30 at 3.54.32 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 3.54.32 PM.png)

## 二级缓存使用与命中场景

![Screen Shot 2021-06-30 at 4.08.02 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 4.08.02 PM.png)

## 二级缓存源码分析

![Screen Shot 2021-06-30 at 4.13.09 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 4.13.09 PM.png)

![Screen Shot 2021-06-30 at 4.17.19 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 4.17.19 PM.png)

![Screen Shot 2021-06-30 at 4.21.53 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 4.21.53 PM.png)

![Screen Shot 2021-06-30 at 4.24.38 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 4.24.38 PM.png)

Cache就是一个接口 就是set和get 同时其隐藏了很多细节

![Screen Shot 2021-06-30 at 4.28.15 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 4.28.15 PM.png)

## 二级缓存的存取流程

查询和修改流程

![Screen Shot 2021-06-30 at 6.03.53 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-30 at 6.03.53 PM.png)

防止脏读

（回看）

##  StatementHandler定义与结构

![Screen Shot 2021-07-02 at 3.02.59 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-02 at 3.02.59 PM.png)

StatementHandler结构

![Screen Shot 2021-07-03 at 10.25.20 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-03 at 10.25.20 AM.png)

prepared statementhandler更安全

## Prepared statementhandler执行流程

流程：执行、预编译、设置参数、执行JDBC、结果集映射成JAVA Bean

后四个步骤都是在statementHandler里完成的

时序图如下：

![Screen Shot 2021-07-03 at 10.37.56 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-03 at 10.37.56 AM.png)

代码：先从Executor的doQuery()方法起

![Screen Shot 2021-07-03 at 11.05.07 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-03 at 11.05.07 AM.png)

通过Configuration对象调用newStatementHandler()方法获取到一个StatementHandler对象，然后通过prepareStatement方法获取一个Statement，最后执行查询。

newStatementHandler()方法如下![Screen Shot 2021-07-03 at 11.07.24 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-03 at 11.07.24 AM.png)

调用RoutingStatementHandler()方法![Screen Shot 2021-07-03 at 11.07.55 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-03 at 11.07.55 AM.png)

获取到对应的StatementHandler。

prepareStatement()方法如下：![Screen Shot 2021-07-03 at 11.09.19 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-03 at 11.09.19 AM.png)

prepare()方法如下：

![Screen Shot 2021-07-03 at 11.11.57 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-03 at 11.11.57 AM.png)

instantiateStatement()是在BaseStatementHandler类中的一个抽象方法，具体实现在PreparedStatementHandler类中实现。

## 参数设置流程

在prepareStatement()方法中的handler.parameterize(stmt)进行参数设置。

![Screen Shot 2021-07-03 at 11.18.12 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-03 at 11.18.12 AM.png)

参数设置交给ParameterHandler处理（进行参数映射）

## 参数转换过程

![Screen Shot 2021-07-03 at 11.30.57 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-03 at 11.30.57 AM.png)



## ParameterHandler参数映射处理

 回看及debug源码

## 结果集处理

![Screen Shot 2021-07-10 at 11.25.58 AM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-10 at 11.25.58 AM.png)

## 结果集转换过程

 

