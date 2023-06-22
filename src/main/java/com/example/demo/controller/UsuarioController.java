package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.service.UsuarioServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")

public class UsuarioController {

   
    private final UsuarioServiceImpl usuarioService;
    
    public UsuarioController(UsuarioServiceImpl usuarioService) {
    	this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuarios>> findById(@PathVariable int id){
    	System.out.println("Entrei");
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuarios> create(@RequestBody Usuarios usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }
   

    @PutMapping
    public ResponseEntity<Usuarios> update(@RequestBody Usuarios usuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        usuarioService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
