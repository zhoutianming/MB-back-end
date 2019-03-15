package com.ztm.messageboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.ztm.messageboard.dao")
@EnableCaching
@ComponentScan(basePackages = {"com.ztm.messageboard.service","com.ztm.messageboard.dao","com.ztm.messageboard.controller"})
public class MessageBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageBoardApplication.class, args);
    }
}
