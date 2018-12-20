package com.masuguar.foolish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication( scanBasePackages = {"com.masuguar.foolish"})
public class FoolishStartApp  {
    public static void main(String[] args) {
        SpringApplication.run(FoolishStartApp.class,args);
    }
}
