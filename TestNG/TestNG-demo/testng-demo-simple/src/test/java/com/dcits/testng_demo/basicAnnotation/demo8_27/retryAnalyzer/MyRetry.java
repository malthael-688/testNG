package com.dcits.testng_demo.basicAnnotation.demo8_27.retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Malthael
 * @date 2019/8/22
 */
public class MyRetry implements IRetryAnalyzer {
    private int count = 1;
    private int max = 10;

    public boolean retry(ITestResult iTestResult) {
        if (count < max) {
            System.out.println("重试：" + iTestResult.getName() + "，第" + count + "次失败");
            count++;
            return true;
        }
        count = 1;
        return false;
    }
}
