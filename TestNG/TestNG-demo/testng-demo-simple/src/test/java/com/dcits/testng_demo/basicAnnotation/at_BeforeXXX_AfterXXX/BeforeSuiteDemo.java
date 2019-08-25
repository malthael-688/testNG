package com.dcits.testng_demo.basicAnnotation.at_BeforeXXX_AfterXXX;

import org.testng.annotations.*;

/**
 * @author Malthael
 * @date 2019/8/25
 */
public class BeforeSuiteDemo {
    @Test
    public void test2()
    {
        System.out.println("2在运行中");
    }

    @Test(dependsOnMethods = "test2")
    public void test1()
    {
        System.out.println("1在运行中");
    }
    @BeforeMethod
    @BeforeSuite
    @Test(dependsOnMethods = "test1")
    public void test3()
    {
        System.out.println("在suit之前运行");
    }
}
