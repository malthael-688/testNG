package com.dcits.testng_demo.basicAnnotation.at_Factory;

import org.testng.annotations.Factory;

/**
 * @author Malthael
 * @date 2019/8/20
 * 简单使用@Factory
 */
public class FactoryDemo1 {
    @Factory(enabled = true)
    public Object[] test1()
    {
        Object[] objects=new Object[2];
        com.dcits.testng_demo.basicAnnotation.at_Factory.Factory factory=new com.dcits.testng_demo.basicAnnotation.at_Factory.Factory("1");
        com.dcits.testng_demo.basicAnnotation.at_Factory.Factory factory1=new com.dcits.testng_demo.basicAnnotation.at_Factory.Factory("2");
        objects[0]=factory;
        objects[1]=factory1;
        return objects;
    }
}
