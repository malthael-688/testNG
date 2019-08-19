package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用Test(dependsOnMethods = "")
 */
@Test
public class TestDemo5 {
    @Test
    void test1()
    {
        System.out.println("this is step 1");
    }
    @Test(dependsOnMethods = "test3")
    void test2()
    {
        System.out.println("this is step 2");
    }
    @Test
    void test3()
    {
        System.out.println("this is step 3");
    }
}
