package com.jtcoding.audiolog.model;

import lombok.*;

/**
 * @author jason.tang
 * @create 2019-01-16 10:22
 * @description
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Plan  {
    private Integer planNum;
    private String planName;
}