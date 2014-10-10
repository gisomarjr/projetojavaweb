package com.vendas.fachada;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Departamento;
import com.vendas.basicas.Endereco;
import com.vendas.negocio.NCliente;
import com.vendas.negocio.NDepartamento;

public class FDepartamento {

	NDepartamento nd = new NDepartamento();
	
	public void cadastrar(Departamento departamento) throws Exception{
		
		nd.cadastrar(departamento);
	}

	public Departamento departamento(Integer id) {
		
		return nd.consultar(id);
		
	}
}
