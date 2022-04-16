package com.ml.workbench.web.service;

import com.ml.workbench.entity.Activity;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @description: ActivityService
 * @author: musou
 * @Date: 2022/4/13 3:02 PM
 */
public interface ActivityService {
    public int createActivity(Activity activity);

    public List<Activity> queryActivityByConditionForPage(String name, String owner, String startDate, String endDate, Integer beginNo, Integer pageSize);

    public int queryActivityCountByConditionForPage(String name, String owner, String startDate, String endDate, Integer beginNo, Integer pageSize);
}
