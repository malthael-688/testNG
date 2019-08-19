package com.dcits.testng_demo.basicAnnotation.at_Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单使用@Test(dataProvider = "provider")
 */
public class TestDemo15 {
    @Test(dataProvider = "provider")
    public void test1(String msg1, String msg2) {
        System.out.println(msg1 + " " + msg2);
    }

    @DataProvider(name = "provider")
    public Object[][] dataProvide() {
        return new Object[][]{{"hello", "world"}, {"sing it stronger", "sing it together"}};
    }

}
