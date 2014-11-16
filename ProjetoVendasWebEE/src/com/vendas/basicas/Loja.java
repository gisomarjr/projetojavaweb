package com.vendas.basicas;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Loja {
	
	@Id
	@GeneratedValue
	Integer id;
	
	String nome;
	String razao_social;
	String cnpj;
	String email;
	String telefone_comercial;
	
	@OneToMany(mappedBy="loja", fetch = FetchType.LAZY)
	private
	Collection<Funcionario> funcionarios;
	
	@OneToOne(mappedBy="loja")
	Endereco endereco;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="loja_produto", 
	joinColumns=@JoinColumn(name="id_loja"),
	inverseJoinColumns=@JoinColumn(name="id_produto"))
	Collection<Produto> produtos;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="loja_departamento", 
	joinColumns=@JoinColumn(name="id_loja"),
	inverseJoinColumns=@JoinColumn(name="id_departamento"))
	Collection<Departamento> departamentos;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone_comercial() {
		return telefone_comercial;
	}
	public void setTelefone_comercial(String telefone_comercial) {
		this.telefone_comercial = telefone_comercial;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Collection<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
	public Collection<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(Collection<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
	

}
