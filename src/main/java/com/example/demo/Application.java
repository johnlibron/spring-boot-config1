package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private final AppName appName;

    @Lazy
    public Application(AppName appName) {
        this.appName = appName;
    }

    @Bean
    public AppName getAppName(@Value("${app.name}") String appName) {
        return () -> appName;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application name: {}", appName.getName());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
