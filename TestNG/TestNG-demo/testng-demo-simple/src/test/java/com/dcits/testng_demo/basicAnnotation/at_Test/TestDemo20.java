package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用@Test(retryAnalyzer= OverrideRetry.class)
 */
public class TestDemo20 {

    @Test(retryAnalyzer= OverrideRetry.class)
    public void test1(){
        System.out.println(1/0);
    }
}
