package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectCountUser")
    @ResponseBody
    public List<Integer> selectCountUser() {
        List<Integer> integers = userService.selectCountUser();
        System.out.println(integers + "@@@@@@@@@@@@@@@@@");
        return integers;
    }


}
