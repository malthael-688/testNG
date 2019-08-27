package com.dcits.testng_demo.basicAnnotation.demo8_27.invocation;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用@Test(invocationCount = 10,invocationTimeOut = 1000)
 */
@Test
public class TestDemo9 {
    int time=0;
    @Test(invocationCount = 10,invocationTimeOut = 1000)
    public void test1() throws InterruptedException {
        time+=200;
        Thread.sleep(time);
        System.out.println(time);
    }
}
