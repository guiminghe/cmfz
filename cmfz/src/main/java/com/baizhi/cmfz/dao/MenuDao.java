package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

public interface MenuDao {
    //查询一级菜单和二级菜单
    public List<Menu> selectFirstAndSecondMenu();
}
