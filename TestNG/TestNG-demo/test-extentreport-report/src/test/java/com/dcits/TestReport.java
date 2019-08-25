package com.dcits;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Malthael
 * @date 2019/8/22
 */
@Test(description = "随机测试")
public class TestReport {
    Random random=new Random();
    @Test(alwaysRun = true,invocationCount = 1000,description = "随机01")
    public void test1()
    {
        Reporter.log("开始随机测试");
        Assert.assertEquals(random.nextInt(1),0);
        Reporter.getOutput();
    }

    @Test(description = "多线程随机运行",threadPoolSize = 10,invocationCount = 1000,timeOut = 10,alwaysRun = true)
    public void test2() throws InterruptedException {
        Reporter.log("开始多线程随机运行");
        Thread.sleep(random.nextInt(15));
    }

    @Test(description = "错误重试",retryAnalyzer = MyRetry.class,invocationCount = 1000)
    public void test3()
    {
        Reporter.log("开始错误重试");
        int a=random.nextInt(1);
        Assert.assertEquals(a,0);
        Reporter.getCurrentTestResult();
    }

    @Test(description = "跳过测试",invocationCount = 1000,skipFailedInvocations = true)
    public void test4()
    {
        Reporter.log("开始跳过测试");
        int b=random.nextInt(1);
        Assert.assertEquals(b,1);
    }
}
