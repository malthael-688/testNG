package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用 @Test(successPercentage = 5)
 */
@Test
public class TestDemo11{
    @Test(successPercentage = 5,invocationCount = 10)
    void test1()
    {
        Assert.assertEquals(1,1);
    }
}