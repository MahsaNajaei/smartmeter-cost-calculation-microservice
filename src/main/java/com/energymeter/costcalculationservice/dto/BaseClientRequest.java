package com.energymeter.costcalculationservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseClientRequest {
    private Long userId;
    private String username;
    private String fromDate;
    private String toDate;
}
