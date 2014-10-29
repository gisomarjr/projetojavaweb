package com.vendas.fachada;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.negocio.NCliente;
import com.vendas.negocio.NEndereco;

public class FEndereco {

	NEndereco ne = new NEndereco();
	
	public void cadastrar(Endereco endereco) throws Exception{
		
		ne.cadastrar(endereco);
	}

	public Endereco consultar(Integer id) {
		
		return ne.consultar(id);
		
	}

	public void editar(Endereco endereco) {
		
		ne.editar(endereco);
	}
	
}
