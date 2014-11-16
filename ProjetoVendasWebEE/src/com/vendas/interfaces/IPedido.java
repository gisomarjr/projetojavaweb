package com.vendas.interfaces;

import java.util.ArrayList;




import java.util.List;

import com.vendas.basicas.Endereco;
import com.vendas.basicas.Pedido;

public interface IPedido {
	
	public void cadastrar(Pedido pedido) throws Exception ;
	public void editar(Pedido pedido);
	public void excluir(Pedido pedido);
	public Pedido consultarPorId(Integer id);
	public List<Pedido> listar();
	
}
