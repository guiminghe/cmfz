package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.BannerDao;
import com.baizhi.cmfz.entity.Banner;
import com.baizhi.cmfz.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Override
    public List<Banner> selectAllBanner(int page, int rows) {
        int start = (page - 1) * rows;
        int pageSize = rows;
        return bannerDao.selectAllBanner(start, pageSize);
    }

    @Override
    public int selectCount() {
        return bannerDao.selectCount();
    }
}
