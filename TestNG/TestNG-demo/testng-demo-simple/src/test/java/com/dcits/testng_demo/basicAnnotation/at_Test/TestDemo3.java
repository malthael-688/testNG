package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 注解:@Test(enabled = false)
 */
public class TestDemo3 {
    /**
     * enabled属性
     * 设置为false，执行测试会忽略@Test注解的test2方法。
     */
    @Test(enabled = false)
    public void test1()
    {
        System.out.println("test2");
    }
}
