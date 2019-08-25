package com.dcits.testng_demo.basicAnnotation.at_Parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/25
 */
public class ParametersDemo01 {
    @Test
    @Parameters({"hello"})
    public void test1(String hello)
    {
        System.out.println(hello);
    }
}
