package com.dcits.defaultReport;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Malthael
 * @date 2019/8/22
 */
@Test(description = "随机测试")
public class TestDefaultReport {
    Random random=new Random();
    @Test(alwaysRun = true,invocationCount = 1000,description = "随机01")
    public void test1()
    {
        Assert.assertEquals(random.nextInt(1),0);
        Reporter.getOutput();
    }

    @Test(description = "多线程随机运行",threadPoolSize = 10,invocationCount = 1000,timeOut = 10,alwaysRun = true)
    public void test2() throws InterruptedException {
        Thread.sleep(random.nextInt(15));
    }

    @Test(description = "错误重试",retryAnalyzer = MyRetry.class,invocationCount = 1000)
    public void test3()
    {
        int a=random.nextInt(1);
        Assert.assertEquals(a,0);
        Reporter.getCurrentTestResult();
    }

    @Test(description = "跳过测试",invocationCount = 1000,skipFailedInvocations = true)
    public void test4()
    {
        int b=random.nextInt(1);
        Assert.assertEquals(b,1);
    }
}
