package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Audio;
import com.baizhi.cmfz.service.AudioService;
import com.baizhi.cmfz.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
public class AudioController {
    @Autowired
    private AudioService audioService;

    //添加章节
    @RequestMapping("/addAudio")
    @ResponseBody
    public boolean addAudio(MultipartFile myAudio, Audio audio, HttpServletRequest request) {
        System.out.println(myAudio + "myAudiomyAudiomyAudiomyAudiomyAudiomyAudiomyAudiomyAudio");
        System.out.println(audio + "audioaudioaudioaudioaudioaudioaudioaudioaudioaudio");
        try {
            //webapp当前项目的路径
            String realPath = request.getSession().getServletContext().getRealPath("/");
            //
            File file = new File(realPath + "/audio");
            //如果这个文件不存在
            if (!file.exists()) {
                //就创建这个文件
                file.mkdir();
            }
            //给添加的音频重命名
            String extension = FilenameUtils.getExtension(myAudio.getOriginalFilename());
            UUID uuid = UUID.randomUUID();
            String s = uuid.toString();
            String newName = s + "." + extension;
            //将音频放到/webapp/audio里
            myAudio.transferTo(new File(file.getAbsolutePath(), newName));
            //获取音频的时长和大小
            double length = FileUtil.getDuration(new File(file.getAbsolutePath() + "/" + newName));
            double size = myAudio.getSize();
            double l = size / 1024.0 / 1024.0;
            //给音频赋值
            //audio.setTitle(myAudio.getOriginalFilename());
            audio.setSize(l);
            audio.setDuration(length);
            audio.setDownPath(newName);
            audioService.addAudio(audio);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //下载音频
    @RequestMapping("/downloadAudio")
    public void downloadAudio(String downPath, String title, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uploadPath = request.getSession().getServletContext().getRealPath("/audio");
        String path = uploadPath + "/" + downPath;
        File file = new File(path);
        //System.out.println(downPath);
        //获取地址的后缀
        String extension = downPath.substring(downPath.lastIndexOf("."));
        String downloadName = title + extension;
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downloadName, "utf-8"));
        response.setContentType("audio/mpeg");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(FileUtils.readFileToByteArray(file));
    }
}
