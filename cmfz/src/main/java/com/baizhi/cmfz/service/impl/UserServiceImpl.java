package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.UserDao;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public List<Integer> selectCountUser() {
        List<Integer> countList = new ArrayList<>();
        countList.add(userDao.selectCountUser(7));
        countList.add(userDao.selectCountUser(14));
        countList.add(userDao.selectCountUser(21));
        System.out.println(countList + "$$$$$$$$$$$$$$$$$$$");
        //map.put("countList",countList);
        return countList;
    }

}
