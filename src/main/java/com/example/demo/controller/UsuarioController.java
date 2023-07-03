package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")

public class UsuarioController {

   
    private final UsuarioServiceImpl usuarioService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioServiceImpl usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> findAll(@RequestParam(value = "nomeCompleto", required = false) String nomeCompleto,
                                                  @RequestParam(value = "nomeSocial", required = false) String nomeSocial,
                                                  @RequestParam(value = "email", required = false) String email){
        if(nomeCompleto != null){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findByNomeCompleto(nomeCompleto));
        }
        if(nomeSocial != null){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findByNomeSocial(nomeSocial));
        }
        if(email != null){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findByEmail(email));
        }
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

    @PostMapping("/carregaCSV")
    public void processCsvFile() {
        String path = "usuarios.csv";
        ClassPathResource resource = new ClassPathResource(path);
        File file;
        try {
            file = resource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        usuarioService.processaCsv(file.getAbsolutePath());

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
