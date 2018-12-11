package com.baizhi.cmfz.dao;

public interface UserDao {
    //统计近几周用户注册数量
    public int selectCountUser(int days);
}
