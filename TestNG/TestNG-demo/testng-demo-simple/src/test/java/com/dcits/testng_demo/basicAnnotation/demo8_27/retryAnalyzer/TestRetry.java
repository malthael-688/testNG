package com.dcits.testng_demo.basicAnnotation.demo8_27.retryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Malthael
 * @date 2019/8/27
 */
public class TestRetry {
    int i=1;
    @Test(invocationCount = 10,alwaysRun = true,retryAnalyzer = MyRetry.class)
    public void test1()
    {
        System.out.println("第"+i+"次运行test1");
        Assert.assertEquals(new Random().nextInt(2),1);
        i++;
    }
}
