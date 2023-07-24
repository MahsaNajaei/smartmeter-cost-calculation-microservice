package com.energymeter.costcalculationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CostCalculationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostCalculationServiceApplication.class, args);
    }

}
