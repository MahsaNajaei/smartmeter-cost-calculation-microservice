package com.energymeter.costcalculationservice.service;

import com.energymeter.costcalculationservice.dto.BaseClientRequest;
import com.energymeter.costcalculationservice.dto.PaymentBillDto;
import com.energymeter.costcalculationservice.service.client.AdministrationServiceClient;
import com.energymeter.costcalculationservice.service.client.ConsumptionManagerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostCalculationManager implements CostCalculationService {

    private final ConsumptionManagerClient consumptionManagerClient;
    private final AdministrationServiceClient administrationServiceClient;
    @Value("${energy-cost}")
    private static double energyCost;

    @Override
    public PaymentBillDto calculateCost(BaseClientRequest baseClientRequest) {
        var totalConsumption = consumptionManagerClient.getUserConsumptionBetweenDates(baseClientRequest);
        var neighborhoodTariff = administrationServiceClient.getNeighborhoodTariff(baseClientRequest.getUserId());
        var totalCost = totalConsumption * neighborhoodTariff.getTariffInPercentage() * energyCost;
        return PaymentBillDto
                .builder()
                .userName(baseClientRequest.getUsername())
                .totalCost(totalCost)
                .cityName(neighborhoodTariff.getCityName())
                .neighbourhood(neighborhoodTariff.getNeighbourhood())
                .build();
    }
}
