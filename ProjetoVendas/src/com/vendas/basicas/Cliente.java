package com.vendas.basicas;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@DiscriminatorValue("CLI")
public class Cliente extends Pessoa {

		
	@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY)
	@Cascade(CascadeType.PERSIST)
	Collection<Endereco> endereco;
	
	@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY)
	Collection<Pedido> pedido;

	public Collection<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(Collection<Endereco> endereco) {
		this.endereco = endereco;
	}
	public Collection<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(Collection<Pedido> pedido) {
		this.pedido = pedido;
	}
}
