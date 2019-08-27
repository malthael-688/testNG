package com.dcits.demo;


import com.dcits.testspringbootdemo.TestSpringbootDemoApplication;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import com.dcits.brower.Brower;
import org.openqa.selenium.WebDriver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;
import java.lang.annotation.Target;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class OpenChrome {
    public static Logger logger=Logger.getLogger(OpenChrome.class);
    WebDriver driver;
    private static String url = "http://localhost:8668";

    @BeforeClass
    public void init() {
        //新建一个浏览器句柄
        logger.info("启动浏览器驱动");
        driver = new Brower().chrome();
        logger.info("浏览器驱动启动成功!\n");

    }

    @AfterClass
    public void close() {
        logger.info("开始结束工作!\n");
        driver.close();
        logger.info("浏览器驱动关闭成功!\n");
    }

    @Test()
    @Parameters({"UserName", "UserPd"})
    public void register(String name, String pd) throws InterruptedException {
        logger.info("基本注册工作\n");
        String newurl = url + "/user/register?account=" + name + "&password=" + pd + "&name=MyNameIsDiao&signature=DiaoSignature";
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "注册成功!");
        newurl = url + "/user/show";
        driver.get(newurl);
        logger.info("注册成功!\n");
        Thread.sleep(2000);
    }

    @Test()
    @Parameters({"UserName", "UserPd"})
    public void repeatregister(String name, String pd) throws InterruptedException {
        logger.info("重复注册\n");
        String newurl = url + "/user/register?account=" + name + "&password=" + pd + "&name=MyNameIsDiao&signature=DiaoSignature";
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "账号已存在");
        logger.info("展示所有用户!\n");
        newurl = url + "/user/show";
        driver.get(newurl);
        Thread.sleep(2000);
    }

    @Test
    @Parameters({"UserName", "UserPd"})
    public void repeat2register(String name, String pd) throws InterruptedException {
        logger.info("不执行的注册\n");
        String newurl = url + "/user/register?account=" + name + "&password=" + pd + "&name=MyNameIsDiao&signature=DiaoSignature";
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "账号已存在");
        newurl = url + "/user/show";
        driver.get(newurl);
        Thread.sleep(2000);
    }

    @Test
    @Parameters({"UserName", "UserPd"})
    public void login(String name, String pd) throws InterruptedException {
        logger.info("登录\n");
        String newurl = url + "/user?account=" + name + "&password=" + pd;
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "登录成功");
        logger.info("登录成功\n");
        Thread.sleep(2000);
    }

    @Test()
    public void loginError() {

    }

    @Test(dataProviderClass = com.dcits.dataprovider.GetDataFromDB.class, dataProvider = "getData")
    public void loginFromDB(String name, String pd, String result) throws InterruptedException {
        logger.info("从数据中获取数据\n");
        String newurl = url + "/user?account=" + name + "&password=" + pd;
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), result);
        Thread.sleep(2000);
    }
}
