package com.ml.workbench.mapper;

import com.ml.workbench.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Wed Apr 13 14:59:41 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Wed Apr 13 14:59:41 CST 2022
     */
    int insert(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Wed Apr 13 14:59:41 CST 2022
     */
    int insertSelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Wed Apr 13 14:59:41 CST 2022
     */
    Activity selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Wed Apr 13 14:59:41 CST 2022
     */
    int updateByPrimaryKeySelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Wed Apr 13 14:59:41 CST 2022
     */
    int updateByPrimaryKey(Activity record);

    /**
     * 根据条件查询某一页的市场活动
     *
     * @param name
     * @param owner
     * @param startDate
     * @param endDate
     * @param beginNo
     * @param pageSize
     * @return
     */
    List<Activity> selectActivityByConditionForPage(@Param("name") String name, @Param("owner") String owner, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("beginNo") Integer beginNo, @Param("pageSize") Integer pageSize);

    /**
     * 根据条件查询市场活动总记录数
     *
     * @return
     */
    int selectCountOfActivityByCondition(@Param("name") String name, @Param("owner") String owner, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("beginNo") Integer beginNo, @Param("pageSize") Integer pageSize);

}