package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单实用@Test(groups = "")
 */
@Test
public class TestDemo4 {
    /**
     * groups属性
     * 测试方法进行分组，可在类级别或方法级别添加组，类级别分组
     * 表示类里面的所有方法都属于该分组
     */
    @Test(groups = "test1")
    void test1()
    {
        System.out.println("test1");
    }

    @Test(groups = "test2")
    void test2()
    {
        System.out.println("test2");
    }

    @Test(groups = "test1")
    void test3()
    {
        System.out.println("test3");
    }
}
