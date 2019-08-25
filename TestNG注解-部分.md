# TestNG 注解（部分） 详解

#### @listener

以下是 TestNG 提供的几种监听器：

- IAnnotationTransformer
- IAnnotationTransformer2
- IHookable
- IInvokedMethodListener
- IMethodInterceptor
- IReporter
- ISuiteListener
- ITestListener

尽管名字叫监听器，但事实上它们只是一些预定义的 Java 接口。用户创建这些接口的实现类，并把它们加入到 TestNG 中，TestNG 便会在测试运行的不同时刻调用这些类中的接口方法。接下来，一一介绍 TestNG 中的每种监听器。

###### IAnnotationTransformer

```java
package org.testng;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.annotations.ITestAnnotation;

public interface IAnnotationTransformer extends ITestNGListener {
   /**
   * This method will be invoked by TestNG to give you a chance
   * to modify a TestNG annotation read from your test classes.
   * You can change the values you need by calling any of the
   * setters on the ITest interface.
   *
   * Note that only one of the three parameters testClass,
   * testConstructor and testMethod will be non-null.
   *
   * @param annotation The annotation that was read from your
   * test class.
   * @param testClass If the annotation was found on a class, this
   * parameter represents this class (null otherwise).
   * @param testConstructor If the annotation was found on a constructor,
   * this parameter represents this constructor (null otherwise).
   * @param testMethod If the annotation was found on a method,
   * this parameter represents this method (null otherwise).
   */
    void transform(ITestAnnotation var1, Class var2, Constructor var3, Method var4);
}
```

只能修改@Test注解，其他注解修改要使用IAnnotationTransformer2。

###### IAnnotationTransformer2
源码：
```java
package org.testng;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;

public interface IAnnotationTransformer2 extends IAnnotationTransformer {
    void transform(IConfigurationAnnotation var1, Class var2, Constructor var3, Method var4);

    void transform(IDataProviderAnnotation var1, Method var2);

    void transform(IFactoryAnnotation var1, Method var2);
}
```
测试类如下：
```java
import org.testng.annotations.Test;

public class TestTransform {
    private String str;
    public TestTransform(String str){
        this.str = str;
    }

    @Test()
    public void test(){
        System.out.println("Test annotationTransformer!");
        System.out.println("DataProviderName:"+str);
    }
}
```

监听器实现类如下：

```java
import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Transform2 implements IAnnotationTransformer2 {

    public void transform(IConfigurationAnnotation iConfigurationAnnotation, Class aClass, Constructor constructor, Method method) {
    }

    public void transform(IDataProviderAnnotation iDataProviderAnnotation, Method method) {
        if (iDataProviderAnnotation.getName().equals("tom"))  //匹配名为data的DataProvider
            iDataProviderAnnotation.setParallel(true); //设置并行
    }

    public void transform(IFactoryAnnotation iFactoryAnnotation, Method method) {
        iFactoryAnnotation.setDataProvider("data"); 
    }

    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
    }
}
```

工厂类如下：

```java

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class TransformFactory {
    @Factory(dataProvider = "tom")
    public Object[] transformFac(String str){
        Object[] objects = new Object[1];
        for(int i=0;i<1;i++){
            TestTransform testTransform = new TestTransform(str);
            objects[i] = testTransform;
        }
        return objects;
    }

    @DataProvider(name = "tom")
    public Object[][] tom(){
        return new Object[][]{new Object[]{"tom"}};
    }

    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][]{new Object[]{"data"}};
    }
}
```

xml配置如下：

```xml
<!--不使用监听器-->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="All Test Suite" >
    <test verbose="2" preserve-order="true" name="Test">
        <classes>
            <class name="TransformFactory">
            </class>
        </classes>
    </test>
</suite>

<!--使用监听器-->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="All Test Suite" >
    <listeners>
        <listener class-name="Transform2"/>
    </listeners>

    <test verbose="2" preserve-order="true" name="Test">
        <classes>
            <class name="TransformFactory">
            </class>
        </classes>
    </test>
</suite>
```

```xml
不使用listener结果如下：
Test annotationTransformer!
DataProviderName:tom

===============================================
Default Suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================
使用listener执行结果如下：
Test annotationTransformer!
DataProviderName:data

===============================================
All Test Suite
Total tests run: 1, Failures: 0, Skips: 0
===============================================

```

###### IHookable

在TestNG的执行过程中，有一种应用场景，就是根据当前执行的情况决定是否执行某个测试方法。即测试方法的执行有先决条件，满足条件则执行，否则就跳过执行。这种应用场景的典型应用是执行测试方法前进行授权检查，有授权则执行测试方法，没有授权则跳过执行。

IHookable监听器为这种应用场景提供了可能。IHookable监听器接口继承自ITestNGListener接口，其中定义了唯一的方法：

```java
package org.testng;

public interface IHookable extends ITestNGListener {
    void run(IHookCallBack var1, ITestResult var2);
}
```



在TestNG的执行一个测试方法之前，首先调用IHookable监听器的run()方法。如果满足执行测试方法的条件，则在run()方法中再通过callBack参数的runTestMethod()方法调用测试方法。

###### IInvokedMethodListener

与 IHookable 类似，IInvokedMethodListener 提供了类似与面向方面编程（AOP）中的 Before Advice 和 After Advice 的功能。它允许用户在当前测试方法被执行前和执行后注入特定的逻辑，比如，可以加入日志方法。用户需要实现的方法如下。

处理@Before*，@After等注释，详见demo中listeners。

这是对前后文的一个处理。

###### IMethodInterceptor

TestNG 启动之后，第一件要做的事情是将所有的测试方法分成两类：一类是顺序运行的测试方法；一类是没有特定运行顺序的测试方法。

TestNG 通过 @Test 注释中的 dependsOnGroups 和 dependsOnMethods 使用户能够定义测试方法之间的依赖关系。这种依赖关系也就决定这些测试方法必须按着怎样的顺序运行，这就是第一类。除此以外的便是第二类。对于第二类中的测试方法，尽管默认 TestNG 会尝试用类名将它们分组，但是理论上，它们的运行顺序是随机的，甚至每次运行的顺序都可能不同。因此为了使用户拥有对第二类测试方法更大的控制权，IMethodInterceptor 监听器产生了。

###### IReporter

TestNG 提供了默认的测试报表。但如果用户希望有不同格式的测试报表，就需要使用 IReporter 监听器。

生成定制化的报告，这个方法是一个测试执行完成之后执行的方法。

###### ISuiteListener

ISuiteListener 类似于 IInvokedMethodListener，区别是 IInvokedMethodListener 针对的是测试方法，而 ISuiteListener 针对的是测试套件。ISuiteListener 使用户有机会在测试套件开始执行以及执行结束之后嵌入自己的逻辑。该监听器要求实现的方法如下。

```java
public interface ISuite extends IAttributes {
    String getName();

    Map<String, ISuiteResult> getResults();

    IObjectFactory getObjectFactory();

    IObjectFactory2 getObjectFactory2();

    String getOutputDirectory();

    String getParallel();

    String getParentModule();

    String getGuiceStage();

    String getParameter(String var1);

    Map<String, Collection<ITestNGMethod>> getMethodsByGroups();

    /** @deprecated */
    @Deprecated
    Collection<ITestNGMethod> getInvokedMethods();

    List<IInvokedMethod> getAllInvokedMethods();

    Collection<ITestNGMethod> getExcludedMethods();

    void run();

    String getHost();

    SuiteRunState getSuiteState();

    IAnnotationFinder getAnnotationFinder();

    XmlSuite getXmlSuite();

    void addListener(ITestNGListener var1);

    Injector getParentInjector();

    void setParentInjector(Injector var1);

    List<ITestNGMethod> getAllMethods();
}
```



###### ITestListener

如果要在测试方法执行成功、失败或者跳过时指定不同后续行为，可以通过 IInvokedMethodListener 实现，不过更为简便的方式是利用 ITestListener 监听器。

```java
public interface ITest {
    String getTestName();
}
```



#### @dataProvider

返回类型有两种，一种"Object[ ] [ ]"数组的方式， 一种是Iterator<Object[]>迭代器模式。

```java
@DataProvider(name = "create")
  public static Object[][] createData() {
    return new Object[][] {
      new Object[] { new Integer(42) }
    };
  }
@DataProvider(name = "test1")
public Iterator<Object[]> createData() {
  return new MyIterator(DATA);
} 
```

当提供data的@DataProvider和@Test方法不在一个类和一个基类里面，方法必须写成static。

对于并发：

```java
@DataProvider(parallel = true)
------------分割线------------
<suite name="Suite1" data-provider-thread-count="20" >
```

在属性中可以通过parallel管理，线程池大小可以通过xml标签控制，默认大小为10。