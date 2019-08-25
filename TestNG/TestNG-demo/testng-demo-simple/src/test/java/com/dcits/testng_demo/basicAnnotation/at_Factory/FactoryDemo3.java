package com.dcits.testng_demo.basicAnnotation.at_Factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/20
 * 简单使用@Factory(dataProvider = "num")
 */
@Test
public class FactoryDemo3 {
    @Factory(dataProvider = "num")
    public Object[] test1(int num1,int num2)
    {
        Object[] objects=new Object[1];
        com.dcits.testng_demo.basicAnnotation.at_Factory.Factory factory=new com.dcits.testng_demo.basicAnnotation.at_Factory.Factory(num1+"");
        objects[0]=factory;
        return objects;
    }

    @DataProvider(name = "num")
    public Object[][] nums()
    {
        return new Object[][]{{1,2},{2,3},{4,5},{6,7}};
    }
}
