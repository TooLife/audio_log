package com.jtcoding.audiolog.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author jason.tang
 * @create 2019-01-16 10:23
 * @description
 */
@Data
@ToString
@Builder
public class Company {
    private Integer companyNum;
    private String companyName;
    private String companyAddress;
}