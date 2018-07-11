package com.bigname.demo03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.bigname.demo03.mapper.MemberMapper;

@SpringBootApplication//(exclude= {DataSourceAutoConfiguration.class})
@MapperScan({"com.bigname.demo03.mapper"})
public class SSMApplication{


    public static void main(String[] args) {

        SpringApplication.run(SSMApplication.class, args);
    }


}