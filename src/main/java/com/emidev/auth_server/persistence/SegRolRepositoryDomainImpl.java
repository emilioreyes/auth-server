package com.emidev.auth_server.persistence;

import com.emidev.auth_server.domain.dto.seguridad.SegRolDTO;
import com.emidev.auth_server.domain.repository.seguridad.SegRolRepositoryDomain;
import com.emidev.auth_server.persistence.entity.seguridad.SegRolEntity;
import com.emidev.auth_server.persistence.mapper.seguridad.SegRolMapper;
import com.emidev.auth_server.persistence.mapper.seguridad.SegUsuarioMapper;
import com.emidev.auth_server.persistence.mapper.seguridad.helper.SegRolMapperHelper;
import com.emidev.auth_server.persistence.repository.seguridad.SegRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SegRolRepositoryDomainImpl implements SegRolRepositoryDomain {

    private final SegRolRepository segRolRepository;
    private final SegRolMapper segRolMapper;

    private  final SegRolMapperHelper segRolMapperHelper;

    @Autowired
    private SegUsuarioMapper segUsuarioMapper;
    public SegRolRepositoryDomainImpl(SegRolRepository segRolRepository, SegRolMapper segRolMapper, SegRolMapperHelper segRolMapperHelper) {
        this.segRolRepository = segRolRepository;
        this.segRolMapper = segRolMapper;
        this.segRolMapperHelper = segRolMapperHelper;
    }

    @Override
    public SegRolDTO save(SegRolDTO segRolDto) {
        SegRolEntity segRolEntity = segRolMapper.toEntity(segRolDto);
        return segRolMapper.toDto(segRolRepository.save(segRolEntity), segRolMapperHelper);
    }

    @Override
    public SegRolDTO update(SegRolDTO segRolDto, String rol) {
        return segRolRepository.findById(rol).map(entity -> {
            entity.setRol(segRolDto.getRol());
            entity.setDescripcion(segRolDto.getDescription());
            return segRolMapper.toDto(segRolRepository.save(entity), segRolMapperHelper);
        }).orElseThrow(() -> new IllegalArgumentException(
                "Rol " + rol + " no se encuentra registrado."));
    }

    @Override
    public Boolean delete(String rolId) {
        return null;
    }

    @Override
    public List<SegRolDTO> all() {
        return segRolMapper.toDtoList(segRolRepository.findAllWithUsers().get(), segRolMapperHelper);
    }
}
