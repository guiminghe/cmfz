package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.UserDTODao;
import com.baizhi.cmfz.entity.UserDTO;
import com.baizhi.cmfz.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDTOServiceImpl implements UserDTOService {
    @Autowired
    private UserDTODao userDtoDao;

    @Override
    public List<UserDTO> selectCountBySex(String sex) {
        return userDtoDao.selectCountBySex(sex);
    }
}
