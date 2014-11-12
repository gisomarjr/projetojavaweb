package com.vendas.fachada;

import java.util.List;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Produto;
import com.vendas.negocio.NCliente;
import com.vendas.negocio.NProduto;

public class FProduto {

	NProduto np = new NProduto();
	
	public void cadastrar(Produto produto) throws Exception{
		
		np.cadastrar(produto);
	}

	public Produto consultar(Integer id) {
		
		return np.consultar(id);
		
	}
	
	public void excluir(Produto produto){
		np.excluir(produto);
	}
	
	public List<Produto> listar() {
	
		return np.listar();
	}
	
	public void alterar(Produto produto){
		
		np.alterar(produto);		
	}
	
}
