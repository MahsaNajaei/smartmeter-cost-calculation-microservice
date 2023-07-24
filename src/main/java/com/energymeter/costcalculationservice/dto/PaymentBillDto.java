package com.energymeter.costcalculationservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentBillDto {
    private String userName;
    private Double totalCost;
    private String cityName;
    private String neighbourhood;
}
