package com.vendas.negocio;

import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.dao.DAOEndereco;
import com.vendas.dao.DAOFornecedor;



public class NEndereco {

	DAOEndereco daoe = new DAOEndereco();
	
	public void cadastrar(Endereco endereco) throws Exception{
		
		daoe.cadastrar(endereco);
	}

	public Endereco consultar(Integer id) {
		
		return daoe.consultarPorId(id);
	}
	
}