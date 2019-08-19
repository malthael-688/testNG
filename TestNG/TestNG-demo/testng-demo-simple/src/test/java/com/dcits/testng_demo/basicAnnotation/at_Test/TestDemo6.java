package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简答使用@Test(dependsOnGroups = "")
 */
@Test(testName = "TestDemo6")
public class TestDemo6 {
    @Test(dependsOnGroups = "2")
    void test1()
    {
        System.out.println("1");
    }

    @Test(dependsOnMethods = "test3",groups = "2")
    void test2()
    {
        System.out.println("2");
    }

    @Test(groups = "2")
    void test3()
    {
        Assert.assertEquals(1,2);
        System.out.println("3");
    }

    @Test
    void test4()
    {
        System.out.println("4");
    }
}
