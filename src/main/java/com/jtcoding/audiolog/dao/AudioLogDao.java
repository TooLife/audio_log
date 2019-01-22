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

    public static final String DELETE = "DELETE";
    public static final String ADD = "ADD";
    public static final String UPDATE_NEW = "UPDATE-NEW";
    public static final String UPDATE_ORIGINAL = "UPDATE-ORIGINAL";

    int addAudioLog(AudioLog audioLog);
}
