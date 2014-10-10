package com.vendas.fachada;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.negocio.NCliente;

public class FCliente {

	NCliente nc = new NCliente();
	
	public void cadastrar(Cliente cliente) throws Exception{
		
		nc.cadastrar(cliente);
	}

	public Cliente consultar(Integer id) {
		
		return nc.consultar(id);
		
	}
}
