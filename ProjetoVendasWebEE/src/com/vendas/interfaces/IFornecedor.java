package com.vendas.interfaces;

import java.util.ArrayList;





import java.util.List;

import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;

public interface IFornecedor {
	
	public void cadastrar(Fornecedor fornecedor) throws Exception ;
	public void editar(Fornecedor fornecedor);
	public void excluir(Fornecedor fornecedor);
	public Fornecedor consultarPorId(Integer id);
	public List<Fornecedor> listar();
	
}
