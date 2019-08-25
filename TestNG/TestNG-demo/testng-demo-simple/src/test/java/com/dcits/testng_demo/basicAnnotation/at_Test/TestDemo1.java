package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 注解:@Test讲解
 */

public class TestDemo1 {
    /**
     * 每一个被@Test注解的方法都可以单独运行
     * 被@Test注解的类，该类所有的方法都会被运行
     */
    @Test
    public void test1()
    {
        System.out.println("test1");
    }
    @Test
    public void test2()
    {
        System.out.println("test2");
    }
    @Test
    public String test3()
    {
        System.out.println("test3");
        return "test3";
    }
}
