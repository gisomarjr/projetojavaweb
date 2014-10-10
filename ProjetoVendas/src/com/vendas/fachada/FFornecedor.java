package com.vendas.fachada;

import com.vendas.basicas.Fornecedor;
import com.vendas.negocio.NFornecedor;



public class FFornecedor {

	NFornecedor nf = new NFornecedor();
	
	public void cadastrar(Fornecedor fornecedor) throws Exception{
		
		nf.cadastrar(fornecedor);
	}

	public Fornecedor consultar(Integer id) {
		
		return nf.consultar(id);
		
	}
}
