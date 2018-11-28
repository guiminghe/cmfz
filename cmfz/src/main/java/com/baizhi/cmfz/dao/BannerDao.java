package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {
    //查询所有轮播图信息
    public List<Banner> selectAllBanner(@Param("start") int start, @Param("pageSize") int pageSize);

    //获取数据总条数
    public int selectCount();
}
