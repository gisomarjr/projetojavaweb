package com.vendas.interfaces;

import java.util.ArrayList;




import java.util.List;

import com.vendas.basicas.Clientes;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Funcionario;

public interface IFuncionario {
	
	public void cadastrar(Funcionario funcionario) throws Exception ;
	public void editar(Funcionario funcionario);
	public void excluir(Funcionario funcionario);
	public Funcionario consultarPorId(Integer id);
	public List<Funcionario> listar();
	
}
