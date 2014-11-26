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
public class Fornecedor {

	@Id
	@GeneratedValue
	Integer id;
	
	String razaoSocial;
	String nomeFantasia;
	String cnpj;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="fornecedor_loja", 
	joinColumns=@JoinColumn(name="id_fornecedor"),
	inverseJoinColumns=@JoinColumn(name="id_loja"))
	Collection<Loja> lojas;
	
	
	@OneToMany(mappedBy="fornecedor", fetch = FetchType.LAZY)
	Collection<Produto> produtos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Collection<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
	/**
	 * @return the lojas
	 */
	public Collection<Loja> getLojas() {
		return lojas;
	}
	/**
	 * @param lojas the lojas to set
	 */
	public void setLojas(Collection<Loja> lojas) {
		this.lojas = lojas;
	}
 	
}
