package com.emidev.auth_server.persistence;

import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioDTO;
import com.emidev.auth_server.domain.repository.seguridad.SegUsuarioRepositoryDomain;
import com.emidev.auth_server.persistence.entity.seguridad.SegUsuarioEntity;
import com.emidev.auth_server.persistence.mapper.seguridad.SegUsuarioMapper;
import com.emidev.auth_server.persistence.mapper.seguridad.helper.SegUsuarioMapperHelper;
import com.emidev.auth_server.persistence.repository.seguridad.SegUsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SegUsuarioRepositoryDomainImpl implements SegUsuarioRepositoryDomain {

    private  final SegUsuarioRepository segUsuarioRepository;
    private final SegUsuarioMapper segUsuarioMapper;
    private final SegUsuarioMapperHelper segUsuarioMapperHelper;

    public SegUsuarioRepositoryDomainImpl(SegUsuarioRepository segUsuarioRepository, SegUsuarioMapper segUsuarioMapper, SegUsuarioMapperHelper segUsuarioMapperHelper) {
        this.segUsuarioRepository = segUsuarioRepository;
        this.segUsuarioMapper = segUsuarioMapper;
        this.segUsuarioMapperHelper = segUsuarioMapperHelper;
    }


    @Override
    public SegUsuarioDTO save(SegUsuarioDTO user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        SegUsuarioEntity usuarioEntity = segUsuarioMapper.toEntity(user);
        return segUsuarioMapper.toDto(segUsuarioRepository.save(usuarioEntity),segUsuarioMapperHelper);
    }

    @Override
    public SegUsuarioDTO update(SegUsuarioDTO user, Long id) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return segUsuarioRepository.findById(id).map(entity->{
            entity.setUsuario(user.getUsername());
            entity.setClave(user.getPassword());
            return segUsuarioMapper.toDto(segUsuarioRepository.save(entity),segUsuarioMapperHelper);
        }).orElseThrow(()->new IllegalArgumentException(
                "Usuario con ID " + user.getId() + " no se encuentra registrado."));
    }

    @Override
    public Boolean delete(Long userId) {
        return null;
    }

    @Override
    public List<SegUsuarioDTO> getAll() {
        return segUsuarioMapper.toDtoList(segUsuarioRepository.findAll(), segUsuarioMapperHelper);
    }

    @Override
    public SegUsuarioDTO getByUsername(String usuario) {
        return segUsuarioRepository.findByUsername(usuario).map(entity-> segUsuarioMapper.toDto(entity, segUsuarioMapperHelper))
                .orElseThrow(() -> new IllegalArgumentException("Usuario con nombre " + usuario + " no se encuentra registrado."));
    }
}
