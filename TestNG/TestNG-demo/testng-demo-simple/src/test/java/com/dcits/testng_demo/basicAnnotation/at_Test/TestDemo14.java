package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用@Test(expectedExceptionsMessageRegExp = ".*zero")
 */
public class TestDemo14 {
    @Test(expectedExceptions = ArithmeticException.class,expectedExceptionsMessageRegExp = ".*zero")
    public void test1()
    {
        System.out.println("test1");
        int c = 1/0;
        Assert.assertEquals("1", "1");
    }
}
