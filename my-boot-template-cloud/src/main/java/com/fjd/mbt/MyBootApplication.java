package com.fjd.mbt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBootApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBootApplication.class);

    public static void main(String[] args) {
        LOGGER.debug("service is starting...");
        SpringApplication.run(MyBootApplication.class, args);
    }
}