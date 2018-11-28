package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Administrator;
import com.baizhi.cmfz.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    //登录
    @RequestMapping("/login")
    public String login(HttpSession session, Administrator administrator, String enCode, Map map) {
        System.out.println();

        String sessionKaptcha = (String) session.getAttribute("kaptcha");
        if (sessionKaptcha.equalsIgnoreCase(enCode)) {
            Administrator adm = administratorService.login(administrator);
            session.setAttribute("administrator", adm);
            return "redirect:/selectFirstAndSecondMenu.do";
        } else {
            return "login";
        }
    }
}
