package com.vendas.fachada;

import java.util.Collection;
import java.util.List;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Funcionario;
import com.vendas.negocio.NCliente;
import com.vendas.negocio.NEndereco;
import com.vendas.negocio.NFuncionario;

public class FFuncionario {

	NFuncionario nf = new NFuncionario();
	
	public void cadastrar(Funcionario funcionario) throws Exception{
		
		nf.cadastrar(funcionario);
	}

	public Funcionario consultar(Integer id) {
		
		return nf.consultar(id);
		
	}
	public List<Funcionario> realizarLogin(String usuario,String senha) {
		
		return nf.realizarLogin(usuario, senha);
	}

	public String validaCampo(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return "";
	}

	public List<Funcionario> listar() {
		// TODO Auto-generated method stub
		return nf.listar();
	}

	public List<Funcionario> consultarCPF(String cpf) {
		
		return nf.consultarCPF(cpf);
	}

	public Funcionario consultarID(int id) {
		
		return nf.consultarID(id);
	}

	public void editar(Funcionario funcionario) {
		
		nf.editar(funcionario);
	}
}
