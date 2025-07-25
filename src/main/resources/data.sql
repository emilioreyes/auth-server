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
    enabled
) VALUES
-- Cliente confidencial
(
    'client-app',
    '{noop}12345',
    'client_secret_basic',
    'authorization_code,refresh_token',
    'http://127.0.0.1:8081/login/oauth/code/client-app,http://127.0.0.1:8081/authorized',
    'http://127.0.0.1:8081/logout',
    'read,write,openid,profile',
    false,
    60,
    43200,
    true
),
-- Cliente público Angular
(
    'angular-client',
    '{noop}123456',
    'client_secret_basic',
    'authorization_code,refresh_token',
    'http://localhost:4200/authorized',
    NULL,
    'read,write,openid,profile',
    false,
    60,
    43200,
    true
);