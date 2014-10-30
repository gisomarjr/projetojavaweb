package com.vendas.negocio;

import java.util.List;

import com.vendas.basicas.Departamento;
import com.vendas.basicas.Fornecedor;
import com.vendas.basicas.Loja;
import com.vendas.dao.DAOFornecedor;
import com.vendas.dao.DAOLoja;



public class NLoja {

	DAOLoja daol = new DAOLoja();
	
	public void cadastrar(Loja loja) throws Exception{
		
		daol.cadastrar(loja);
	}

	public Loja consultar(Integer id) {
		
		return daol.consultarPorId(id);
	}

	public List<Loja> listar() {
		// TODO Auto-generated method stub
		return daol.listar();
	}
	
}
