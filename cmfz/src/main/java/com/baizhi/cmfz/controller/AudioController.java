package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Audio;
import com.baizhi.cmfz.service.AudioService;
import com.baizhi.cmfz.util.FileUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AudioController {
    @Autowired
    private AudioService audioService;

    @RequestMapping("/addChapter")
    public @ResponseBody
    boolean addChapter(MultipartFile myAudio, Audio audio, HttpServletRequest request) {
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/");  //webapp当前项目的路径
            File file = new File(realPath + "/audio");
            if (!file.exists()) {
                file.mkdir();
            }
            String extension = FilenameUtils.getExtension(myAudio.getOriginalFilename());
            UUID uuid = UUID.randomUUID();
            String s = uuid.toString();
            String newName = s + "." + extension;
            myAudio.transferTo(new File(file.getAbsolutePath(), newName));
            double length = FileUtil.getDuration(new File(file.getAbsolutePath() + "/" + newName));
            double size = myAudio.getSize();
            double l = size / 1024.0 / 1024.0;
            audio.setTitle(s);
            audio.setSize(l);
            audio.setDuration(length);
            audio.setDownPath("/audio/" + newName);
            audioService.add(audio);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
