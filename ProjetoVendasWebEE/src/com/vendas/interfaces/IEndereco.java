package com.vendas.interfaces;

import java.util.ArrayList;




import java.util.List;

import com.vendas.basicas.Endereco;

public interface IEndereco {
	
	public void cadastrar(Endereco endereco) throws Exception ;
	public void editar(Endereco endereco);
	public void excluir(Endereco endereco);
	public Endereco consultarPorId(Integer id);
	public List<Endereco> listar();
	
}
