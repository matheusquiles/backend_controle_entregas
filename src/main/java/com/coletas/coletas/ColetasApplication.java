package com.coletas.coletas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coletas.coletas.config.BuildInfo;

@SpringBootApplication
public class ColetasApplication {

    public static void main(String[] args) {
        BuildInfo.printBuildDetails();
        SpringApplication.run(ColetasApplication.class, args);
    }
}
