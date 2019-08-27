package listenAndselect.ihookable;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class ihook implements IHookable {
    public void run(IHookCallBack callBack, ITestResult testResult){

        if (testResult.getName()=="test1")
        {
            System.out.println("使用了IHookable:"+testResult.getName());
            callBack.runTestMethod(testResult);
        }else
            callBack.runTestMethod(testResult);

    }
}
