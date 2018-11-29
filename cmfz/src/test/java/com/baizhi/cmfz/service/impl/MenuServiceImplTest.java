package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceImplTest {
    @Autowired
    private MenuDao menuDao;

    @Test
    public void selectFirstAndSecondMenu() {
        List<Menu> menuList = menuDao.selectFirstAndSecondMenu();
        for (Menu m : menuList
        ) {
            System.out.println(m);
        }
    }


}