package com.vendas.negocio;

import com.vendas.basicas.Fornecedor;
import com.vendas.dao.DAOFornecedor;



public class NFornecedor {

	DAOFornecedor daof = new DAOFornecedor();
	
	public void cadastrar(Fornecedor fornecedor) throws Exception{
		
		daof.cadastrar(fornecedor);
	}

	public Fornecedor consultar(Integer id) {
		
		return daof.consultarPorId(id);
	}
	
}
