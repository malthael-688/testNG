package com.dcits.testng_demo.basicAnnotation.withXML;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单模拟数据库连接
 * 注解: @BeforeSuite与@AfterSuite 的简单用法
 */
public class DBConfig {

    @BeforeSuite
    public void dbConnection()
    {
        System.out.println("建立连接!");
    }

    @AfterSuite
    public void dbClose()
    {
        System.out.println("断开连接!");
    }
}
