package com.emidev.auth_server.web.controller.seguridad;

import com.emidev.auth_server.domain.dto.seguridad.SegUsuarioDTO;
import com.emidev.auth_server.domain.service.seguridad.SegUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seg-usuario")
public class SegUsuarioController {

    private final SegUsuarioService segUsuarioService;

    public SegUsuarioController(SegUsuarioService segUsuarioService) {
        this.segUsuarioService = segUsuarioService;
    }

     @GetMapping("/users")
     public ResponseEntity<List<SegUsuarioDTO>>  getAll() {
        return new ResponseEntity<>(segUsuarioService.getAll(), org.springframework.http.HttpStatus.OK);
     }
    @GetMapping("/users/{username}")
    public ResponseEntity<SegUsuarioDTO> getByUsername(@PathVariable String username) {
        SegUsuarioDTO user = segUsuarioService.getByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, org.springframework.http.HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/users")
    public ResponseEntity<SegUsuarioDTO> create(@RequestBody SegUsuarioDTO user) {
         return new ResponseEntity<>(segUsuarioService.save(user), org.springframework.http.HttpStatus.CREATED);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<SegUsuarioDTO> update(@RequestBody SegUsuarioDTO user, @PathVariable Long id) {
        System.out.println(user.toString());
        SegUsuarioDTO updatedUser = segUsuarioService.update(user,id);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, org.springframework.http.HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }

}
