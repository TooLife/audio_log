package com.jtcoding.audiolog.service.impl;

import com.jtcoding.audiolog.dao.AudioLogDao;
import com.jtcoding.audiolog.model.AudioLog;
import com.jtcoding.audiolog.service.AudioLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jason.tang
 * @create 2019-01-16 10:25
 * @description
 */
@Slf4j
@Service
public class AudioLogServiceImpl implements AudioLogService {

    @Autowired
    private AudioLogDao audioLogDao;

    @Transactional
    @Override
    public int addAudioLog(AudioLog audioLog) {
        return audioLogDao.addAudioLog(audioLog);
    }
}