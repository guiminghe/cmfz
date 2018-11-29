package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Banner;
import com.baizhi.cmfz.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/selectAllBanner")
    public @ResponseBody
    Map selectAllBanner(int page, int rows) {
        System.out.println(page + "*******&&&&&&*****" + rows);
        Map map = new HashMap();
        List<Banner> bannerList = bannerService.selectAllBanner(page, rows);
        int total = bannerService.selectCount();
        map.put("rows", bannerList);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/deleteById")
    public @ResponseBody
    Boolean deleteById(int id) {
        System.out.println(id + "**********************");
        try {
            bannerService.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
