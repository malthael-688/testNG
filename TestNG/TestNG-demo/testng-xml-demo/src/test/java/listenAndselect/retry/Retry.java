package listenAndselect.retry;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class Retry implements IRetryAnalyzer {

    private static int retryCount = 1;
    private static int maxRetryCount = 3;//最大重试次数

    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxRetryCount && iTestResult.getThrowable() instanceof ArrayIndexOutOfBoundsException){
            //判断用例执行中抛出的异常如果属于链接超时异常的子类，就重试三次；此处判断条件可根据自身需求来设定重试的条件
            retryCount++;
            return true;
        }
        return false;
    }
}