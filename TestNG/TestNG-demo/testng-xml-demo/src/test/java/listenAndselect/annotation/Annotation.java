package listenAndselect.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IAnnotationTransformer2;
import org.testng.annotations.ITestAnnotation;
/**
 * public interface IAnnotationTransformer extends ITestNGListener{
 *
 * This method will be invoked by TestNG to give you a chance
 * to modify a TestNG annotation read from your test classes.
 * You can change the values you need by calling any of the
 * setters on the ITest interface.
 *
 * Note that only one of the three parameters testClass,
 * testConstructor and testMethod will be non-null.
 *
 * *@param annotation The annotation that was read from your
 * test class.
 * *@param testClass If the annotation was found on a class, this
 * parameter represents this class (null otherwise).
 * *@param testConstructor If the annotation was found on a constructor,
 * this parameter represents this constructor (null otherwise).
 * *@param testMethod If the annotation was found on a method,
 * this parameter represents this method (null otherwise).
 * public interface IAnnotationTransformer extends ITestNGListener {
 *     void transform(ITestAnnotation var1, Class var2, Constructor var3, Method var4);
 * }
 */
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class Annotation implements IAnnotationTransformer {
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setInvocationCount(2); //执行2次
        if(method.getName().equals("test1"))
            iTestAnnotation.setEnabled(false);
    }
}
