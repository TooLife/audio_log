package com.jtcoding.audiolog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableAspectJAutoProxy
public class AudioLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AudioLogApplication.class, args);
    }

}

