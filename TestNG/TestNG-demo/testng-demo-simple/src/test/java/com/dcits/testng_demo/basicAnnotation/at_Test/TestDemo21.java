package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 */
@Test(singleThreaded = true)
public class TestDemo21 {
    volatile static int i=0;
    @Test(invocationCount = 10)
    public void test1()
    {
        System.out.println(Thread.currentThread().getName()+"  "+Thread.currentThread().getId()+":  "+i++);
    }
    @Test(invocationCount = 10)
    public void test2()
    {
        System.out.println(Thread.currentThread().getName()+"  "+Thread.currentThread().getId()+":  "+i++);
    }
}
