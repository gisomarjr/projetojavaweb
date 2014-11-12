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

	public List<Funcionario> listar() {
		// TODO Auto-generated method stub
		return daof.listar();
	}

	public Funcionario consultarID(int id) {
		
		return daof.consultarPorId(id);
	}

	public List<Funcionario> consultarCPF(String cpf) {
		
		return daof.consultarPorCPF(cpf);
	}

	public void excluir(int id) {
		daof.removeById(id);
		
	}

	public void editar(Funcionario funcionario) {
		daof.editar(funcionario);
	}
	
}
