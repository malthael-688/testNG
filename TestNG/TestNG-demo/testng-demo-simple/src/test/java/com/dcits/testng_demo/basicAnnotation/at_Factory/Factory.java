package com.dcits.testng_demo.basicAnnotation.at_Factory;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/20
 * 简单工厂实体类
 */
public class Factory {
    private  String string;

    public Factory(String string) {
        this.string = string;
    }

    @Test
    public void test1()
    {
        System.out.println("Factory1:"+string);
    }
    @Test
    public void test2()
    {
        System.out.println("Factory2:"+string);
    }
}
