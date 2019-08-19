package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用@Test(expectedExceptions=Exception.class)
 */
public class TestDemo13 {
    @Test(expectedExceptions = ArithmeticException.class)
    public void test1() {
        System.out.println("test1!");
        int c = 1/0;
        Assert.assertEquals("1", "1");
    }
}
