package com.dcits.testng_demo.basicAnnotation.at_Factory.FactotyDemo4;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/20
 */
public class TestWebServer {
    @Test(parameters = {"nums"})
    public void accessPage(int nums)
    {
        while(nums-->0)
        {

        }
    }
}
