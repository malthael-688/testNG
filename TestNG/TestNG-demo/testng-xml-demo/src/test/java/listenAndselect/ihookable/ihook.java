package listenAndselect.ihookable;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class ihook implements IHookable {
    public void run(IHookCallBack callBack, ITestResult testResult){
        System.out.println("使用了IHookable:"+testResult.getName());
        callBack.runTestMethod(testResult);
    }
}
