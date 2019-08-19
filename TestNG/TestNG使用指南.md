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

  

### 3.基本注解的使用

#### 1.@Test

##### 1).@Test

> 1.每一个被@Test注解的方法都可以单独运行
>
> 2.被@Test注解的类，该类所有的方法都会被运行

源码:

~~~java
    /**
     * 每一个被@Test注解的方法都可以单独运行
     * 被@Test注解的类，该类所有的方法都会被运行
     */
    public void test1()
    {
        System.out.println("test1");
    }
    public void test2()
    {
        System.out.println("test2");
    }
    public String test3()
    {
        System.out.println("test3");
        return "test3";
    }
~~~

xml配置:

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="testdemo1">
    <test name="testdemo1">
        <classes>
            <class name="com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo1">
                <methods>
                    <include name="test1"/>
                    <include name="test2"/>
                    <include name="test3"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>
~~~

输出结果:

~~~java
[TestNG] Running:

test1
test2

===============================================
testdemo1
Total tests run: 2, Failures: 0, Skips: 0
===============================================
~~~

可以看出test3中有返回类型，但是运行时，自动跳过了test3方法

当我们在xml加入这一句:

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="testdemo1" allow-return-values="true">
    <test name="testdemo1">
        <classes>
            <class name="com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo1">
                <methods>
                    <include name="test1"/>
                    <include name="test2"/>
                    <include name="test3"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>
~~~

运行结果:

~~~java
[TestNG] Running:
  C:\Users\lenovo\Desktop\GitHub\TestNG\TestNG\TestNG-demo\testng-demo-simple\src\test\java\com\dcits\testng_demo\basicAnnotation\at_Test\TestDemo1.xml
test1
test2
test3

===============================================
testdemo1
Total tests run: 3, Failures: 0, Skips: 0
===============================================
~~~



##### 2).@Test(description = "")

> 描述@Test，在测试报告体现。

~~~java
    @Test(description = "test demo")
    void test1()
    {
        System.out.println("test1");
    }
~~~



##### 3).@Test(enabled = false)

> 1.enabled属性
>
> 2.设置为false，执行测试会忽略@Test注解的test2方法。

~~~java
    @Test(enabled = false)
    void test2()
    {
        System.out.println("test2");
    }
~~~



##### 4).@Test(groups = "")

> 1.groups属性
>
> 2.测试方法进行分组，可在类级别或方法级别添加组，类级别分组,表示类里面的所有方法都属于该分组

源码如下:

~~~java
    @Test(groups = "test1")
    void test1()
    {
        System.out.println("test1");
    }

    @Test(groups = "test2")
    void test2()
    {
        System.out.println("test2");
    }

    @Test(groups = "test1")
    void test3()
    {
        System.out.println("test3");
    }
~~~

xml如下:

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="testdemo1" allow-return-values="true">
    <test name="testdemo1">
        <groups>
            <run>
                <include name="test1"/>
                <exclude name="test2"/>
            </run>
        </groups>
        <classes>
            <class name="com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo4">
                <methods>
                    <include name="test*"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>
~~~

**注：testNG的xml文件支持正则表达式，可以事半功倍**

运行结果:

~~~java
[TestNG] Running:
  C:\Users\lenovo\Desktop\GitHub\TestNG\TestNG\TestNG-demo\testng-demo-simple\src\test\java\com\dcits\testng_demo\basicAnnotation\at_Test\TestDemo4.xml
test1
test3

===============================================
testdemo1
Total tests run: 2, Failures: 0, Skips: 0
===============================================
~~~



##### 5).@Test(dependsOnMethods = "")

>  定义方法之间的依赖关系，可使用正则表达式作为参数。
>
> dependsOnMethods/dependsOnGroups控制优先级最高
>
> 定义方法之间的依赖关系，与dependsOnGroups用法类似。可使用正则表达式作为参数。另外，如果依赖于一个碰巧有多个重载版本的方法，那么会调用所有重载的方法。

源码如下:

~~~java
    @Test
    void test1()
    {
        System.out.println("this is step 1");
    }
    @Test(dependsOnMethods = "test3")
    void test2()
    {
        System.out.println("this is step 2");
    }
    @Test
    void test3()
    {
        System.out.println("this is step 3");
    }
~~~

xml如下:

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestDemo5" >
    <test name="TestDemo5">
        <classes>
            <class name="com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo5" >
            </class>
        </classes>
    </test>
</suite>
~~~

执行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\Desktop\GitHub\TestNG\TestNG\TestNG-demo\testng-demo-simple\src\test\java\com\dcits\testng_demo\basicAnnotation\at_Test\TestDemo5.xml
this is step 1
this is step 3
this is step 2

===============================================
TestDemo5
Total tests run: 3, Failures: 0, Skips: 0
===============================================
~~~



##### 6).@Test(dependsOnGroups = "")

> 定义组之间的依赖关系，可使用正则表达式作为参数。
>
> dependsOnMethods/dependsOnGroups控制优先级最高

**源码如下：**

~~~java
    @Test(dependsOnGroups = "2")
    void test1()
    {
        System.out.println("1");
    }
    @Test(dependsOnMethods = "test3",groups = "2")
    void test2()
    {
        System.out.println("2");
    }
    @Test(groups = "2")
    void test3()
    {
        System.out.println("3");
    }
~~~

执行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
3
2
1

===============================================
Default Suite
Total tests run: 3, Failures: 0, Skips: 0
===============================================
~~~



如果依赖的方法或者组执行失败，那么就会跳过该测试方法:

源码如下:

~~~java
    @Test(dependsOnGroups = "2")
    void test1()
    {
        System.out.println("1");
    }

    @Test(dependsOnMethods = "test3",groups = "2")
    void test2()
    {
        System.out.println("2");
    }

    @Test(groups = "2")
    void test3()
    {
        Assert.assertEquals(1,2);
        System.out.println("3");
    }
    
    @Test
    void test4()
    {
        System.out.println("4");
    }
~~~

xml配置如下:

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestDemo6" >
    <test name="TestDemo6" preserve-order="true">
        <classes>
            <class name="com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo6" >
                <methods>
                    <include name="test*"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\Desktop\GitHub\TestNG\TestNG\TestNG-demo\testng-demo-simple\src\test\java\com\dcits\testng_demo\basicAnnotation\at_Test\TestDemo6.xml

java.lang.AssertionError: expected [2] but found [1]
Expected :2
Actual   :1
 <Click to see difference>


	at org.testng.Assert.fail(Assert.java:94)
	at org.testng.Assert.failNotEquals(Assert.java:494)
	at org.testng.Assert.assertEquals(Assert.java:123)
	at org.testng.Assert.assertEquals(Assert.java:370)
	at org.testng.Assert.assertEquals(Assert.java:380)
	at com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo6.test3(TestDemo6.java:28)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:84)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:714)
	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)
	at org.testng.TestRunner.privateRun(TestRunner.java:767)
	at org.testng.TestRunner.run(TestRunner.java:617)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:334)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)
	at org.testng.SuiteRunner.run(SuiteRunner.java:240)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1224)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1149)
	at org.testng.TestNG.run(TestNG.java:1057)
	at org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)
	at org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)

4

Test ignored.

Test ignored.

===============================================
TestDemo6
Total tests run: 4, Failures: 1, Skips: 2
===============================================
~~~

可以看到只有test4正常执行，其他全部跳过



##### 7).@Test(timeOut = (Long))

> 设定超时时间（单位为ms），如果执行测试超过该设定时间，则当做失败处理。

源码如下:

~~~java
    @Test(timeOut = 500)
    void test1() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("successful");
    }
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml

org.testng.internal.thread.ThreadTimeoutException: Method org.testng.internal.TestNGMethod.test1() didn't finish within the time-out 500

	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)


===============================================
Default Suite
Total tests run: 1, Failures: 1, Skips: 0
===============================================
~~~

##### 8).@Test(invocationCount = (int))

> 表示执行的次数。

源码如下:

~~~java
    int i=0;
    @Test(invocationCount = 10)
    void test1()
    {
        System.out.println(i++);
    }
~~~

结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
0
1
2
3
4
5
6
7
8
9

===============================================
Default Suite
Total tests run: 10, Failures: 0, Skips: 0
===============================================
~~~

##### 9).@Test(invocationTimeOut = long)

> 该属性和invocationCount结合使用才会工作，耗时值不能超过设置的最大毫秒数。

源码如下:

~~~java
    int time=0;
    @Test(invocationCount = 10,invocationTimeOut = 1000)
    void test1() throws InterruptedException {
        time+=200;
        Thread.sleep(time);
        System.out.println(time);
    }
~~~

结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
200
400

org.testng.internal.thread.ThreadTimeoutException: Method org.testng.internal.TestNGMethod.test1() didn't finish within the time-out 1000

	at java.util.concurrent.ThreadPoolExecutor.tryTerminate(ThreadPoolExecutor.java:716)
	at java.util.concurrent.ThreadPoolExecutor.processWorkerExit(ThreadPoolExecutor.java:1014)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)


===============================================
Default Suite
Total tests run: 1, Failures: 1, Skips: 0
===============================================
~~~

##### 10).@Test(threadPoolSize = int)

> 表示线程池的内线程的个数。表示有多少个线程执行该方法

源码如下:

~~~java
    int i=0;
    @Test(threadPoolSize = 3,invocationCount = 10)
    void test1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"                   "+Thread.currentThread().getId()+":  "+i++);
    }
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
TestNG  13:  1
TestNG  11:  2
TestNG  12:  0
TestNG  13:  3
TestNG  11:  4
TestNG  13:  5
TestNG  13:  6
TestNG  11:  7
TestNG  11:  8
TestNG  12:  9

===============================================
Default Suite
Total tests run: 10, Failures: 0, Skips: 0
===============================================
~~~



##### 11).@Test(successPercentage = int)

> 当前方法执行所期望的success的百分比。如下所示，执行10次，如果成功9次，则认为测试通过。

源码如下:

~~~java
    @Test(successPercentage = 5,invocationCount = 10)
    void test1()
    {
        Assert.assertEquals(1,1);
    }
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml

===============================================
Default Suite
Total tests run: 10, Failures: 0, Skips: 0
===============================================
~~~



##### 12).@Test(alwaysRun=true)

> 如果为true，则该测试方法依然会被运行即使其所依赖的方法执行失败。为false的话，则该测试方法会被skip如果其所依赖的方法执行失败。

源码如下:

~~~java
    @Test(dependsOnMethods ="test2",alwaysRun = true)
    void test1()
    {
        System.out.println(1);
    }
    @Test
    void test2()
    {
        System.out.println(2);
        throw new RuntimeException();
    }
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
2

java.lang.RuntimeException
	at com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo12.test2(TestDemo12.java:22)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:84)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:714)
	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)
	at org.testng.TestRunner.privateRun(TestRunner.java:767)
	at org.testng.TestRunner.run(TestRunner.java:617)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:334)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)
	at org.testng.SuiteRunner.run(SuiteRunner.java:240)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1224)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1149)
	at org.testng.TestNG.run(TestNG.java:1057)
	at org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)
	at org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)

1

===============================================
Default Suite
Total tests run: 2, Failures: 1, Skips: 0
===============================================
~~~

##### 13).@Test(expectedExceptions=Exception.class)

源码如下:

~~~java
    @Test(expectedExceptions = ArithmeticException.class)
    public void test1() {
        System.out.println("test1!");
        int c = 1/0;
        Assert.assertEquals("1", "1");
    }
~~~

运行如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
test1!

===============================================
Default Suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================
~~~

##### 14).@Test(expectedExceptionsMessageRegExp = ".*zero")

> 异常信息正则表达式。以下测试执行通过。

源码如下:

~~~java
@Test(expectedExceptions = ArithmeticException.class,expectedExceptionsMessageRegExp = ".*zero")
    public void test1()
    {
        System.out.println("test1");
        int c = 1/0;
        Assert.assertEquals("1", "1");
    }
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
test1

===============================================
Default Suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================
~~~



##### 15).@Test(dataProvider = "provider")

> 如果需要传递复杂参数或需要从Java创建的参数（复杂对象，从属性文件或数据库读取的对象等等），则在testng.xml中指定参数可能不够。 在这种情况下，您可以使用数据提供程序提供测试所需的值。 数据提供程序是类上的一个方法，它返回一组对象数组。 此方法使用@DataProvider注释：

![](C:\Users\lenovo\Desktop\GitHub\TestNG\TestNG\image\dataProvider.png)

> 结合@DataProvider使用

源码如下:

~~~java
    @Test(dataProvider = "provider")
    public void test1(String msg1, String msg2) {
        System.out.println(msg1 + " " + msg2);
    }

    @DataProvider(name = "provider")
    public Object[][] dataProvide() {
        return new Object[][]{{"hello", "world"}, {"sing it stronger", "sing it together"}};
    }
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
hello world
sing it stronger sing it together

===============================================
Default Suite
Total tests run: 2, Failures: 0, Skips: 0
===============================================
~~~



##### 16).@Test(dataProviderClass =xxx.class)

> @Test方法使用dataProvider属性指定其数据提供程序。 此名称必须对应于使用匹配名称注释@DataProvider（name =“...”）
> 默认情况下，将在当前测试类或其中一个基类中查找数据提供方法。 如果要将数据提供程序放在不同的类中，则需要使用静态方法或具有非arg构造函数的类，并指定可在dataProviderClass属性中找到的类：

源码如下:

TestDemo16.class:

~~~java
public class TestDemo16 {
    @Test(dataProviderClass = StaticProvider.class,dataProvider = "numbers")
    public void test1(int a,int b)
    {
        System.out.println(a+"  "+b);
    }
}
~~~

StaticProvider.class:

~~~java
public class StaticProvider
{
    @DataProvider(name = "numbers")
    public static Object[][] provider()
    {
        return new Object[][]{
                {1,2},
                {2,3},
                {3,4},
        };
    }
}
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
1  2
2  3
3  4

===============================================
Default Suite
Total tests run: 3, Failures: 0, Skips: 0
===============================================
~~~



##### 17).@Test(priority = int)

> 标注测试方法的优先级。较低的优先级将优先执行。
>
> 默认为0

源码如下:

~~~java
    @Test(priority = 3)
    public void test1()
    {
        System.out.println(1);
    }
    @Test(priority = 2)
    public void test2()
    {
        System.out.println(2);
    }
    @Test(priority = 1)
    public void test3()
    {
        System.out.println(3);
    }
    @Test(priority = 0)
    public void test4()
    {
        System.out.println(4);
    }
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
4
3
2
1

===============================================
Default Suite
Total tests run: 4, Failures: 0, Skips: 0
===============================================
~~~

##### 18).@Test(ignoreMissingDependencies = true)

没有该注解:

源码:

~~~java
    @Test(dependsOnMethods = "hello")
    public void test2()
    {
        System.out.println("错误输出");
    }
~~~

运行结果如下:

~~~java
org.testng.TestNGException: 
com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo18.test2() depends on nonexistent method hello
	at org.testng.internal.MethodHelper.findDependedUponMethods(MethodHelper.java:114)
	at org.testng.internal.MethodHelper.topologicalSort(MethodHelper.java:240)
	at org.testng.internal.MethodHelper.sortMethods(MethodHelper.java:317)
	at org.testng.internal.MethodHelper.collectAndOrderMethods(MethodHelper.java:59)
	at org.testng.TestRunner.initMethods(TestRunner.java:481)
	at org.testng.TestRunner.init(TestRunner.java:235)
	at org.testng.TestRunner.init(TestRunner.java:205)
	at org.testng.TestRunner.<init>(TestRunner.java:153)
	at org.testng.SuiteRunner$DefaultTestRunnerFactory.newTestRunner(SuiteRunner.java:522)
	at org.testng.SuiteRunner.init(SuiteRunner.java:157)
	at org.testng.SuiteRunner.<init>(SuiteRunner.java:111)
	at org.testng.TestNG.createSuiteRunner(TestNG.java:1299)
	at org.testng.TestNG.createSuiteRunners(TestNG.java:1286)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1140)
	at org.testng.TestNG.run(TestNG.java:1057)
	at org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)
	at org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)

Process finished with exit code -1
Empty test suite.

~~~

 有该注解:

源码：

~~~java
    @Test(dependsOnMethods = "hello",ignoreMissingDependencies = true)
    public void test1()
    {
        System.out.println("正常输出");
    }
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml
正常输出

===============================================
Default Suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================

~~~



##### 19).@Test(skipFailedInvocations = true)

> 需要与invocationCount配合使用，并且invocationCount>1,当运行到某一次错误执行后，抛出当前异常
>
> 跳过剩下的次数

源码:

~~~java
    Random random=new Random();
    @Test(invocationCount = 10,skipFailedInvocations = true)
    public void test1()
    {
        int i=random.nextInt(2);
        Assert.assertEquals(i,1);
    }
~~~

运行结果如下:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml

java.lang.AssertionError: expected [1] but found [0]
Expected :1
Actual   :0
 <Click to see difference>


	at org.testng.Assert.fail(Assert.java:94)
	at org.testng.Assert.failNotEquals(Assert.java:494)
	at org.testng.Assert.assertEquals(Assert.java:123)
	at org.testng.Assert.assertEquals(Assert.java:370)
	at org.testng.Assert.assertEquals(Assert.java:380)
	at com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo19.test1(TestDemo19.java:19)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:84)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:714)
	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)
	at org.testng.TestRunner.privateRun(TestRunner.java:767)
	at org.testng.TestRunner.run(TestRunner.java:617)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:334)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)
	at org.testng.SuiteRunner.run(SuiteRunner.java:240)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1224)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1149)
	at org.testng.TestNG.run(TestNG.java:1057)
	at org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)
	at org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)


Test ignored.

Test ignored.

Test ignored.

Test ignored.

Test ignored.

Test ignored.

Test ignored.

Test ignored.

Test ignored.

===============================================
Default Suite
Total tests run: 1, Failures: 1, Skips: 0
===============================================
~~~



##### 20).@Test(retryAnalyzer = xxx.class)

> 当某些测试用例不可重现时，我们可以通过retryAnalyzer来进行错误测试用例重试

源码如下:

TestDemo20.class

~~~java
public class TestDemo20 {

    @Test(retryAnalyzer= OverrideRetry.class)
    public void test1(){
        System.out.println(1/0);
    }
}
~~~

OverrideRetry.class

~~~java
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class OverrideRetry implements IRetryAnalyzer {
    private int count = 1;
    private int max_retry_count = 3;

    /*
     * OverrideRetry实现接口IRetryAnalyzer的方法，重复执行失败用例
     * (non-Javadoc)
     * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        System.out.println("执行用例：" + iTestResult.getName() + "，第" + count + "次失败");
        if (count < max_retry_count) {
            count++;
            return true;
        }
        return false;
    }
}
~~~

运行结果:

~~~java
[TestNG] Running:
  C:\Users\lenovo\.IntelliJIdea2018.2\system\temp-testng-customsuite.xml

java.lang.ArithmeticException: / by zero

	at com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo20.test1(TestDemo20.java:13)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:84)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:714)
	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)
	at org.testng.TestRunner.privateRun(TestRunner.java:767)
	at org.testng.TestRunner.run(TestRunner.java:617)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:334)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)
	at org.testng.SuiteRunner.run(SuiteRunner.java:240)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1224)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1149)
	at org.testng.TestNG.run(TestNG.java:1057)
	at org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)
	at org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)

执行用例：test1，第1次失败

java.lang.ArithmeticException: / by zero

	at com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo20.test1(TestDemo20.java:13)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:84)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:714)
	at org.testng.internal.Invoker.retryFailed(Invoker.java:1049)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1254)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)
	at org.testng.TestRunner.privateRun(TestRunner.java:767)
	at org.testng.TestRunner.run(TestRunner.java:617)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:334)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)
	at org.testng.SuiteRunner.run(SuiteRunner.java:240)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1224)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1149)
	at org.testng.TestNG.run(TestNG.java:1057)
	at org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)
	at org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)

执行用例：test1，第2次失败

java.lang.ArithmeticException: / by zero

	at com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo20.test1(TestDemo20.java:13)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:84)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:714)
	at org.testng.internal.Invoker.retryFailed(Invoker.java:1049)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1254)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)
	at org.testng.TestRunner.privateRun(TestRunner.java:767)
	at org.testng.TestRunner.run(TestRunner.java:617)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:334)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)
	at org.testng.SuiteRunner.run(SuiteRunner.java:240)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1224)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1149)
	at org.testng.TestNG.run(TestNG.java:1057)
	at org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)
	at org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)

执行用例：test1，第3次失败
===============================================
Default Suite
Total tests run: 3, Failures: 3, Skips: 0
===============================================
~~~

该方法可能有大量重复工作，简化工作，进行自动化对失败用例生成:

> ###### [TestNG 强大的测试框架(6)-接口IRetryAnalyzer，失败用例重复执行](https://www.cnblogs.com/jinjiezhilu/p/6856742.html)



##### 21).@Test(singleThreaded = true)

> 如果设置为true，那么这个测试类中的所有方法都保证在同一个线程中运行，即使测试当前使用parallel="methods"运行。这个属性只能在类级别使用，如果在方法级别使用，它将被忽略。

xml文件配置:

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestDemo21"  parallel="methods">  //根据类中方法个数启动多少个线程去运行
    <test name="TestDemo21">
        <classes>
            <class name="com.dcits.testng_demo.basicAnnotation.at_Test.TestDemo21"></class>
        </classes>
    </test>
</suite>
~~~

没有配置该注解:

~~~java
public class TestDemo21 {
    volatile static int i=0;
    @Test(invocationCount = 10)
    public void test1()
    {
        System.out.println(Thread.currentThread().getName()+"  "+Thread.currentThread().getId()+":  "+i++);
    }
    @Test(invocationCount = 10)
    public void test2()
    {
        System.out.println(Thread.currentThread().getName()+"  "+Thread.currentThread().getId()+":  "+i++);
    }
}
~~~

运行结果:

~~~java
[TestNG] Running:
  C:\Users\lenovo\Desktop\GitHub\TestNG\TestNG\TestNG-demo\testng-demo-simple\src\test\java\com\dcits\testng_demo\basicAnnotation\at_Test\TestDemo21.xml
pool-1-thread-2  12:  0
pool-1-thread-2  12:  1
pool-1-thread-2  12:  2
pool-1-thread-1  11:  3
pool-1-thread-2  12:  4
pool-1-thread-1  11:  5
pool-1-thread-1  11:  6
pool-1-thread-2  12:  7
pool-1-thread-1  11:  8
pool-1-thread-2  12:  9
pool-1-thread-1  11:  10
pool-1-thread-2  12:  11
pool-1-thread-1  11:  12
pool-1-thread-2  12:  13
pool-1-thread-1  11:  14
pool-1-thread-2  12:  15
pool-1-thread-1  11:  16
pool-1-thread-2  12:  17
pool-1-thread-1  11:  18
pool-1-thread-1  11:  19

===============================================
TestDemo21
Total tests run: 20, Failures: 0, Skips: 0
===============================================
~~~

当启用该注解:

~~~java
@Test(singleThreaded = true)
public class TestDemo21 {
    volatile static int i=0;
    @Test(invocationCount = 10)
    public void test1()
    {
        System.out.println(Thread.currentThread().getName()+"  "+Thread.currentThread().getId()+":  "+i++);
    }
    @Test(invocationCount = 10)
    public void test2()
    {
        System.out.println(Thread.currentThread().getName()+"  "+Thread.currentThread().getId()+":  "+i++);
    }
}
~~~

运行结果:

~~~java
[TestNG] Running:
  C:\Users\lenovo\Desktop\GitHub\TestNG\TestNG\TestNG-demo\testng-demo-simple\src\test\java\com\dcits\testng_demo\basicAnnotation\at_Test\TestDemo21.xml
pool-1-thread-1  11:  0
pool-1-thread-1  11:  1
pool-1-thread-1  11:  2
pool-1-thread-1  11:  3
pool-1-thread-1  11:  4
pool-1-thread-1  11:  5
pool-1-thread-1  11:  6
pool-1-thread-1  11:  7
pool-1-thread-1  11:  8
pool-1-thread-1  11:  9
pool-1-thread-1  11:  10
pool-1-thread-1  11:  11
pool-1-thread-1  11:  12
pool-1-thread-1  11:  13
pool-1-thread-1  11:  14
pool-1-thread-1  11:  15
pool-1-thread-1  11:  16
pool-1-thread-1  11:  17
pool-1-thread-1  11:  18
pool-1-thread-1  11:  19

===============================================
TestDemo21
Total tests run: 20, Failures: 0, Skips: 0
===============================================
~~~

##### 22).@Test(suiteName="")

> 测试套件名称。



##### 23).@Test(testName="")

> 测试名称，跟description属性作用类似。

