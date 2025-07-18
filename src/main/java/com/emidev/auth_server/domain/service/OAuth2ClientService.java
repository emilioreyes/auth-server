package com.emidev.auth_server.domain.service;

import com.emidev.auth_server.persistence.entity.OAuth2ClientEntity;
import com.emidev.auth_server.persistence.repository.OAuth2ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OAuth2ClientService {

    private final OAuth2ClientRepository oAuth2ClientRepository;

    public OAuth2ClientService(OAuth2ClientRepository oAuth2ClientRepository) {
        this.oAuth2ClientRepository = oAuth2ClientRepository;
    }

    public List<OAuth2ClientEntity>all(){
        return oAuth2ClientRepository.findAll();
    }
}
