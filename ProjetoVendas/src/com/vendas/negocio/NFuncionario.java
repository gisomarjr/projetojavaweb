package com.vendas.negocio;

import java.util.List;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.basicas.Funcionario;
import com.vendas.dao.DAOEndereco;
import com.vendas.dao.DAOFornecedor;
import com.vendas.dao.DAOFuncionario;



public class NFuncionario {

	DAOFuncionario daof = new DAOFuncionario();
	
	public void cadastrar(Funcionario funcionario) throws Exception{
		
		daof.cadastrar(funcionario);
	}

	public Funcionario consultar(Integer id) {
		
		return daof.consultarPorId(id);
	}
	
	public List<Funcionario> realizarLogin(String usuario,String senha) {
		
		return daof.realizarLogin(usuario, senha);
	}
	
}
