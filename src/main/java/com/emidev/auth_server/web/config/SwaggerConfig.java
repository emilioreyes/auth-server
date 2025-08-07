package com.emidev.auth_server.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;

@Profile("dev")
@Configuration
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
        ),
        security = @SecurityRequirement(
                name = "Security token"
        )
)
@SecurityScheme(
        name = "Security token",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in= SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
}
