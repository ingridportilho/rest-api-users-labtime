package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

    Usuarios save(Usuarios usuario);

    Page<Usuarios> findAll(Pageable pageable);

    Optional<Usuarios> findById(int id);

    Usuarios update(Usuarios usuario);

    void deleteById(int id);

}
