package com.baizhi.cmfz.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer id;
    private String title;
    private String iconCls;
    private Integer parentId;
    private String url;
    private List<Menu> secondMenuList;
}
