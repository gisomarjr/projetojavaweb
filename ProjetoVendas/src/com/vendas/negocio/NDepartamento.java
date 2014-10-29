package com.vendas.negocio;

import java.util.List;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Departamento;
import com.vendas.basicas.Endereco;
import com.vendas.dao.DAOCliente;
import com.vendas.dao.DAODepartamento;

public class NDepartamento {

	DAODepartamento daod = new DAODepartamento();
	
	public void cadastrar(Departamento departamento) throws Exception{
		
		daod.cadastrar(departamento);
	}

	public Departamento consultar(Integer id) {
		
		return daod.consultarPorId(id);
	}

	public List<Departamento> listar() {
		
		return daod.listar();
	}
	
}
