# 代理模式（Proxy）

代理模式有三种不同的形式：

- 静态代理
- 动态代理（JDK代理，接口代理）
- Cglib代理（可以在内存动态地创建对象，而不需要实现接口，属于动态代理范畴）

## 静态代理

静态代理例子：

![Screen Shot 2021-07-10 at 1.46.27 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-10 at 1.46.27 PM.png)

![Screen Shot 2021-07-10 at 1.46.43 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-07-10 at 1.46.43 PM.png)

静态代理优缺点

- 优点：在不修改目标对象功能的前提下，通过代理对象对目标功能扩展
- 缺点：因为代理对象需要和目标对象实现一样的接口，所以会有很多代理类
- 一旦接口增加方法，目标对象和代理对象都要维护

## 动态代理

介绍：

- 代理对象不需要实现接口，但目标对象要实现接口，否则不能用动态代理
- 代理对象的生成，是利用JDK的API，动态的在内存中构建代理对象
- 动态代理也叫：JDK代理、接口代理

  

