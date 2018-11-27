package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdministratorDao;
import com.baizhi.cmfz.enity.Administrator;
import com.baizhi.cmfz.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDao administratorDao;

    @Override
    public Administrator login(Administrator administrator) {

        return administratorDao.selectByNameAndPassword(administrator);
    }
}
