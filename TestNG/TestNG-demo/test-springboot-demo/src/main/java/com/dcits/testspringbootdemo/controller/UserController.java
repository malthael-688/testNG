package com.dcits.testspringbootdemo.controller;

import com.dcits.testspringbootdemo.bean.User;
import com.dcits.testspringbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Vector;

/**
 * @author Malthael
 * @date 2019/8/22
 */
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    /**
     * 登录通过url获取值
     * 通过get获取数值
     * http://localhost:9999/user?account=5&password=1
     * @param account
     * @param password
     * @return
     */
    @GetMapping("/user")

    public String login(@RequestParam(value = "account") Integer account,
                        @RequestParam(value = "password") String password) {
        if (account.equals("")) {
            return "<h1 id = \"result\">账号为空</h1>";
        }
        User user = userMapper.getUser(account);
        if (user == null) {
            return "<h1 id = \"result\">不存在</h1>";
        }
        if (user.getPassword().equals(password)) {
            return "<h1 id = \"result\">登录成功</h1>";
        }
        return "<h1 id = \"result\">账号或密码错误</h1>";
    }

    /**
     * 通过url进行创建用户
     * http://localhost:9999/user/register?account=5&password=1&name=5&signature=asdj
     * @param account
     * @param password
     * @param name
     * @return
     */
    @GetMapping("/user/register")
    public String register(@RequestParam(value = "account") Integer account, @RequestParam(value = "password") String password, @RequestParam(value = "name") String name,@RequestParam(value = "signature")String signature) {
        if (account.equals("")) {
            return "<h1 id = \"result\">账号为空</h1>";
        }
        User user = userMapper.getUser(account);
        if (user != null) {
            return "<h1 id = \"result\">账号已存在</h1>";
        }
        User user1 = new User();
        user1.setAccount(account);
        user1.setPassword(password);
        user1.setName(name);
        user1.setSignature(signature);
        userMapper.saveUser(user1);
        return "<h1 id = \"result\">注册成功!</h1>";
    }

    /**
     * 删除用户
     * http://localhost:9999/user/delete?account=2
     * @param account
     * @return
     */
    @GetMapping("/user/delete")
    public String delete(@RequestParam(value = "account")Integer account)
    {
        if (account.equals(""))
        {
            return "<h1 id =\"result\">账号不能为空</h1>";
        }
        User user=userMapper.getUser(account);
        if (user!=null)
        {
            userMapper.deleteUser(account);
            return "<h1 id =\"result\">删除成功!</h1>";
        }
        return "<h1 id =\"result\">用户不存在!</h1>";
    }

    /**
     * 修改用户
     * 需要输入全部属性
     * http://localhost:9999/user/update?account=2&password=232ajsdhj&name=ajsdj&signature=sadkjsajb
     * @param account
     * @param password
     * @param name
     * @param signature
     * @return
     */
    @GetMapping("/user/update")
    public String update(@RequestParam(value = "account")Integer account,@RequestParam(value = "password")String password,@RequestParam(value = "name")String name,@RequestParam(value = "signature")String signature)
    {
        if (account.equals(""))
        {
            return "<h1 id =\"result\">账号不能为空</h1>";
        }
        User user=userMapper.getUser(account);
        if (user!=null)
        {
            user.setName(name);
            user.setSignature(signature);
            user.setPassword(password);
            return "<h1 id =\"result\">修改成功</h1>";
        }
        return "<h1 id =\"result\">修改失败，或用户不存在!</h1>";
    }

    @GetMapping("/user/show")
    public Vector<User> show()
    {
        return userMapper.getAllUser();
    }
}
