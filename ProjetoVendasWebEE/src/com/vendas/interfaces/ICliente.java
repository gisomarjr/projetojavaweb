package com.vendas.interfaces;

import java.util.ArrayList;




import java.util.List;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Clientes;
import com.vendas.basicas.Endereco;

public interface ICliente {
	
	public void cadastrar(Cliente cliente) throws Exception ;
	public void editar(Clientes clientes);
	public void excluir(Clientes clientes);
	public Clientes consultarPorId(Integer id);
	public List<Clientes> listar();
	
	
}
