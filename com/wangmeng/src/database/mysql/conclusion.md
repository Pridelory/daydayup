# Innodb存储引擎



## InnoDB记录结构

数据库记录在磁盘上存放的方式称为行格式/记录格式

InnoDB行格式有四种：

1. Compact（紧凑）
2. Redundant
3. Dynamic
4. Compressed（压缩）

着重分析Compact格式，Dynamic是mysql5.7默认的行格式，其与Compact格式只有在行溢出方面有少许区别，其余差不多。

Compact行格式简图如下：

![Screen Shot 2021-06-24 at 9.10.45 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-24 at 9.10.45 PM.png)

### 变长字段长度列表

在 Compact 行格式中，把所有变长字段的真实数据占用的字节长度都存放在记录的开头部位，从而形成一个变长 字段长度列表，各变长字段数据占用的字节数按照列的顺序**逆序**存放

### NULL值列表

如果表中没有允许存储 **NULL** 的列，则 *NULL* 也不存在了

### 记录头信息

结构如下图：

![Screen Shot 2021-06-24 at 9.18.54 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-24 at 9.18.54 PM.png)

### 记录的真实数据

除了自定义数据以外，InnoDB还自动添加了一些隐藏列，如下图：

![Screen Shot 2021-06-24 at 9.23.38 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-24 at 9.23.38 PM.png)

### 行溢出

一个页一般是 16KB ，当记录中的数据太多，当前页放不下的时候，会把多余的数据存储到其他页中，这种现象称为 行溢出 

对于 Compact 和 Reduntant 行格式来说，如果某一列中的数据非常多的话，在本记录的真实 数据处只会存储该列的前 768 个字节的数据和一个指向其他页的地址，然后把剩下的数据存放到其他页中，这个 过程也叫做 行溢出 ，存储超出 768 字节的那些页面也被称为 溢出页

![Screen Shot 2021-06-24 at 9.38.49 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-24 at 9.38.49 PM.png)

但对于Dynamic行格式来说

它们不会在记 录的真实数据处存储字段真实数据的前 768 个字节，而是把所有的字节都存储到其他页面中，只在记录的真实数 据处存储其他页面的地址，如下图：

![Screen Shot 2021-06-24 at 9.39.40 PM](/Users/wangmeng/Library/Application Support/typora-user-images/Screen Shot 2021-06-24 at 9.39.40 PM.png)

## InnoDB数据页结构

