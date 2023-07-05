package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioServiceImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    public ResponseEntity<List<Usuarios>> findAll(@RequestParam(value = "filtro", required = false) String filtro){
        List result = new ArrayList<>();
        List temp;
        if(filtro != null){
            temp = usuarioRepository.findByNomeCompleto(filtro);
            if(!temp.isEmpty()){
                result.add(temp);
            }
            temp = usuarioRepository.findByNomeSocial(filtro);
            if(!temp.isEmpty()){
                result.add(temp);
            }
            temp = usuarioRepository.findByEmail(filtro);
            result = (List<Usuarios>) result;
            if(!temp.isEmpty()){
                result.add(temp);
            }
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/paginacao")
    public Page findPage(@RequestParam(value = "numberPage", required = true) int numberPage,
                         @RequestParam(value = "pageSize", required = true) int pageSize){
        Pageable pageable = PageRequest.of(numberPage, pageSize);
        return usuarioService.findPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuarios>> findById(@PathVariable int id){
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
