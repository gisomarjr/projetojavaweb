package com.vendas.fachada;


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
}
