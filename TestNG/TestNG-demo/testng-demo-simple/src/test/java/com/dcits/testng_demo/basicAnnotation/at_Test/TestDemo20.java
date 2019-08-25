package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用@Test(retryAnalyzer= OverrideRetry.class)
 */
public class TestDemo20 {

    @Test(retryAnalyzer= OverrideRetry.class,invocationCount = 10)
    public void test1(){
        System.out.println(1/new Random().nextInt(1));
    }
}
