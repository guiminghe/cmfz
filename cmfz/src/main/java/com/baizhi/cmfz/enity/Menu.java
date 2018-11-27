package com.baizhi.cmfz.enity;

import lombok.Data;

@Data
public class Menu {
    private int id;
    private String title;
    private String iconCls;
    private int parentId;
    private String url;
}
