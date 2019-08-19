package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用 @Test(threadPoolSize = 3,invocationCount = 10)
 */
@Test
public class TestDemo10 {
    int i=0;
    @Test(threadPoolSize = 3,invocationCount = 10)
    void test1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"  "+Thread.currentThread().getId()+":  "+i++);
    }
}
