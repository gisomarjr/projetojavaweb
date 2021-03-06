package com.vendas.negocio;

import java.util.List;

import com.vendas.basicas.Fornecedor;
import com.vendas.dao.DAOFornecedor;



public class NFornecedor {

	DAOFornecedor daof = new DAOFornecedor();
	
	public void cadastrar(Fornecedor fornecedor) throws Exception{
		
		daof.cadastrar(fornecedor);
	}

	public Fornecedor consultar(Integer id) {
		
		return daof.consultarPorId(id);
	}
	
	public void excluir(int id){
		daof.removeById(id);
	}
	
	public String validaCampos(Fornecedor fornecedor){
		
		if(fornecedor.getRazaoSocial().equals("") || fornecedor.getRazaoSocial() == null){
			return "Atenção RAZÃO SOCIAL em branco";
		}
		if(fornecedor.getNomeFantasia().equals("") || fornecedor.getNomeFantasia() == null){
			return "Atenção NOME FANTASIA em branco";
		}
		if(fornecedor.getCnpj().equals("") || fornecedor.getCnpj() == null || fornecedor.getCnpj().equals("  .   .   /    -  ") ){
			return "Atenção CNPJ em branco";
		}
		
		
				
		return "";
	}
	
	public List<Fornecedor> listar() {
		return daof.listar();
	}

	public void atualizar(Fornecedor fornecedor) {
		daof.editar(fornecedor);
		
	}
	public Fornecedor consultarID(Integer id){
		return daof.consultarPorId(id);
	}

	public List<Fornecedor> consultarCNPJ(String cnpj) {
		return daof.consultarPorCNPJ(cnpj);
	}
}
