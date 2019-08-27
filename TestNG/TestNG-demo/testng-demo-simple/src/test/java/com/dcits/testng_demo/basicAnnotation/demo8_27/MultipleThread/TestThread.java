package com.dcits.testng_demo.basicAnnotation.demo8_27.MultipleThread;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/27
 */
public class TestThread {
    @Test(invocationCount = 100,threadPoolSize = 3)
    public void test1()
    {
        System.out.println("test1:"+"线程名称:"+Thread.currentThread().getName()+"\t线程ID:"+Thread.currentThread().getId());
}



    @Test(invocationCount = 100,threadPoolSize = 3)
    public void test2()
    {
        System.out.println("test2:"+"线程名称:"+Thread.currentThread().getName()+"\t线程ID:"+Thread.currentThread().getId());
    }



    @Test(invocationCount = 100,threadPoolSize = 3)
    public void test3()
    {
        System.out.println("test3:"+"线程名称:"+Thread.currentThread().getName()+"\t线程ID:"+Thread.currentThread().getId());
    }
}
