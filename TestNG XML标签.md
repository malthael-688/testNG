# TestNG 的 XML 标签

**整体文档结构如下**：

```xml
标签
|____属性1
| |____说明
| | |____说明（可能缺省）
|____属性2
| |____说明
| | |____说明（可能缺省）

```

## suit

一个xml里面只可以拥有一个suit，也就是说suit必须作为根元素，且suit标签不可以缺省。

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suit1" verbose="1" allow-return-values="false">
</suite>
```

### name

必须指定的属性，不可缺省！

name属性可以理解为唯一Id，在测试报告中会体现出现。

不同的xml可以将suit命名成一样的，但不推荐使用，容易引起混淆。

### verbose

可以缺省，一般默认为1。

取值范围为1 - 10，整形。其中1最为简略，10最为详尽。

是指生成的测试报告的详细程度。

### allow-return-values

可以缺省，默认为false。

类型为Boolean型，只能true或false。

使用示例：

```java
import org.testng.annotations.Test;
public class PrintShowOrder {
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public String test2(){
        System.out.println("Test 2");
        return "test2";
    }
}

```

在上述测试类中，有两个测试方法，区别在于，一个又返回类型，一个没有。

如果使用TestNG直接执行该测试类，会调用默认的xml文件，其中allow-return-values为false，会直接忽略Method : test2()。

如果希望该方法被执行，写法如下：

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

<suite name="Suit1" verbose="1" allow-return-values="true">
    <test name="someTestClass">
        <classes>
            <class name="PrintShowOrder" >
            </class>
        </classes>
    </test>
</suite>
```

### annotations

可以缺省，默认为jdk注解。

如果为"javadoc", 则使用javadoc注解，否则使用jdk注解

### configfailurepolicy

可以缺省，默认为skip。

字典：continue,skip

如果@Before*方法执行失败，TestNG是否应该继续执行套件中的其余测试，continue会继续执行；而skip会跳过后续需要执行的方法。

值得一提的是，此处skip跳过的方法不一定失败，也不一定成功，在测试报告中会被体现出来。

例子：configfailurepolicy.demoXML.xml & configfailurepolicy.skip.xml

### skipfailedinvocationcounts

可以缺省，默认为false。

true跳过失败的调用，但不影响@After*的调用；false则不跳过。

类比configfailurepolicy。

### parallel

可以缺省，默认为false。

字典：classes,methods,instances,tests,true,false。

```xml
<suit parallel="false"></suit> #表示不使用多线程运行

<suit parallel="true"></suit> #表示全部测试方法多线程运行

<suit parallel="classes"></suit> 
#testng将在同一个线程中运行同一个类中的所有方法，但是每个类将在单独的线程中运行。
#官方原文： TestNG will run all the methods in the same class in the same thread, but each class will be run in a separate thread.

<suit parallel="methods"></suit> 
#testng将在不同的线程中运行所有的测试方法。依赖方法也将在单独的线程中运行，但是它们将使用xml指定的顺序。
#官方原文：TestNG will run all your test methods in separate threads. Dependent methods will also run in separate threads but they will respect the order that you specified.

<suit parallel="tests"></suit> #表示不适用多线程运行
#testng将在同一个线程中的同一个< test >标记中运行所有方法，但是每个< test >标记都将在单独的线程中。这允许您在同一个< test >中将所有线程不安全的类分组，并保证它们都在同一个线程中运行，同时利用testng使用尽可能多的线程来运行您的测试。
#官方原文：TestNG will run all the methods in the same <test> tag in the same thread, but each <test> tag will be in a separate thread. This allows you to group all your classes that are not thread safe in the same <test> and guarantee they will all run in the same thread while taking advantage of TestNG using as many threads as possible to run your tests.
    
<suit parallel="instances"></suit> 
#testng将在同一个线程中运行同一个实例中的所有方法，但是两个不同实例上的两个方法将在不同的线程中运行。
#官方原文： TestNG will run all the methods in the same instance in the same thread, but two methods on two different instances will be running in different threads.
```

### thread-count

与parallel配套使用，可以缺省，默认为10。

表示线程池个数，只可以输入正整数，否则会出现初始化线程池错误。

tips：不要输入过大的数字，不然就是JVM和CPU的战争了。

tips2：创建线程的开销也应被考虑，同时线程安全是最重要的。

单独出现，不会报错，但是并没有并行测试，无意义。

### data-provider-thread-count

可以缺省，默认为10。

并发执行@data-provider的线程数，默认大小为10,其他与thread-count类似。

### time-out

可以缺省，默认没有时间限制，单位为ms。

类型为Long。

为具体执行单元设定一个超时时间，超时认为执行失败。

### preserve-order

可以缺省，默认为true。

布尔型，只能为true 或 false。

表示是否按顺序执行，如果按顺序执行，就按照指定的执行顺序执行；否则以不可预期的方式执行（一般是按字典排序的方式调用，但并不可靠。）

### group-by-instances

可以缺省，默认为false。

布尔类型，只能为true 或 false。

此项用于那些有依赖的方法，且被依赖的对象有多个重载对象，因为如果是依赖方法，且该方法有多个重载方法，则默认是会将所有重载方法都跑完再运行被依赖方法，但有时候我们不想这样，则将此项设置为true即可。

### junit

可以缺省，默认为false。

布尔类型，只能为true 或 false。

是否以junit模式运行

### guice-stage

可以缺省，默认DEVELOPMENT。

字典类型：DEVELOPMENT、PRODUCTION、TOOL。

创建父注入器的stage。

### object-factory

可以缺省，缺省默认没有。

用于实现IObjectFactory的类，实例化测试对象

### parent-module

可以缺省，默认没有。

用于创建所有guice注入器的父注入器的模块。

所有子类，可以获得父类的通用的绑定。



## suit-files

根标签，可以缺省。

在一个xml文件里面指定多个suit标签。

```xml
<suite-files>
        <suite-file path="testNG.xml"/>
        <suite-file path="testNG.xml"/>
</suite-files>
```

## test

放在<suit>标签下，例如：

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suit1" verbose="1">
    <test name="test1">
    </test>
    <test name="test2">
    </test>
</suite>
```

在一个<suit>标签下，可以拥有多个<test>标签，但是每个<test>的标签的name应该不一样。

### name

不可缺省。

这个测试的名称(将出现在报告中)，类似于id，同<suit name="">

### annotations

同suite套件属性

### allow-return-values

同suite套件属性

### verbose

同suite套件属性

### enabled

可以缺省，默认值为true。

启用/禁用当前测试的标志。为false时，该test标签不会被执行。

### group-by-instances

同suite套件属性

### junit

同suite套件属性

### parallel

同suite套件属性

### preserve-order

同suite套件属性

### skipfailedinvocationcounts

同suite套件属性

### thread-count

同suite套件属性

### time-out

同suite套件属性

## packages

有测试用例结构如下：

```xml
com
|____test
| |____demo
| | |____Demo.java
| | | |____func test1()
| |____demo2
| | |____Demo2.java

```

编写xml控制测试用例如下：
```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suit1" verbose="1" >
    <test name = "allTests" preserve-order="true">
        <packages>
            <package name="com.test.*">
            </package>
        </packages>
    </test>
    <test name = "someTests" preserve-order="true">
        <packages>
            <package name="com.test.demo">
            </package>
            <package name="com.test.demo2">
            </package>
        </packages>
    </test>
</suite>
```

<packages>标签在<test>下面，其下面可以添加多个<package>标签。

## package

<package> 只能放在<packages>下面，其下面可以添加<include>、<exclude>。

示例如下：
```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suit1" verbose="1" >
    <test name = "allTests" preserve-order="true">
        <packages>
            <package name="com.test.*">
                <include name="demo"></inclue>
                <exclude name="demo2"></exclude>
            </package>
        </packages>
    </test>
</suite>
```

## classes

类似packages。

放在<test>下面，下面可以添加<parameter>、<class>标签。

**不可以和<packages>同级出现**

## class

示例如下：

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suit1" verbose="1" >
    <test name = "allTests" preserve-order="true">
        <classes>
            <class name="demo.demo">
                <include name = "test1"></include>
            </class>        
        </classes>
    </test>
</suite>
```

此时，<include> <exclude>标签包含的是方法（Method）。

## groups

参考《TestNG使用指南.md》->基本注解->3.4@Test(groups ="")

假定目录结构如下：

```xml
groups
|____demo.java
| |____func grop1-test1()
| |____func grop2-test2()
| |____func grop3-test3()
| |____func grop4-test4()
```



```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite" verbose="1">

    <test name="TestNG1">
        <groups>
            <!--组中组，即test1包含了test2和test3两个组-->
            <define name="test1">
                <include name="test2"/>
                <include name="test3"/>
            </define>

            <!--运行test1组，不运行test2组-->
            <run>
                <include name="test1"/>
                <exclude name="test2"/>
            </run>

            <!--test3组依赖于test4组，多个依赖用空格隔开-->
            <dependencies>
                <group name="test3" depends-on="test4"/>
            </dependencies>
        </groups>
        <classes>
            <class name="groups.demo"></class>
        </classes>
    </test> <!-- TestNG -->
</suite>
```

注意，groups应该在<classes>的同级标签，不可以和<packages>同级，会找不到。

## listeners

可以缺省，缺省默认没有设置监听器。

放在<suit>标签下面，与<test>同级。

## listener

可以缺省，缺省默认没有设置监听器。

下面写监视器的类名。

示例如下：

```xml
<suite name = "TestNGSample">
    <listeners>
        <listener class-name="listeners.OSFilter" />
        <listener class-name="listeners.ProgressTracker" />
    </listeners>
    <test name="ProgressTracker Demo">
        <classes>
            <class name="tests.SampleTest" />
        </classes>
    </test>
</suite>
```

**值得注意的是：**

- 在 @Listeners 中添加监听器跟在 testng.xml 添加监听器一样，将被应用到整个测试套件中的测试方法。如果需要控制监听器的应用范围（比如添加的监听器仅使用于某些测试测试类或者某些测试方法），则必须在监听器类中编写适当的判断逻辑。
- 在 @Listeners 中添加监听器跟在 testng.xml 添加监听器的不同之处在于，它不能添加 IAnnotationTransformer 和 IAnnotationTransformer2 监听器。原因是因为这两种监听器必须在更早的阶段添加到 TestNG 中才能实施修改注释的操作，所以它们只能在 testng.xml 添加。
- TestNG 对添加的监听器不做去重判断。因此，如果 testng.xml 和源代码中添加了相同的监听器，该监听器的方法会被调用两次。有关这一点，大家可以通过运行本文附带的示例代码包中 testng.xml 验证。因此，切记，不要通过多种方式重复添加监听器。

