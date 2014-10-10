package com.vendas.negocio;

import java.util.ArrayList;






import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.dao.IDAOGenerico;

public interface IClienteGeneric extends IDAOGenerico<Cliente, Long> {
	
	/**
	 * http://blog.camilolopes.com.br/genericdao/
	 * @param cliente
	 * @throws Exception
	 */
	
	public void cadastrar(Cliente cliente) throws Exception ;
	
}
