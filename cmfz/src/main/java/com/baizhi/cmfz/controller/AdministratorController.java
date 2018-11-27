package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.enity.Administrator;
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
    public String login(HttpSession session, Administrator administrator, String kaptcha, Map map) {
        String sessionKaptcha = (String) session.getAttribute("kaptcha");
        if (sessionKaptcha.equalsIgnoreCase(kaptcha)) {
            Administrator adm = administratorService.login(administrator);
            session.setAttribute("administrator", adm);
            return "redirect:/main/main.jsp";
        } else {
            return "login";
        }
    }
}
