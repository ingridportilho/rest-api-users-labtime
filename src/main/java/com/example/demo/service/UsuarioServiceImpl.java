package com.example.demo.service;

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
		return usuarioRepository.findById(id);
	}

	public Usuarios update(Usuarios usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deleteById(int id) {
		usuarioRepository.deleteById(id);
		
	}

	public void processaCsv(String filePath){
		List<Usuarios> usuarios = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){

			String linha;
			boolean primeiraLinha = true;

			while((linha = reader.readLine()) != null){
				if (primeiraLinha) {
					primeiraLinha = false;
					continue;
				}
				Usuarios usuario = criarUsuario(linha);
				usuarioRepository.save(usuario);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	private Usuarios criarUsuario(String linha){
		String[] data = linha.split(",");

		Usuarios usuario = new Usuarios();

		usuario.setNomeCompleto(data[0]);
		usuario.setNomeSocial(data[1]);
		usuario.setDataDeNascimento(data[2]);
		usuario.setCodigo(Integer.parseInt(data[3]));
		usuario.setSexo(data[4]);
		usuario.setEmail(data[5]);
		usuario.setEstado(data[6]);
		usuario.setMunicipio(data[7]);
		usuario.setNumeroDeAcessos(Integer.parseInt((data[8])));
		usuario.setSituacao(data[9]);
		usuario.setDataDeVinculo(data[10]);

		return usuario;
	}
}
