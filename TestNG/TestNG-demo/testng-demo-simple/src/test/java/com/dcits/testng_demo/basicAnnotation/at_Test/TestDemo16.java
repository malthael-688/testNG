package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用@Test(dataProviderClass =xxx.class)
 */
public class TestDemo16 {
    @Test(dataProviderClass = StaticProvider.class,dataProvider = "numbers")
    public void test1(int a,int b)
    {
        System.out.println(a+"  "+b);
    }
}

