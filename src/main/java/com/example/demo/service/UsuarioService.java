package com.example.demo.service;

import java.util.Optional;
import java.util.List;
import com.example.demo.model.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

    Usuarios save(Usuarios usuario);

    List<Usuarios> findAll();

    Page<Usuarios> findPage(Pageable pageable);

    Optional<Usuarios> findById(int id);

    Usuarios update(Usuarios usuario);

    void deleteById(int id);

}
