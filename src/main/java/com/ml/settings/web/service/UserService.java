package com.ml.settings.web.service;

import com.ml.settings.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: UserService
 * @author: musou
 * @Date: 2022/4/10 11:18 AM
 */
public interface UserService {
    User queryUserByLoginActAndPwd(String loginAct, String loginPwd);

    List<User> queryAllUsers();
}
