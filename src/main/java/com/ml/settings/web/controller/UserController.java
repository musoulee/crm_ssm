package com.ml.settings.web.controller;

import com.ml.commons.constants.Constants;
import com.ml.commons.controller.BaseController;
import com.ml.commons.entity.ResponseObject;
import com.ml.commons.utils.DateUtils;
import com.ml.settings.entity.User;
import com.ml.settings.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.util.Date;

/**
 * @description: UserController
 * @author: musou
 * @Date: 2022/4/3 12:07 PM
 */
@Controller
@RequestMapping("/settings/qx/user/")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("toLogin.do")
    public String toLogin() {
        return "settings/qx/user/login";
    }

    @RequestMapping("login.do")
    @ResponseBody
    public Object login(String loginAct, String loginPwd, String isRemembered) {
        User user = userService.queryUserByLoginActAndPwd(loginAct, loginPwd);
        ResponseObject respObj = new ResponseObject();
        respObj.setCode(Constants.RESPONSE_CODE_FAILURE);
        if (user == null) {
            respObj.setMessage("用户名或密码错误");
        } else {
            // 进一步判断账号是否合法
            // 1。账号过期
            if (DateUtils.formatDateTime(new Date()).compareTo(user.getExpireTime()) > 0) {
                respObj.setMessage("账号已过期");
            } else if ("0".equals(user.getLockState())) {
                // 2。状态锁定
                respObj.setMessage("状态被锁定");
            } else if (!user.getAllowIps().contains(request.getRemoteAddr())) {
                // 3。ip地址受限
                respObj.setMessage("ip地址受限");
            } else {
                // 4。登录成功
                respObj.setCode(Constants.RESPONSE_CODE_SUCCESS);
                request.getSession().setAttribute(Constants.SESSION_USER, user); // 保存用户名
                // 记住密码
                if ("true".equals(isRemembered)) {
                    Cookie c1 = new Cookie("loginAct", user.getLoginAct());
                    c1.setMaxAge(10 * 24 * 60 * 60); // 10天内记住密码
                    response.addCookie(c1);
                    Cookie c2 = new Cookie("loginPwd", user.getLoginPwd());
                    c2.setMaxAge(10 * 23 * 60 * 60);
                    response.addCookie(c2);
                } else {
                    // 如果没有记住密码，把没有过期的cookie删除
                    Cookie c1 = new Cookie("loginAct", "1");
                    c1.setMaxAge(0);
                    Cookie c2 = new Cookie("loginPwd", "1");
                    c2.setMaxAge(0);
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
            }
        }
        return respObj;
    }

    @RequestMapping("logout.do")
    public String logout() {
        // 清空cookie
        Cookie c1 = new Cookie("loginAct", "1");
        c1.setMaxAge(0);
        Cookie c2 = new Cookie("loginPwd", "1");
        c2.setMaxAge(0);
        response.addCookie(c1);
        response.addCookie(c2);
        // 销毁session
        request.getSession().invalidate();
        // 重定向至首页
        return "redirect:/";
    }
}
