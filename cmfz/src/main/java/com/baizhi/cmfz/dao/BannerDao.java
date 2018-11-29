package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {
    //查询所有轮播图信息
    public List<Banner> selectAllBanner(@Param("start") int start, @Param("pageSize") int pageSize);

    //获取数据总条数
    public int selectCount();

    //根据id删除轮播图
    public void deleteById(int id);

    //根据id修改轮播图的状态
    public void updateStatus(@Param("id") int id, @Param("status") String status);
}
