package com.example.demo.service;

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl{

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	public Usuarios save(Usuarios usuario) {
		return usuarioRepository.save(usuario);
	}

	public List<Usuarios> findAll() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuarios> findById(int id) {
		System.out.println("Entrei - service");
		Optional<Usuarios> usuarioBD = usuarioRepository.findById(id);
		if(usuarioBD.isPresent()) {
			System.out.println(usuarioBD.get().getCodigo());
		}
		return usuarioBD;
	}

	public Usuarios update(Usuarios usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deleteById(int id) {
		usuarioRepository.deleteById(id);
		
	}

}
