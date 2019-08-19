package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用@Test(alwaysRun=true)
 */

@Test
public class TestDemo12
{
    @Test(dependsOnMethods ="test2",alwaysRun = true)
    void test1()
    {
        System.out.println(1);
    }
    @Test
    void test2()
    {
        System.out.println(2);
        throw new RuntimeException();
    }
}
