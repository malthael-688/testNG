package com.dcits.brower;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: DiaoJH
 * @Data: 2019/8/25
 */

public class Brower {
    WebDriver driver;

    public WebDriver chrome() {
        String webDriverPath =  "./src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",webDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // 启动时自动最大化窗口
//        options.addArguments("--disable-popup-blocking"); // 禁用阻止弹出窗口
//        options.addArguments("no-sandbox"); // 启动无沙盒模式运行
//        options.addArguments("disable-extensions"); // 禁用扩展
//        options.addArguments("no-default-browser-check"); // 默认浏览器检查
//        Map<String, Object> prefs = new HashMap();
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//        options.setExperimentalOption("prefs", prefs);// 禁用保存密码提示框

        driver = new ChromeDriver(options);
        //设置寻找一个元素的时间

        return driver;

    }

}