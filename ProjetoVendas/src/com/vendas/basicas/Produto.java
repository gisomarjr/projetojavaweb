package com.vendas.basicas;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue
	Integer id;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="produto_pedido", 
	joinColumns=@JoinColumn(name="id_produto"),
	inverseJoinColumns=@JoinColumn(name="id_pedido"))
	Collection<Pedido> pedidos;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="loja_produto",
	joinColumns= {@JoinColumn(name="id_produto")},
	inverseJoinColumns = {@JoinColumn(name="id_loja")})
	Collection<Loja> lojas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_fornecedor")
	@Fetch(FetchMode.JOIN)
	Fornecedor fornecedor;
	
	
	String nome;
	Double preco_produto;
	Date data_vencimento;
	
	String descricao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Collection<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public Collection<Loja> getLojas() {
		return lojas;
	}
	public void setLojas(Collection<Loja> lojas) {
		this.lojas = lojas;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco_produto() {
		return preco_produto;
	}
	public void setPreco_produto(Double preco_produto) {
		this.preco_produto = preco_produto;
	}
	public Date getData_vencimento() {
		return data_vencimento;
	}
	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
