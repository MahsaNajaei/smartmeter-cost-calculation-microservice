package com.energymeter.costcalculationservice.service.client;

import com.energymeter.costcalculationservice.dto.BaseClientRequest;
import com.mashape.unirest.http.ObjectMapper;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ConsumptionManagerClient {

    private final ObjectMapper mapper;

    private final RestTemplate restTemplate;

    private final EurekaClient eurekaClient;

    public Double getUserConsumptionBetweenDates(BaseClientRequest baseClientRequest) {
        String basePath = eurekaClient.getNextServerFromEureka("CONSUMPTION-MANAGER-SERVICE", false).getHomePageUrl();
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        var requestBody = new HttpEntity(mapper.writeValue(baseClientRequest), headers);
        return restTemplate.postForObject(basePath + "/consumption/statistics", requestBody, Double.class);
    }
}
