package com.jtcoding.audiolog.model;

import lombok.*;

import java.time.LocalDate;

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
    private Integer logNum;
    private String logData;
    private String type;
    private LocalDate createDatetime;
}