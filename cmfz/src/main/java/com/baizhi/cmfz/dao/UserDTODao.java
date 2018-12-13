package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.UserDTO;

import java.util.List;

public interface UserDTODao {
    //查询每个地区的男女人数
    public List<UserDTO> selectCountBySex(String sex);
}
