package com.vendas.negocio;

import java.util.ArrayList;





import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;

public interface IFornecedor {
	
	public void cadastrar(Fornecedor fornecedor) throws Exception ;
	public void editar(Fornecedor fornecedor);
	public void excluir(Fornecedor fornecedor);
	public Fornecedor consultarPorId(Integer id);
	public ArrayList<Fornecedor> listar();
	
}
