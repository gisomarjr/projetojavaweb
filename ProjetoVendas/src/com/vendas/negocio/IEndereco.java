package com.vendas.negocio;

import java.util.ArrayList;




import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;

public interface IEndereco {
	
	public void cadastrar(Endereco endereco) throws Exception ;
	public void editar(Endereco endereco);
	public void excluir(Endereco endereco);
	public Endereco consultarPorId(Integer id);
	public ArrayList<Endereco> listar();
	
}
