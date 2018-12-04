package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/selectAllAlbumAndAudio")
    @ResponseBody
    public Map selectAllAlbumAndAudio() {
        Map map = albumService.selectAllAlbumAndAudio();
        System.out.println(map);
        return map;
    }

    //添加专辑
    @RequestMapping("/insertAlbum")
    @ResponseBody
    public boolean insertAlbum(Album album) {
        try {
            albumService.insertAlbum(album);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
