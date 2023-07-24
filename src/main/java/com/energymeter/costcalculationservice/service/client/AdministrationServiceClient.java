package com.energymeter.costcalculationservice.service.client;

import com.energymeter.costcalculationservice.dto.NeighborhoodTariffDto;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AdministrationServiceClient {

    private final RestTemplate restTemplate;

    private final EurekaClient eurekaClient;

    public NeighborhoodTariffDto getNeighborhoodTariff(Long userId) {
        String path = eurekaClient.getNextServerFromEureka("ADMINISTRATION-SERVICE", false).getHomePageUrl()
                + "/administration/tariffs/search/" + userId;
        return restTemplate.getForObject(path, NeighborhoodTariffDto.class);
    }
}
