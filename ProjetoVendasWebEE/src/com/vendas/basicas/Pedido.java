package com.vendas.basicas;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue
	Integer id;
	
	Date data_pedido;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="produto_pedido",
	joinColumns= {@JoinColumn(name="id_pedido")},
	inverseJoinColumns = {@JoinColumn(name="id_produto")})
	Collection<Produto> produtos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	@Fetch(FetchMode.JOIN)
	Cliente cliente;
	
	
	@OneToOne
	@JoinColumn(name="id_entrega")
	Entrega entrega;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData_pedido() {
		return data_pedido;
	}
	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}
	public Collection<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	

}
