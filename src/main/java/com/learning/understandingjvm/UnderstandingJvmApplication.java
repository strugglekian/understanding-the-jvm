package com.learning.understandingjvm;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class UnderstandingJvmApplication implements ExitCodeGenerator {
    private static ConfigurableApplicationContext configurableApplicationContext;
    public static void main(String[] args) {

         configurableApplicationContext = SpringApplication.run(UnderstandingJvmApplication.class, args);
        System.out.println("lllllllllll");
        SpringApplication.exit(configurableApplicationContext);

    }

    @Override
    public int getExitCode() {
        return 0;
    }
}
