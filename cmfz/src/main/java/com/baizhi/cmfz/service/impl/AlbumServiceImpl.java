package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AlbumDao;
import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public Map selectAllAlbumAndAudio() {
        Map map = new HashMap();
        List<Album> albumList = albumDao.selectAllAlbumAndAudio();

        /*for (Album a:albumList
             ) {
            System.out.println(a);
        }*/

        map.put("rows", albumList);
        return map;
    }

    @Override
    public void insertAlbum(Album album) {
        albumDao.insertAlbum(album);
    }
}
