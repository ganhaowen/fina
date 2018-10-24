package com.baizhi.fina;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.baizhi.fina.dao")
@SpringBootApplication
public class FinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinaApplication.class, args);
    }
}
