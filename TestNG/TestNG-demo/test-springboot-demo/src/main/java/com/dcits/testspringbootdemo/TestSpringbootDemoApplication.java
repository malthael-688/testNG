package com.dcits.testspringbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author Malthael
 * @date 2019/8/22
 */
@MapperScan("com.dcits.testspringbootdemo.mapper")
@SpringBootApplication
public class TestSpringbootDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestSpringbootDemoApplication.class, args);
    }


}
