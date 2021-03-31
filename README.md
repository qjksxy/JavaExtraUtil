# JavaExtraUtil
一个Java扩展工具包，可以更加方便简洁的编写Java代码，同时能帮助您熟悉javadoc、jar包和git。本工程完全开源，欢迎各位加入此工程建设。

### 特性

本工程将常用的代码打包成单方法，可以简单优雅的完成一些功能。

如Java原生的输出函数为：

```java
System.out.println("Hello world!");
```

而此项目中，您可以

```java
EU.println("Hello world!");
```

通常，您需要输出一个数组时，常常要如此做：

```java
int[] arr = {1, 2, 3, 4, 5};
for(int i : arr){
    System.out.print(i);
    System.out.print(" ");
}
```

或者

```java
System.out.println(Arrays.toString(arr));
```

而此项目中，您可以如下做：

```java
EU.printArr(arr);
```

又或者，您需要输出多个数据时，你需要写多个输出函数或者进行格式化输出：

```java
int i = 15;
double d = 1e5;
String s = "15";
System.out.println(i);
System.out.println(d);
System.out.println(s);
```

或

```java
System.out.printf("%d\n%f\n%s\n", i, d, s);
```

而在此项目中，您可以：

```java
EU.println(i, d, s);
```

此项目对输入方法，foreach语句等等都有优化和扩展，详情可以查看本项目的javadoc文档。

#### javadoc文档

您可以访问[此处](http://piner.club/doc/index.html)在线查看javadoc文档。

`javadoc`文档在`ExtraUtil\doc`文件夹下，您可以下载文档压缩包到本地查看。

文档的主目录为`index.html`。

### 如何使用

最简单的使用方法，下载`ExtraUtil\jar`文件夹下或位于[此处](http://piner.club/doc/ExtraUtil.jar)的jar包，并将其配置到你的工程中。

建议您下载最新的jar包，以体验全部的功能。

#### Eclipse下jar包的配置方法

1. 在工程目录下新建一个文件夹（通常与src文件夹并列，并起名为lib），将下载好的jar包复制粘贴在此文件夹内。
2. 在`Eclipse`的包资源管理器中找到它，右键选择`构建路径`-->`添加到构建路径`。
3. 在Java文件中引入包，在`0.2`版本以前，该包名为`main`，在`0.2`版本及之后，该包名为`qjk`。

### 关于开源

本项目使用MIT开源许可协议，这是一个非常宽松的协议，通常情况下，您可以随意使用此项目。

MIT协议主要内容如下：

1. 您有权利使用、复制、修改、合并、出版发行、散布、再授权及贩售软件及软件的副本。
2. 您可根据程式的需要修改授权条款为适当的内容。
3. 在软件和软件的所有副本中都必须包含版权声明和许可声明。

可以说，除了必须包含许可声明外，再无任何限制。

