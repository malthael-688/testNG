package com.dcits.demo;



import com.dcits.testspringbootdemo.TestSpringbootDemoApplication;
import org.openqa.selenium.By;
import com.dcits.brower.Brower;
import org.openqa.selenium.WebDriver;

import org.springframework.boot.SpringApplication;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.annotation.Target;
public class OpenChrome {
    WebDriver driver;
    private static String url = "http://localhost:8668";
    @BeforeClass
    public void init() {
        //新建一个浏览器句柄
        driver = new Brower().chrome();

    }
    @AfterClass
    public void close(){
        driver.close();
    }

    @Test()
    @Parameters({"UserName","UserPd"})
    public void register(String name,String pd) throws InterruptedException {
        String newurl = url + "/user/register?account="+name+"&password="+pd+"&name=MyNameIsDiao&signature=DiaoSignature";
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"注册成功!");
        newurl = url + "/user/show";
        driver.get(newurl);
        Thread.sleep(2000);
    }
    @Test
    @Parameters({"UserName","UserPd"})
    public void repeatregister(String name,String pd) throws InterruptedException {
        String newurl = url + "/user/register?account="+name+"&password="+pd+"&name=MyNameIsDiao&signature=DiaoSignature";
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"账号已存在");
        newurl = url + "/user/show";
        driver.get(newurl);
        Thread.sleep(2000);
    }
    @Test
    @Parameters({"UserName","UserPd"})
    public void repeat2register(String name,String pd) throws InterruptedException {
        String newurl = url + "/user/register?account="+name+"&password="+pd+"&name=MyNameIsDiao&signature=DiaoSignature";
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"账号已存在");
        newurl = url + "/user/show";
        driver.get(newurl);
        Thread.sleep(2000);
    }
    @Test
    @Parameters({"UserName","UserPd"})
    public void login(String name,String pd) throws InterruptedException {
        String newurl = url + "/user?account="+name+"&password="+pd;
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"登录成功");
        Thread.sleep(2000);
    }
    @Test()
    public void loginError(){

    }
    @Test(dataProviderClass = com.dcits.dataprovider.GetDataFromDB.class, dataProvider = "getData")
    public void loginFromDB(String name,String pd,String result) throws InterruptedException {
        String newurl = url + "/user?account="+name+"&password="+pd;
        driver.get(newurl);
        Thread.sleep(500);
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),result);
        Thread.sleep(2000);
    }
}
