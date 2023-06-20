package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Usuario;

public interface UsuarioService {

    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(int id);

    Usuario update(Usuario usuario);

    void deleteById(int id);

}
