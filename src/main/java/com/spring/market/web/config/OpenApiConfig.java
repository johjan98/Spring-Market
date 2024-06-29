package com.spring.market.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Market",
                version = "1.0.0",
                description = "This an api for a market"
        )
)
public class OpenApiConfig {}
