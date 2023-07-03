package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.model.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{
    List<Usuarios> findByNomeCompleto(String nomeCompleto);
    List<Usuarios> findByNomeSocial(String nomeSocial);
    List<Usuarios> findByEmail(String email);
}