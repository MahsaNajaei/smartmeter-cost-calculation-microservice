package com.energymeter.costcalculationservice.config;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public com.mashape.unirest.http.ObjectMapper objectMapper() {
        return new com.mashape.unirest.http.ObjectMapper() {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

            @SneakyThrows
            public String writeValue(Object value) {
                return mapper.writeValueAsString(value);
            }

            @SneakyThrows
            public <T> T readValue(String value, Class<T> valueType) {
                return mapper.readValue(value, valueType);
            }
        };
    }

}
