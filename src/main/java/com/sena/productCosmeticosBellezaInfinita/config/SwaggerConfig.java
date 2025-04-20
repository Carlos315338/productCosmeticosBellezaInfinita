package com.sena.productCosmeticosBellezaInfinita.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${spring.application.name}")
    public String appName;

    @Bean
    public OpenAPI openAPIInformation(){
        return new OpenAPI()
            .info(new io.swagger.v3.oas.models.info.Info()
                .title(appName + " - Usuarios API")
                .description("Gestión de Usuarios.")
                .version("v1.0")
                .license(new License()
                    .name("")
                    .url(""))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .name("")
                    .email("")));
    }


}
