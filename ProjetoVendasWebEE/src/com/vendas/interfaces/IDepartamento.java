package com.vendas.interfaces;

import java.util.ArrayList;





import java.util.List;

import com.vendas.basicas.Clientes;
import com.vendas.basicas.Departamento;
import com.vendas.basicas.Endereco;

public interface IDepartamento {
	
	public void cadastrar(Departamento departamento) throws Exception ;
	public void editar(Departamento departamento);
	public void excluir(Departamento departamento);
	public Departamento consultarPorId(Integer id);
	public List<Departamento> listar();
	
}
