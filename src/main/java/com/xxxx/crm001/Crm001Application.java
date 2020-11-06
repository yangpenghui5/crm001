package com.xxxx.crm001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.xxxx.crm001.dao")
@SpringBootApplication
public class Crm001Application {

    public static void main(String[] args) {
        SpringApplication.run(Crm001Application.class, args);
    }

}
