package com.ml.workbench.web.controller;

import com.ml.commons.constants.Constants;
import com.ml.commons.controller.BaseController;
import com.ml.commons.entity.ResponseObject;
import com.ml.commons.utils.DateUtils;
import com.ml.commons.utils.UUIDUtils;
import com.ml.settings.entity.User;
import com.ml.settings.web.service.UserService;
import com.ml.settings.web.service.impl.UserServiceImpl;
import com.ml.workbench.entity.Activity;
import com.ml.workbench.web.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: ActivityController
 * @author: musou
 * @Date: 2022/4/13 1:32 PM
 */
@Controller
@RequestMapping("/workbench/activity/")
public class ActivityController extends BaseController {
    @Resource
    private UserService userService;
    @Resource
    private ActivityService activityService;

    @RequestMapping("index.do")
    public String index(Model model) {
        List<User> userList = userService.queryAllUsers();
        model.addAttribute("userList", userList);
        return "workbench/activity/index";
    }

    @RequestMapping(value = "saveCreated.do", method = RequestMethod.POST)
    @ResponseBody
    public Object saveCreated(Activity activity) {
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        activity.setCreateTime(DateUtils.formatDateTime(new Date()));
        activity.setId(UUIDUtils.randomUUID());
        activity.setCreateBy(user.getId());
        int ret = activityService.createActivity(activity);
        ResponseObject respObj = new ResponseObject();
        if (ret == 0) {
            respObj.setCode(Constants.RESPONSE_CODE_FAILURE);
            respObj.setMessage("系统繁忙，请稍后再试...");
        } else {
            respObj.setCode(Constants.RESPONSE_CODE_SUCCESS);
        }
        return respObj;
    }

    @RequestMapping(value = "queryByConditionForPage.do", method = RequestMethod.POST)
    @ResponseBody
    public Object queryByConditionForPage(String name, String owner, String startDate, String endDate, int pageNo, int pageSize) {
        int beginNo = (pageNo - 1) * pageSize; // 开始的记录条数
        List<Activity> actList = activityService.queryActivityByConditionForPage(name, owner, startDate, endDate, beginNo, pageSize);
        int count = activityService.queryActivityCountByConditionForPage(name, owner, startDate, endDate, beginNo, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("totalRows", count);
        map.put("activityList", actList);
        return map;
    }
}
