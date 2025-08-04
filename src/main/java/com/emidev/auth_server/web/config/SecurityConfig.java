package com.emidev.auth_server.web.config;

import com.emidev.auth_server.web.controller.seguridad.CustomRequestCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@Import(CorsConfig.class)
public class SecurityConfig {
    private final CorsConfig corsConfig;

    public SecurityConfig(CorsConfig corsConfig) {
        this.corsConfig = corsConfig;
    }
    /**
     * The default Security Filter Chain is responsible for processing all incoming requests to the application.
     * Configure the jwtAuthenticationConverter to use the custom JwtAuthenticationConverterCustom.
     *
     */
    @Bean
    @Order(2)
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {
        Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter = new JwtAuthenticationConverterCustom();
        http.authorizeHttpRequests(auth -> {
                    SecurityRulesHelper.configureWhiteList(auth);
                    SecurityRulesHelper.configureAdminList(auth);
                    auth.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .cors(cors -> cors.configurationSource(corsConfig.corsConfigurationSource()))
                .oauth2ResourceServer(oauth2ResourceServerCustomizer);
        return http.build();
    }
    private final Customizer<OAuth2ResourceServerConfigurer<HttpSecurity>> oauth2ResourceServerCustomizer = oauth2ResourceServer -> {
        oauth2ResourceServer.jwt(jwt -> {
            jwt.jwtAuthenticationConverter(new JwtAuthenticationConverterCustom());
        });
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
