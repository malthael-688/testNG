package listenAndselect.methodSelect;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * public interface IMethodInterceptor extends ITestNGListener {
 *     List<IMethodInstance> intercept(List<IMethodInstance> var1, ITestContext var2);
 * }
 */
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class Select implements IMethodInterceptor {
    public List<IMethodInstance> intercept(List<IMethodInstance> methodInstances, ITestContext context) {
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();

        for (IMethodInstance methodInstance : methodInstances) {
            ITestNGMethod method = methodInstance.getMethod();
            Set<String> groups = new HashSet<String>();

            if (method.isTest()) { //如果是@Test注解
                for (String group : method.getGroups()) {
                    groups.add(group);  //获取@Test注解的所有组
                }
            }

            if (groups.contains("diao"))  //只运行grp1组
                result.add(methodInstance);
        }

        return result;
    }
}
