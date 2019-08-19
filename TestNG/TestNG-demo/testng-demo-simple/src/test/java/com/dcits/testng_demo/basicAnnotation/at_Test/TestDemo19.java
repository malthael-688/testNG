package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Malthael
 * @date 2019/8/19
 *,
 */
public class TestDemo19 {
    Random random=new Random();
    @Test(invocationCount = 10,skipFailedInvocations = true)
    public void test1()
    {
        int i=random.nextInt(2);
        Assert.assertEquals(i,1);
    }
}
