package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Album;
import com.baizhi.cmfz.service.AlbumService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/selectAllAlbumAndAudio")
    @ResponseBody
    public Map selectAllAlbumAndAudio() {
        Map map = albumService.selectAllAlbumAndAudio();
        //System.out.println(map);

        return map;
    }

    //添加专辑
    @RequestMapping("/insertAlbum")
    @ResponseBody
    public boolean insertAlbum(Album album, MultipartFile coverImgs, HttpServletRequest req) throws IOException {
        System.out.println("insertAlbum++++++++++++++++++++++++++++");
        System.out.println(album + "*******************************");
        System.out.println(coverImgs + "!!!!!!!!!!!!!!!!!!!!!!!");
        try {
            //1.获取文件夹的相对路径
            String realPath = req.getSession().getServletContext().getRealPath("/images");
            //System.out.println(realPath+"&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            //获取文件的名字后缀
            String extension = FilenameUtils.getExtension(coverImgs.getOriginalFilename());
            String newName = UUID.randomUUID().toString().replaceAll("-", "");
            String coverImg = newName + "." + extension;
            //给Album对象的coverImg属性赋值
            album.setCoverImg(coverImg);
            //2.file对象
            File file = new File(realPath + "\\" + coverImg);
            //3.写入
            coverImgs.transferTo(file);
            //给Album对象的id赋值
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            album.setId(uuid);
            //调用插入方法
            albumService.insertAlbum(album);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
    }
}
