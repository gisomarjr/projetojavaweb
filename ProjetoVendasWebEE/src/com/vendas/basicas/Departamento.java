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

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue
	Integer id;
	
	@OneToMany(mappedBy="departamento", fetch = FetchType.LAZY)
	Collection<Funcionario> funcionarios;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="loja_departamento",
	joinColumns= {@JoinColumn(name="id_departamento")},
	inverseJoinColumns = {@JoinColumn(name="id_loja")})
	Collection<Loja> lojas;
	
	
	String nome;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Collection<Loja> getLojas() {
		return lojas;
	}
	public void setLojas(Collection<Loja> lojas) {
		this.lojas = lojas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
