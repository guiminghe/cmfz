package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.enity.Administrator;

public interface AdministratorDao {
    //根据名字和密码查询数据
    public Administrator selectByNameAndPassword(Administrator administrator);
}
