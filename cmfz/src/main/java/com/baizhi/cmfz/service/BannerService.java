package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Banner;

import java.util.List;

public interface BannerService {
    //查询所有轮播图信息
    public List<Banner> selectAllBanner(int page, int rows);

    //获取数据总条数
    public int selectCount();
}
