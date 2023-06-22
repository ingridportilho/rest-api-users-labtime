package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Usuarios;

public interface UsuarioService {

    Usuarios save(Usuarios usuario);

    List<Usuarios> findAll();

    Optional<Usuarios> findById(int id);

    Usuarios update(Usuarios usuario);

    void deleteById(int id);

}
