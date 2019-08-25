package com.dcits.testng_demo.basicAnnotation.at_Factory.FactotyDemo4;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/20
 */
public class FactoryDemo4 {
    private int  num;
    public FactoryDemo4(int i) {
        this.num=i;
    }
    @Test
    public void testServer()
    {
        for (int i = 0; i <num ; i++) {

        }
    }
}
