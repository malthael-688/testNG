package com.dcits.testspringbootdemo.mapper;

import com.dcits.testspringbootdemo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.Vector;
/**
 * @author Malthael
 * @date 2019/8/22
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 获取用户，根据account 获取User
     * @param account
     * @return
     */
    public User getUser(Integer account);

    /**
     * 保存用户
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 删除用户
     * 根据账号进行删除用户
     * @param account
     * @return
     */
    public int deleteUser(Integer account);

    /**
     * 修改用户
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 获得所有的用户
     * @return
     */
    public Vector<User> getAllUser();
}
