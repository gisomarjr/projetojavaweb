package com.vendas.negocio;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.dao.DAOCliente;
import com.vendas.dao.DAOCliente;

public class NCliente {

	DAOCliente daoc = new DAOCliente();
	
	
	
	public void cadastrar(Cliente cliente) throws Exception{
		
		
		daoc.cadastrar(cliente);
	
	}

	public Cliente consultar(Integer id) {
		
		return daoc.consultarPorId(id);
	}
	
}
