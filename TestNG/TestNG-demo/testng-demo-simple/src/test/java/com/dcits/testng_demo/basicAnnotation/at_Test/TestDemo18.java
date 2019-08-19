package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 实现retry
 */
public class TestDemo18 {
    @Test(dependsOnMethods = "hello",ignoreMissingDependencies = true)
    public void test1()
    {
        System.out.println("正常输出");
    }
//    @Test(dependsOnMethods = "hello")
//    public void test2()
//    {
//        System.out.println("错误输出");
//    }
}
