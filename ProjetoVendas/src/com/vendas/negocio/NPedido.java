package com.vendas.negocio;

import java.util.List;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Pedido;
import com.vendas.dao.DAOCliente;
import com.vendas.dao.DAOCliente;
import com.vendas.dao.DAOPedido;

public class NPedido {

	DAOPedido daop = new DAOPedido();
	
	
	
	public void cadastrar(Pedido pedido) throws Exception{
		
		
		daop.cadastrar(pedido);
	
	}

	public Pedido consultar(Integer id) {
		
		return daop.consultarPorId(id);
	}
	
	public void excluir(Pedido pedido){
		
		daop.excluir(pedido);
	
	}

	public List<Pedido> listar() {
		
		return daop.listar();
	}

	public void alterar(Pedido pedido) {
		
		daop.editar(pedido);
	}
	
}
