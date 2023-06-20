package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable int id){
    	System.out.println("Entrei");
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        usuarioService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
