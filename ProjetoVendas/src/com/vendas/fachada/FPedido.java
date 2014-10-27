package com.vendas.fachada;

import java.util.List;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Pedido;
import com.vendas.negocio.NCliente;
import com.vendas.negocio.NPedido;

public class FPedido {

	NPedido np = new NPedido();
	
	public void cadastrar(Pedido pedido) throws Exception{
		
		np.cadastrar(pedido);
	}

	public Pedido consultar(Integer id) {
		
		return np.consultar(id);
		
	}
	
	public void excluir(Pedido pedido){
		np.excluir(pedido);
	}
	
	public List<Pedido> listar() {
	
		return np.listar();
	}
	
	public void alterar(Pedido pedido){
		
		np.alterar(pedido);		
	}
	
}
