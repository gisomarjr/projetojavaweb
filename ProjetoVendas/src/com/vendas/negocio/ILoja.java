package com.vendas.negocio;

import java.util.ArrayList;





import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Loja;

public interface ILoja {
	
	public void cadastrar(Loja loja) throws Exception;
	public void editar(Loja loja);
	public void excluir(Loja loja);
	public Loja consultarPorId(Integer id);
	public ArrayList<Loja> listar();
	
}
