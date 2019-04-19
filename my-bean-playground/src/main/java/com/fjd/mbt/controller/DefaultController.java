package com.fjd.mbt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/")
@RestController
public class DefaultController {

    @GetMapping("version")
    String version() {
        return "V1";
    }

    @GetMapping("health")
    String health() {
        return "OK";
    }
}