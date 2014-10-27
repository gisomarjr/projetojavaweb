package com.vendas.negocio;

import java.util.ArrayList;




import java.util.List;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Produto;

public interface IProduto {
	
	public void cadastrar(Produto produto) throws Exception ;
	public void editar(Produto produto);
	public void excluir(Produto produto);
	public Produto consultarPorId(Integer id);
	public List<Produto> listar();
	
}
