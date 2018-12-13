package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.UserDTO;
import com.baizhi.cmfz.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserDtoController {
    @Autowired
    private UserDTOService userDtoService;

    @RequestMapping("/selectCountBySex")
    @ResponseBody
    public List<UserDTO> selectCountBySex(String sex) {
        return userDtoService.selectCountBySex(sex);
    }
}
