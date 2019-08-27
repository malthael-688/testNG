package webdriver.demo;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdriver.brower.Brower;
/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */
public class OpenChrome {
    WebDriver driver;

    @BeforeMethod
    public void init() {
        String url = "http://www.baidu.com";
        //新建一个浏览器句柄
        driver = new Brower().chrome();
        //打开URL
        driver.get(url);
    }
    @Test
    public void search() throws InterruptedException {
        //输入搜索字符串
        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("Baidu");
        //点击[百度一下]按钮
        driver.findElement(By.xpath("//*[@id=\"su\"]")).click();
        Thread.sleep(2000);
        driver.get("https://www.bilibili.com/");
    }
}
