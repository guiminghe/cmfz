package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Album;

import java.util.List;

public interface AlbumDao {
    //查询所有专辑和章节信息
    public List<Album> selectAllAlbumAndAudio();

    //添加专辑
    public void insertAlbum(Album album);
}
