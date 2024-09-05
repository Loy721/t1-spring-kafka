package com.loy.producerservice.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MetricController {

    @Operation(
            summary = "Отправляет все метрики spring actuator в топик"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
    })
    void sendMetrics();
}
