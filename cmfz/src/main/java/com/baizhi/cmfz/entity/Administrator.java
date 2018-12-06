package com.baizhi.cmfz.entity;

import lombok.Data;

@Data
public class Administrator {
    private Integer id;
    private String name;
    private String password;

    public Administrator() {
    }

    public Administrator(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
