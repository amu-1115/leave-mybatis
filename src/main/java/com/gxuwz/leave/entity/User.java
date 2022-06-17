package com.gxuwz.leave.entity;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
public class User {
    private String userid;
    private String fullname;
    private String password;
    private String status;

    private Department department;

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public User(String userid) {
        this.userid = userid;
    }

    public User() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
