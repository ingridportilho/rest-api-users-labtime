package com.example.service;

import com.example.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(int id);

    Usuario update(Usuario usuario);

    void deleteById(int id);

}
