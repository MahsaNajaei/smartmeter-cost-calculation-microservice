package com.energymeter.costcalculationservice.service;

import com.energymeter.costcalculationservice.dto.BaseClientRequest;
import com.energymeter.costcalculationservice.dto.PaymentBillDto;

public interface CostCalculationService {
    PaymentBillDto calculateCost(BaseClientRequest baseClientRequest);
}
