package com.vendas.negocio;

import java.util.ArrayList;





import com.vendas.basicas.Cliente;
import com.vendas.basicas.Departamento;
import com.vendas.basicas.Endereco;

public interface IDepartamento {
	
	public void cadastrar(Departamento departamento) throws Exception ;
	public void editar(Departamento departamento);
	public void excluir(Departamento departamento);
	public Departamento consultarPorId(Integer id);
	public ArrayList<Departamento> listar();
	
}
