package com.qmmao.weiweischool.dao.teachingdb.entity;

import java.sql.Timestamp;

/**
 * @author maoqi
 */
public class CustomerGen {

    private Long teacherUserId;

    private String teacherUserCode;

    private String teacherUserName;

    private String registerOfPhone;

    private String bindPhone;

    private String nickname;

    private String  status;

    private Timestamp createTime;

    private Timestamp lastChangeTime;

    public Long getTeacherUserId() {
        return teacherUserId;
    }

    public void setTeacherUserId(Long teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public String getTeacherUserCode() {
        return teacherUserCode;
    }

    public void setTeacherUserCode(String teacherUserCode) {
        this.teacherUserCode = teacherUserCode;
    }

    public String getTeacherUserName() {
        return teacherUserName;
    }

    public void setTeacherUserName(String teacherUserName) {
        this.teacherUserName = teacherUserName;
    }

    public String getRegisterOfPhone() {
        return registerOfPhone;
    }

    public void setRegisterOfPhone(String registerOfPhone) {
        this.registerOfPhone = registerOfPhone;
    }

    public String getBindPhone() {
        return bindPhone;
    }

    public void setBindPhone(String bindPhone) {
        this.bindPhone = bindPhone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(Timestamp lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }
}
