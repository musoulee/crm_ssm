package com.ml.workbench.web.service.impl;

import com.ml.workbench.entity.Activity;
import com.ml.workbench.mapper.ActivityMapper;
import com.ml.workbench.web.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: ActivityServiceImpl
 * @author: musou
 * @Date: 2022/4/13 10:23 PM
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityMapper activityMapper;

    @Override
    public int createActivity(Activity activity) {
        return activityMapper.insert(activity);
    }

    /**
     * 按条件分页查询市场活动
     *
     * @param name
     * @param owner
     * @param startDate
     * @param endDate
     * @param beginNo
     * @param pageSize
     * @return
     */
    @Override
    public List<Activity> queryActivityByConditionForPage(String name, String owner, String startDate, String endDate, Integer beginNo, Integer pageSize) {
        return activityMapper.selectActivityByConditionForPage(name, owner, startDate, endDate, beginNo, pageSize);
    }

    @Override
    public int queryActivityCountByConditionForPage(String name, String owner, String startDate, String endDate, Integer beginNo, Integer pageSize) {
        return activityMapper.selectCountOfActivityByCondition(name, owner, startDate, endDate, beginNo, pageSize);
    }
}
