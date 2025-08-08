INSERT INTO oauth2_client (
    client_id,
    client_secret,
    client_authentication_methods,
    authorization_grant_types,
    redirect_uris,
    post_logout_redirect_uris,
    scopes,
    require_consent,
    access_token_ttl_minutes,
    refresh_token_ttl_minutes,
    enabled,
    require_proof_key
) VALUES
-- Cliente confidencial
(
    'user-app',
    '$2a$12$Ss4r9UEPKp53dy9Y5H1Q6OvfbIOlPhoY4Gazkbose7PN9YIURzfQq',
    'client_secret_basic',
    'authorization_code,refresh_token',
    'http://127.0.0.1:8081/login/oauth/code/user-app,http://127.0.0.1:8081/authorized',
    'http://127.0.0.1:8081/logout',
    'read,write,openid,profile',
    false,
    60,
    43200,
    true,
    true
),
-- Cliente público Angular
(
    'angular-client',
    '$2a$10$KMKd/K5kvFFAB417FO0af.tIdyjzk3PwP5CjGw0Dbc4KTb.LH/9mi',
    'client_secret_basic',
    'authorization_code,refresh_token',
    'http://127.0.0.1:4200/authorized',
    NULL,
    'read,write,openid,profile',
    false,
    60,
    43200,
    true,
    true
);