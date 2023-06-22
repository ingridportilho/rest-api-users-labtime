package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuarios {
	
	private String nome_completo;
	private String nome_social;
	private String data_de_nascimento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	private String sexo;
	private String email;
	private String estado;
	private String municipio;
	private int numerodeacessos;
	private String situacao;
	private String data_de_vinculo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomeCompleto() {
		return nome_completo;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nome_completo = nomeCompleto;
	}
	public String getNomeSocial() {
		return nome_social;
	}
	public void setNomeSocial(String nomeSocial) {
		this.nome_social = nomeSocial;
	}
	public String getDataDeNascimento() {
		return data_de_nascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.data_de_nascimento = dataDeNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public int getNumeroDeAcessos() {
		return numerodeacessos;
	}
	public void setNumeroDeAcessos(int numeroDeAcessos) {
		this.numerodeacessos = numeroDeAcessos;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getDataDeVinculo() {
		return data_de_vinculo;
	}
	public void setDataDeVinculo(String dataDeVinculo) {
		this.data_de_vinculo = dataDeVinculo;
	}
}
