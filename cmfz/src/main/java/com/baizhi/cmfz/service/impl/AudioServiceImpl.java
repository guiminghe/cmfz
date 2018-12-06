package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AudioDao;
import com.baizhi.cmfz.entity.Audio;
import com.baizhi.cmfz.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//声明式事务处理
@Transactional
public class AudioServiceImpl implements AudioService {
    @Autowired
    private AudioDao audioDao;

    @Override
    public void addAudio(Audio audio) {
        audioDao.insertAudio(audio);
    }
}
