package com.emidev.auth_server.web.config;

import com.emidev.auth_server.domain.service.OAuth2ClientService;
import com.emidev.auth_server.persistence.entity.OAuth2ClientEntity;
import com.emidev.auth_server.web.util.RegisteredClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta clase configura los clientes registrados en el servidor de autorización.
 */
@Configuration
public class RegisteredClientConfig {
    private final OAuth2ClientService clientService;

    public RegisteredClientConfig(OAuth2ClientService clientService) {
        this.clientService = clientService;
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        List<OAuth2ClientEntity> clientEntities = clientService.all();
        /**
         * Convierte las entidades de cliente OAuth2 a RegisteredClient.
         */
        List<RegisteredClient> registeredClients = clientEntities.stream()
                .map(RegisteredClientFactory::fromEntity)
                .collect(Collectors.toList());

        return new InMemoryRegisteredClientRepository(registeredClients);
    }
}
