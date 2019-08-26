package com.dcits.testng_demo.basicAnnotation.at_Test;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * @author Malthael
 * @date 2019/8/19
 * 实现retryAnalyzer注解必须要实现接口IRetryAnalyzer
 */
public class OverrideRetry implements IRetryAnalyzer {
    private int count = 1;
    private int max_retry_count = 5;

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
        count=1;
        return false;
    }
}