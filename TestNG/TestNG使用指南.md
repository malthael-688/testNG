# TestNG使用指南

## 一、

## 二、上手准备

**eclipse:**

>1.help->Install New SoftWare
>
>2.输入TestNG Eclipse Composite P2 Repo - http://beust.com/eclipse/6.9.13
>
>选择TestNG
>
>3.安装重启即可

**IDEA:**

> 1.File->Settings->Plugins->输入TestNG
>
> 安装重启即可

## 三、简单demo

### 1.HelloWorld

1）添加如下依赖:

~~~xml
<dependencies>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.8.7</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
</dependencies>
~~~

2）创建HelloWorld.java文件

~~~java
import org.testng.annotations.Test;

public class HelloWorld {
    @Test
    public void sayHello()
    {
        System.out.println("hello world!");
    }
}
~~~

点击运行

3）输出结果：

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
hello world!

===============================================
Default Suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================
~~~



### 2.基本注解

在JUnit 3中用于指示测试方法的传统方式是将其名称加上前缀。 这是一个非常有效的方法，用于将类中的某些方法标记为具有特殊意义，但是命名不能很好地扩展(如果我们要为不同的框架添加更多的标签呢？)而且非常不灵活的(如果想传递额外的参数到测试框架呢怎么办？)。

注解从JDK 5开始正式添加到Java语言中，TestNG选择使用注解来注释测试类。

以下是TestNG支持的注释列表：

| 注解          | 描述                                                         |
| ------------- | ------------------------------------------------------------ |
| @BeforeSuite  | 在该套件的所有测试都运行在注释的方法之前，仅运行一次。       |
| @AfterSuite   | 在该套件的所有测试都运行在注释方法之后，仅运行一次。         |
| @BeforeClass  | 在调用当前类的第一个测试方法之前运行，注释方法仅运行一次。   |
| @AfterClass   | 在调用当前类的第一个测试方法之后运行，注释方法仅运行一次     |
| @BeforeTest   | 注释的方法将在属于`<test>`标签内的类的所有测试方法运行之前运行。 |
| @AfterTest    | 注释的方法将在属于`<test>`标签内的类的所有测试方法运行之后运行。 |
| @BeforeGroups | 配置方法将在之前运行组列表。 此方法保证在调用属于这些组中的任何一个的第一个测试方法之前不久运行。 |
| @AfterGroups  | 此配置方法将在之后运行组列表。该方法保证在调用属于任何这些组的最后一个测试方法之后不久运行。 |
| @BeforeMethod | 注释方法将在每个测试方法之前运行。                           |
| @AfterMethod  | 注释方法将在每个测试方法之后运行。                           |
| @DataProvider | 标记一种方法来提供测试方法的数据。 注释方法必须返回一个`Object [] []`，其中每个`Object []`可以被分配给测试方法的参数列表。 要从该`DataProvider`接收数据的`@Test`方法需要使用与此注释名称相等的`dataProvider`名称。 |
| @Factory      | 将一个方法标记为工厂，返回`TestNG`将被用作测试类的对象。 该方法必须返回`Object [ ] 。 |
| @Listeners    | 定义测试类上的侦听器。                                       |
| @Parameters   | 描述如何将参数传递给`@Test`方法。                            |
| @Test         | 将类或方法标记为测试的一部分。                               |

#### 使用注释/注解的好处

以下是使用注释/注解的一些好处：

- TestNG通过查找注释/注解来识别它感兴趣的方法。 因此，方法名称不限于任何模式或格式。

- 可以将其他参数传递给注释。

- 注释是强类型的，所以编译器会马上标记任何错误。

- 测试类不再需要扩展任何东西(如TestCase，对于JUnit3)。

  

