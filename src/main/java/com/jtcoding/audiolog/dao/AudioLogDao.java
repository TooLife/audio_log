package com.jtcoding.audiolog.dao;

import com.jtcoding.audiolog.model.AudioLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

/**
 * @author jason.tang
 * @create 2019-01-16 10:24
 * @description
 */
@Mapper
public interface AudioLogDao {

    public static final String DELETE = "D";
    public static final String ADD = "A";
    public static final String MODIFY_NEW = "MN";
    public static final String MODIFY_ORIGINAL = "MO";

    int addAudioLog(AudioLog audioLog);
}
