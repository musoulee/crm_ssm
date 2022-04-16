package com.ml.settings.web.service.impl;

import com.ml.settings.entity.User;
import com.ml.settings.mapper.UserMapper;
import com.ml.settings.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: UserServiceImpl
 * @author: musou
 * @Date: 2022/4/10 11:19 AM
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUserByLoginActAndPwd(String loginAct, String loginPwd) {
        return userMapper.selectUserByLoginActAndPwd(loginAct, loginPwd);
    }
    @Override
    public List<User> queryAllUsers(){
        return userMapper.selectAllUsers();
    }
}
