package com.energymeter.costcalculationservice.controller;

import com.energymeter.costcalculationservice.dto.BaseClientRequest;
import com.energymeter.costcalculationservice.dto.PaymentBillDto;
import com.energymeter.costcalculationservice.service.CostCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bills")
public class CostReportController {

    private final CostCalculationService costCalculationService;

    @GetMapping
    public PaymentBillDto getCostBetweenGivenTime(@RequestBody BaseClientRequest costRequest, @RequestHeader(required = false) String username, @RequestHeader(required = false) String role) {

        if (!ObjectUtils.isEmpty(username) && !ObjectUtils.isEmpty(role) && !role.equalsIgnoreCase("ADMIN"))
            costRequest.setUsername(username);

        return costCalculationService.calculateCost(costRequest);
    }
}
