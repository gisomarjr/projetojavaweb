package com.vendas.fachada;


import java.util.Collection;
import java.util.List;

import com.vendas.basicas.Departamento;
import com.vendas.basicas.Loja;
import com.vendas.negocio.NLoja;

public class FLoja {

	NLoja nl = new NLoja();
	
	public void cadastrar(Loja loja) throws Exception{
		
		nl.cadastrar(loja);
	}

	public Loja consultar(Integer id) {
		
		return nl.consultar(id);
		
	}

	public String validaCampo(Loja loja) {
		// TODO Auto-generated method stub
		return "";
	}

	public List<Loja> listar() {
		// TODO Auto-generated method stub
		return nl.listar();
	}
}
