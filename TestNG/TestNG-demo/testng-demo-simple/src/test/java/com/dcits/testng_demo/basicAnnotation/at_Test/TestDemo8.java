package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用@Test(invocationCount = 10)
 */
@Test
public class TestDemo8 {
    int i=0;
    @Test(invocationCount = 10)
    void test1()
    {
        System.out.println(i++);
    }
}
