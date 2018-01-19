package com.jkmiec;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class NbpTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbpTrackerApplication.class, args);
    }
}
