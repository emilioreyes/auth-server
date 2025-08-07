package com.emidev.auth_server.web.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

public class SecurityRulesHelper {
    private static final String[] AUTH_WHITELIST = {
            "/api-docs/**",
            "/swagger-ui/**"
    };

    private static final String[] ADMIN_LIST = {
            "/api/seg-usuario/**",
            "/api/seg-rol/**",
            "/api/seg-persona/**",
    };
    public static void configureSwaggerAccess(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
        auth.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**")
                .hasRole("ADMIN");
    }
    public static void configureWhiteList(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
        auth.requestMatchers(AUTH_WHITELIST).permitAll();
    }
    public static void configureAdminList(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
        auth.requestMatchers(ADMIN_LIST).hasRole("ADMIN");
    }
}
