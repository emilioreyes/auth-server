package com.emidev.auth_server.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "oauth2_client")
@Getter @Setter
@Where(clause = "enabled = true")
public class OAuth2ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id", nullable = false, unique = true, length = 100)
    private String clientId;

    @Column(name = "client_secret", length = 200)
    private String clientSecret;

    @Column(name = "client_authentication_methods", nullable = false, length = 200)
    private String clientAuthenticationMethods; // CSV: "client_secret_basic,none"

    @Column(name = "authorization_grant_types", nullable = false, length = 200)
    private String authorizationGrantTypes; // CSV: "authorization_code,refresh_token"

    @Column(name = "redirect_uris", length = 1000)
    private String redirectUris; // CSV

    @Column(name = "post_logout_redirect_uris", length = 1000)
    private String postLogoutRedirectUris; // CSV

    @Column(name = "scopes", length = 500)
    private String scopes; // CSV: "openid,profile,read,write"

    @Column(name = "require_consent", nullable = false)
    private boolean requireConsent = false;

    @Column(name = "access_token_ttl_minutes", nullable = false)
    private Integer accessTokenTtlMinutes = 60;

    @Column(name = "refresh_token_ttl_minutes", nullable = false)
    private Integer refreshTokenTtlMinutes = 43200;

    @Column(name = "enabled", nullable = true)
    private boolean enabled = true;

    public boolean isPublicClient() {
        return clientAuthenticationMethods != null && clientAuthenticationMethods.contains("none");
    }

    public boolean isConfidentialClient() {
        return clientAuthenticationMethods != null &&
                (clientAuthenticationMethods.contains("client_secret_basic")
                        || clientAuthenticationMethods.contains("client_secret_post")
                        || clientAuthenticationMethods.contains("client_secret_jwt"));
    }
}
