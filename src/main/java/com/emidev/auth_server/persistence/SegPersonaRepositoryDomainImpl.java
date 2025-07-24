package com.emidev.auth_server.persistence;

import com.emidev.auth_server.domain.dto.seguridad.SegPersonaDTO;
import com.emidev.auth_server.domain.repository.seguridad.SegPersonaRepositoryDomain;
import com.emidev.auth_server.persistence.entity.seguridad.SegPersonaEntity;
import com.emidev.auth_server.persistence.mapper.seguridad.SegPersonaMapper;
import com.emidev.auth_server.persistence.repository.seguridad.SegPersonaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SegPersonaRepositoryDomainImpl implements SegPersonaRepositoryDomain {
    private final SegPersonaRepository segPersonaRepository;
    private final SegPersonaMapper  segPersonaMapper;

    public SegPersonaRepositoryDomainImpl(SegPersonaRepository segPersonaRepository, SegPersonaMapper segPersonaMapper) {
        this.segPersonaRepository = segPersonaRepository;
        this.segPersonaMapper = segPersonaMapper;
    }

    @Override
    public SegPersonaDTO save(SegPersonaDTO segPersonaDto) {
        SegPersonaEntity segPersonaEntity = segPersonaMapper.toEntity(segPersonaDto);
        return segPersonaMapper.toDto(segPersonaRepository.save(segPersonaEntity));
    }

    @Override
    public SegPersonaDTO update(SegPersonaDTO segPersonaDto, Long id) {
    return segPersonaRepository.findById(id).map(persona-> {
            persona.setNombres(segPersonaDto.getNames());
            persona.setApellido1(segPersonaDto.getLastname1());
            persona.setApellido2(segPersonaDto.getLastname2());
            persona.setEmail(segPersonaDto.getEmail());
            persona.setTelefono(segPersonaDto.getPhone());
            return segPersonaMapper.toDto(segPersonaRepository.save(persona));
        }).orElseThrow(() -> new RuntimeException("Persona con id: " + id+" no encontrada"));
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public List<SegPersonaDTO> getAll() {
        return segPersonaMapper.toDtoList( segPersonaRepository.findAll());
    }

    @Override
    public SegPersonaDTO getById(Long id) {
    return segPersonaRepository.findById(id)
            .map(segPersonaMapper::toDto)
            .orElseThrow(() -> new RuntimeException("Persona con id: " + id + " no encontrada"));
    }
}
