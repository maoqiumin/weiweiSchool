package com.qmmao.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import qmmao.school.teachingdb.entity.CustomerGen;

/**
 * @author maoqi
 */
public interface CustomerMapper {
    /**
     * 根据id获取账户信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM teacher_User WHERE teacherUserId = #{teacherUserId}")
    CustomerGen queryByPk(Long id);

    /**
     * 新增账户信息
     * @param customer
     */
    @Insert("INSERT INTO users(teacherUserCode,teacherUserName,registerOfPhone,bindPhone,nickname,status,createTime,lastChangeTime) " +
            "VALUES(#{teacherUserCode}, #{teacherUserName}, #{registerOfPhone}, #{bindPhone}, #{nickname}, #{status} ,#{createTime},#{lastChangeTime})")
    void insert(CustomerGen customer);
}
