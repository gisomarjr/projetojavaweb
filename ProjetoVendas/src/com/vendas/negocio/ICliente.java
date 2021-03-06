package com.vendas.negocio;

import java.util.ArrayList;




import java.util.List;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;

public interface ICliente {
	
	public void cadastrar(Cliente cliente) throws Exception ;
	public void editar(Cliente cliente);
	public void excluir(Cliente cliente);
	public Cliente consultarPorId(Integer id);
	public List<Cliente> listar();
	
}
