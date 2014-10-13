package com.vendas.negocio;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.dao.DAOCliente;
import com.vendas.dao.DAOClienteGenerico;

public class NCliente {

	DAOCliente daoc = new DAOCliente();
	
	DAOClienteGenerico daogc = new DAOClienteGenerico();
	
	public void cadastrar(Cliente cliente) throws Exception{
		
		//daoc.cadastrar(cliente);
		daogc.persist(cliente);
	}

	public Cliente consultar(Integer id) {
		
		return daoc.consultarPorId(id);
	}
	
}
