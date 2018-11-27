package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/selectFirstAndSecondMenu")
    public @ResponseBody
    Map stAndSecondMenu() {
        Map map = new HashMap();
        try {
            List<Menu> menuList = menuService.selectFirstAndSecondMenu();
            map.put("result", true);
            map.put("menuList", menuList);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", false);
        }
        return map;
    }
}
