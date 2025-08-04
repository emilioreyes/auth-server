package com.emidev.auth_server.web.controller.seguridad;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class CustomRequestCache extends HttpSessionRequestCache {
    private static final Logger logger = LoggerFactory.getLogger(CustomRequestCache.class);
    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        // Ignora peticiones internas de navegador y archivos estáticos
        if (uri.contains(".well-known/appspecific/com.chrome.devtools.json") ||
                uri.startsWith("/error") ||
                uri.startsWith("/favicon.ico") ||
                uri.startsWith("/default-ui.css")) {
            logger.info("CustomRequestCache: Ignorando request: {}", uri);
            return;
        }
        logger.info("CustomRequestCache: Guardando request: {}?{}", uri, request.getQueryString());
        super.saveRequest(request, response);
    }
}