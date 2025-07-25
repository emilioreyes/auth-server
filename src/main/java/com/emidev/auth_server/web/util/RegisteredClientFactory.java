package com.emidev.auth_server.web.util;

import com.emidev.auth_server.persistence.entity.OAuth2ClientEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.util.Arrays;
import java.util.UUID;

/**
 * Esta clase es responsable de crear instancias de RegisteredClient a partir de OAuth2ClientEntity.
 */
public class RegisteredClientFactory {
    public static RegisteredClient fromEntity(OAuth2ClientEntity entity){
        RegisteredClient.Builder builder = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId(entity.getClientId())
                .clientSecret(entity.getClientSecret())
                .clientSettings(ClientSettings.builder()
                        .requireAuthorizationConsent(entity.isRequireConsent())
                        .requireProofKey(true)
                        .build())
                .tokenSettings(TokenSettings.builder()
                        .accessTokenTimeToLive(Duration.ofMinutes(entity.getAccessTokenTtlMinutes())) // Token de acceso válido por 1 hora
                        .refreshTokenTimeToLive(Duration.ofHours(entity.getRefreshTokenTtlMinutes())) // Token de actualización válido por 30 días
                        .reuseRefreshTokens(true) // Permitir reutilización de tokens de actualización
                        .build()
                );

        Arrays.stream(entity.getClientAuthenticationMethods().split(","))
                .map(String::trim)
                .filter(s-> !s.isEmpty())
                .map(ClientAuthenticationMethod::new)
                .forEach(builder::clientAuthenticationMethod);
// Tipos de grant
        Arrays.stream(entity.getAuthorizationGrantTypes().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(AuthorizationGrantType::new)
                .forEach(builder::authorizationGrantType);

        // Redirect URIs
        if (entity.getRedirectUris() != null && !entity.getRedirectUris().isEmpty()) {
            Arrays.stream(entity.getRedirectUris().split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .forEach(builder::redirectUri);
        }

        // Post logout URIs
        if (entity.getPostLogoutRedirectUris() != null && !entity.getPostLogoutRedirectUris().isEmpty()) {
            Arrays.stream(entity.getPostLogoutRedirectUris().split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .forEach(builder::postLogoutRedirectUri);
        }

        // Scopes
        if (entity.getScopes() != null && !entity.getScopes().isEmpty()) {
            Arrays.stream(entity.getScopes().split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .forEach(builder::scope);
        }

        return builder.build();
    }
}
