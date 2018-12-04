package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Album;

import java.util.Map;

public interface AlbumService {
    //查询所有专辑和章节信息
    public Map selectAllAlbumAndAudio();

    //添加专辑
    public void insertAlbum(Album album);
}
