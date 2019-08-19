package com.dcits.testng_demo.basicAnnotation.withXML;

import org.testng.annotations.Test;

/**
 * @author Malthael
 * @date 2019/8/19
 * 简单模拟用户功能
 * 简单讲解
 */
public class UserController {
    @Test
    public void userRegister()
    {
        System.out.println("用户注册!");
    }
    @Test
    public void userLogin()
    {
        System.out.println("用户登录!");
    }
    @Test
    public void userEditor()
    {
        System.out.println("用户修改信息!");
    }
    @Test
    public void userQuit()
    {
        System.out.println("用户退出!");
    }


}
