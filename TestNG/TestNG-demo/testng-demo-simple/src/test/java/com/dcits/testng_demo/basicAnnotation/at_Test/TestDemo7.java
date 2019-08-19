package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用注解 @Test(timeOut = Long)
 */
@Test
public class TestDemo7 {
    @Test(timeOut = 500)
    void test1() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("successful");
    }
}
