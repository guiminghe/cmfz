package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

public interface MenuService {
    //查询一级菜单和二级菜单
    public List<Menu> selectFirstAndSecondMenu();
}
