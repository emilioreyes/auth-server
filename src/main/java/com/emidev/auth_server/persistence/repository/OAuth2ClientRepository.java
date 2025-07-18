package com.emidev.auth_server.persistence.repository;

import com.emidev.auth_server.persistence.entity.OAuth2ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuth2ClientRepository extends JpaRepository<OAuth2ClientEntity, Long> {


}
