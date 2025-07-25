package com.emidev.auth_server.web.controller.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegPersonaDTO;
import com.emidev.auth_server.domain.service.seguridad.SegPersonaService;
import com.emidev.auth_server.persistence.entity.seguridad.SegPersonaEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seg-persona")
public class SegPersonaController {
    private final SegPersonaService segPersonaService;

    public SegPersonaController(SegPersonaService segPersonaService) {
        this.segPersonaService = segPersonaService;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<SegPersonaDTO>>getAll(){
        return new ResponseEntity<>(segPersonaService.getAll(), org.springframework.http.HttpStatus.OK);
    }
    @GetMapping("/persons/{id}")
    public ResponseEntity<SegPersonaDTO>findById(@PathVariable Long id){
        return new ResponseEntity<>(segPersonaService.getById(id), org.springframework.http.HttpStatus.OK);
    }

    @PostMapping("/persons")
    private ResponseEntity<SegPersonaDTO> create(@RequestBody SegPersonaDTO segPersonaDto) {
        return new ResponseEntity<>(segPersonaService.save(segPersonaDto), org.springframework.http.HttpStatus.CREATED);
    }
    @PutMapping("/persons/{id}")
    private ResponseEntity<SegPersonaDTO> update(@RequestBody SegPersonaDTO segPersonaDTO, @PathVariable Long id) {
        SegPersonaDTO updatedPersona = segPersonaService.update(segPersonaDTO, id);
        if (updatedPersona != null) {
            return new ResponseEntity<>(updatedPersona, org.springframework.http.HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }
}
