package com.toprs.common.pojo;

import java.util.Date;

/**
 * @Auther: scp
 * @Date: 2018/12/4 11:38
 * @Description:
 */
public class User {
    private Long userId;

    private String userName;

    private String phone;

    private String realname;

    private String password;

    private String state;

    private Date operated;

    private Integer deptId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getOperated() {
        return operated;
    }

    public void setOperated(Date operated) {
        this.operated = operated;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                ", operated=" + operated +
                ", deptId=" + deptId +
                '}';
    }
}
