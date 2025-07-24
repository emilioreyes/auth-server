package com.emidev.auth_server.web.controller.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegRolDTO;
import com.emidev.auth_server.domain.service.seguridad.SegRolService;
import com.emidev.auth_server.persistence.entity.seguridad.SegRolEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seg-rol")
public class SegRolController {

    private  final SegRolService segRolService;

    public SegRolController(SegRolService segRolService) {
        this.segRolService = segRolService;
    }
    @PostMapping("/roles")
    public ResponseEntity<SegRolDTO> create(@RequestBody SegRolDTO segRolDTO) {
        SegRolDTO createdRole = segRolService.save(segRolDTO);
        return new ResponseEntity<>(createdRole, org.springframework.http.HttpStatus.CREATED);
    }
    @PutMapping("/roles/{rol}")
    public ResponseEntity<SegRolDTO> update(@RequestBody SegRolDTO segRolDto, @PathVariable String rol) {
        SegRolDTO updatedRole = segRolService.update(segRolDto, rol);
        if (updatedRole != null) {
            return new ResponseEntity<>(updatedRole, org.springframework.http.HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping ("/roles")
    public ResponseEntity<List<SegRolDTO>> getAll() {
        List<SegRolDTO> roles = segRolService.all();
        return new ResponseEntity<>(roles, org.springframework.http.HttpStatus.OK);
    }
}
