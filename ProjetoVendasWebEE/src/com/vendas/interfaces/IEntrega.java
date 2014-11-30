package com.vendas.interfaces;

import java.util.ArrayList;




import java.util.List;

import com.vendas.basicas.Endereco;
import com.vendas.basicas.Entrega;
import com.vendas.basicas.Pedido;

public interface IEntrega {
	
	public void cadastrar(Entrega entrega) throws Exception ;
	public void editar(Entrega entrega);
	public void excluir(Entrega entrega);
	public Entrega consultarPorId(Integer id);
	public List<Entrega> listar();
	
}
