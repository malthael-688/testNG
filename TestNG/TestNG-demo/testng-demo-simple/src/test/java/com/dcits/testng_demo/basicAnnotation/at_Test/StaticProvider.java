package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.annotations.DataProvider;
/**
 * @author Malthael
 * @date 2019/8/19
 */
public class StaticProvider
{
    @DataProvider(name = "numbers")
    public static Object[][] provider()
    {
        return new Object[][]{
                {1,2},
                {2,3},
                {3,4},
        };
    }
}