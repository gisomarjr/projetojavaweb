package com.vendas.fachada;

import java.util.List;

import com.vendas.basicas.Fornecedor;
import com.vendas.negocio.NFornecedor;



public class FFornecedor {

	NFornecedor nf = new NFornecedor();
	
	public void cadastrar(Fornecedor fornecedor) throws Exception{
		
		
		   nf.cadastrar(fornecedor);
		
	}
	
	public void excluir(int id){
		nf.excluir(id);
	}

	public Fornecedor consultar(Integer id) {
		
		return nf.consultar(id);
		
	}
	
	public String validaCampo(Fornecedor fornecedor){
		
		return nf.validaCampos(fornecedor);
	}
	
	public List<Fornecedor> listar() {
		return nf.listar();
	}

	public void atualizar(Fornecedor fornecedor) {
		nf.atualizar(fornecedor);
		
	}
	public Fornecedor consultarID(Integer id){
		return nf.consultarID(id);
	}
	
	public List<Fornecedor> consultarCNPJ(String cnpj){
		return nf.consultarCNPJ(cnpj);
	}
}
