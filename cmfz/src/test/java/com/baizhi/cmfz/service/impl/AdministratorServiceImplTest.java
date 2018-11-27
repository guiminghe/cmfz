package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.entity.Administrator;
import com.baizhi.cmfz.service.AdministratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorServiceImplTest {
    @Autowired
    private AdministratorService administratorService;

    @Test
    public void login() {
        Administrator adm = new Administrator("123", "123");
        Administrator administrator = administratorService.login(adm);
        System.out.println(administrator);
    }
}