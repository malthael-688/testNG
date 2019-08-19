package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用 @Test(priority = 0)
 */
public class TestDemo17 {
    @Test(priority = 3)
    public void test1()
    {
        System.out.println(1);
    }
    @Test(priority = 2)
    public void test2()
    {
        System.out.println(2);
    }
    @Test(priority = 1)
    public void test3()
    {
        System.out.println(3);
    }
    @Test(priority = 0)
    public void test4()
    {
        System.out.println(4);
    }
}
