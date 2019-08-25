package com.dcits.testng_demo.basicAnnotation.at_Factory.FactotyDemo4;

import org.testng.annotations.Factory;

/**
 * @author Malthael
 * @date 2019/8/20
 */
public class WebTestFactory {
    @Factory
    public Object[] createInstances()
    {
        Object[] result=new Object[10];
        for (int i = 0; i <10 ; i++) {
            result[i]=new FactoryDemo4(i*10);
        }
        return result;
    }
}
