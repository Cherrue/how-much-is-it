package com.price.search.howmuchisit.monitor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "monitor", description = "health check")
@RestController
@RequestMapping("/monitor/v1")
public class MonitorController {

    @Operation(summary = "ping", description = "return I'm Alive!")
    @ApiResponse(responseCode = "200", description = "Are you alive?")
    @GetMapping("/ping")
    public String ping() {
        return "I'm Alive!";
    }
}
