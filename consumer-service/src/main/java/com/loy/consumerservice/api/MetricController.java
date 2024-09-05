package com.loy.consumerservice.api;

import com.loy.consumerservice.domain.Metric;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Set;

public interface MetricController {
    @Operation(
            summary = "Получение списка всех имен метрик"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
    })
    Set<String> getAll();


    @Operation(
            summary = "Получение значений по имени метрики"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
    })
    Metric getMetric(String id);
}
