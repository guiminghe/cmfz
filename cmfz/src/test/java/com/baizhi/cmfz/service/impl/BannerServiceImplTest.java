package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.entity.Banner;
import com.baizhi.cmfz.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BannerServiceImplTest {
    @Autowired
    private BannerService bannerService;

    @Test
    public void selectAllBanner() {
        List<Banner> bannerList = bannerService.selectAllBanner(1, 10);
        for (Banner b : bannerList
        ) {
            System.out.println(b);
        }
    }

    @Test
    public void delete() {
        bannerService.deleteById(2);
    }
}