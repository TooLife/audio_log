package com.jtcoding.audiolog.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author jason.tang
 * @create 2019-01-16 10:21
 * @description
 */

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AudioLog {
    private String logID;
    private String logData;
    private String type;
    private LocalDateTime createDatetime;
}