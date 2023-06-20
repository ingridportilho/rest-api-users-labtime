package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl{

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(int id) {
		System.out.println("Entrei - service");
		Optional<Usuario> usuarioBD = usuarioRepository.findById(id);
		if(usuarioBD.isPresent()) {
			System.out.println(usuarioBD.get().getCodigo());
		}
		return usuarioBD;
	}

	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deleteById(int id) {
		usuarioRepository.deleteById(id);
		
	}

}
