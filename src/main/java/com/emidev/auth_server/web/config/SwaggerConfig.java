package com.emidev.auth_server.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Emidev Auth Server API",
                version = "1.0.0",
                description = "API for Emidev Authentication Server",
                contact =   @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Emilio Reyes",
                        email = "emiliorr2013@gmail.com"
                        )
        ),
        servers = @io.swagger.v3.oas.annotations.servers.Server(
                url = "http://localhost:9000",
                description = "Local server"
        )
)
public class SwaggerConfig {
}
