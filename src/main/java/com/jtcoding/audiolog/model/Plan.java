package com.jtcoding.audiolog.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author jason.tang
 * @create 2019-01-16 10:22
 * @description
 */
@Data
@ToString
@Builder
public class Plan {
    private Integer planNum;
    private String planName;
}