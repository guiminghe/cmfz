package com.baizhi.cmfz.service;

import java.util.List;

public interface UserService {
    //统计近三周用户注册数量
    public List<Integer> selectCountUser();
}
