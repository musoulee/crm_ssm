package com.ml.settings.mapper;

import com.ml.settings.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Sun Apr 10 11:01:37 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Sun Apr 10 11:01:37 CST 2022
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Sun Apr 10 11:01:37 CST 2022
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Sun Apr 10 11:01:37 CST 2022
     */
    User selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Sun Apr 10 11:01:37 CST 2022
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Sun Apr 10 11:01:37 CST 2022
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据账号和密码查询用户
     *
     * @param loginAct
     * @param loginPwd
     * @return
     */
    User selectUserByLoginActAndPwd(@Param("loginAct") String loginAct, @Param("loginPwd") String loginPwd);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUsers();
}