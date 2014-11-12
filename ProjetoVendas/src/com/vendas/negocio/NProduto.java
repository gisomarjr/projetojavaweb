package com.vendas.negocio;

import java.util.List;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Produto;
import com.vendas.dao.DAOCliente;
import com.vendas.dao.DAOCliente;
import com.vendas.dao.DAOProduto;

public class NProduto {

	DAOProduto daop = new DAOProduto();
	
	
	
	public void cadastrar(Produto produto) throws Exception{
		
		
		daop.cadastrar(produto);
	
	}

	public Produto consultar(Integer id) {
		
		return daop.consultarPorId(id);
	}
	
	public void excluir(Produto produto){
		
		daop.excluir(produto);
	
	}

	public List<Produto> listar() {
		
		return daop.listar();
	}

	public void alterar(Produto produto) {
		
		daop.editar(produto);
	}
	
}
