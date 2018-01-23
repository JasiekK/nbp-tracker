package com.jkmiec;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

@EnableBatchProcessing
@SpringBootApplication
@IntegrationComponentScan
public class NbpTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbpTrackerApplication.class, args);
    }
}
