package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Banner;

import java.util.List;

public interface BannerService {
    //查询所有轮播图信息
    public List<Banner> selectAllBanner(int page, int rows);

    //获取数据总条数
    public int selectCount();

    //根据id删除轮播图
    public void deleteById(int id);

    //根据id修改轮播图的状态
    public void updateStatus(int id, String status);
}
