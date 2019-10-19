package com.mould.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {RabbitAutoConfiguration.class},scanBasePackages = "com.**")
//        (scanBasePackages = "com.mould.boot.**")
//@MapperScan(value = {"com.**"})
@SpringBootApplication(scanBasePackages = "com.**")
@MapperScan(value = {"com.mould.boot.mapper"})
public class BootApplication {


    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
