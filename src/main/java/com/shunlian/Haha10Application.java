package com.shunlian;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Haha10Application {


    @RequestMapping("/")
    public static String index() {
        return "haha10 started";
    }

    public static void main(String[] args) {
        SpringApplication.run(Haha10Application.class, args);
    }



}
