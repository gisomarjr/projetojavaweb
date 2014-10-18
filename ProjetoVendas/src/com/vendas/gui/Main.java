package com.vendas.gui;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.basicas.Funcionario;
import com.vendas.basicas.Loja;
import com.vendas.basicas.Pedido;
import com.vendas.basicas.Pessoa;
import com.vendas.basicas.Produto;
import com.vendas.fachada.FCliente;
import com.vendas.fachada.FEndereco;
import com.vendas.fachada.FFornecedor;
import com.vendas.fachada.FFuncionario;
import com.vendas.fachada.FLoja;
import com.vendas.fachada.FPedido;
import com.vendas.fachada.FProduto;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		Collection<Endereco> catalogo_endereco = new ArrayList<Endereco>();
		Collection<Produto> lista_produtos = new ArrayList<Produto>();
		Collection<Pedido> lista_pedidos = new ArrayList<Pedido>();
	
		//Cadastrar Cliente
		Cliente c1 = new Cliente();
		c1.setCpf("174.477.122-98");
		c1.setEmail("c1@gmail.com");
		c1.setNome("Alterado 3 Cliente");
		c1.setTelefone("8288-6633");
		c1.setPedido(lista_pedidos);
		//Cadastrar Funcionario
		Funcionario func = new Funcionario();
		func.setCpf("878987987987");
		func.setEmail("meu email@mdfasd.com");
		func.setMatricula("1414");
		func.setNome("Nome do Funcionario");
		func.setTelefone("8748787878");
		
		
		//Cadastrar Endereï¿½o
		Endereco e1 = new Endereco();
		Endereco e2 = new Endereco();
		e1.setCep("88.554-874");
		e1.setCidade("Recife");
		e1.setEstado("PE");
		e1.setComplemento("Perto da minha casa");
		e1.setLogradouro("Rua da minha casa");
		e1.setNumero(90);
		
		
		e2.setCep("11.222-789");
		e2.setCidade("Gravata");
		e2.setEstado("PE");
		e2.setComplemento("Longe da minha casa");
		e2.setLogradouro("NÃ£o Ã© minha casa");
		e2.setNumero(85);
		
		 e1.setClientes(c1);
		 e2.setClientes(c1);
		 
		
		// e2.setFuncionario(func);
		
		 //func.setEndereco(e2);	
		 
		 
		catalogo_endereco.add(e1);
		catalogo_endereco.add(e2);
		
	    c1.setEndereco(catalogo_endereco);
		
		
	  //Cadastro de Produtos
	  		Produto p1 = new Produto();
	  		p1.setData_vencimento(null);
	  		p1.setDescricao("Computador Pessoal");
	  		p1.setNome("Computaador ACER");
	  		p1.setPreco_produto(987.00);
	  		
	  		Produto p2 = new Produto();
	  		p2.setDescricao("Notebook");
	  		p2.setNome("Notebook HP");
	  		p2.setPreco_produto(800.99);
	  		
	   //Cadastro de Fornecedor   
	  		Fornecedor f1 = new Fornecedor();
			f1.setCnpj("24.566.440/0001-79");
			f1.setNomeFantasia("FACEPE");
			f1.setRazaoSocial("Fundação de Amparo e Tecnologia");		
	  	//Produto - Fornecedor	
			p1.setFornecedor(f1);
			p2.setFornecedor(f1);
		//Cadatro de Pedido
			
			Pedido pedido = new Pedido();
			pedido.setCliente(c1);
			lista_produtos.add(p1);
			lista_produtos.add(p2);
			pedido.setProdutos(lista_produtos);
			lista_pedidos.add(pedido);
			
		
		FCliente fcliente = new FCliente();
		FFornecedor ffornecedor = new FFornecedor();
		FLoja floja = new FLoja();
		FEndereco fendereco = new FEndereco();
		FFuncionario ffuncionario = new FFuncionario();
		FProduto fproduto = new FProduto();
		FPedido fpedido = new FPedido();
		try {
			
			/**
			 * Cadastrar Cliente
			 */
			
			fcliente.cadastrar(c1);
			
			/**
			 * Cadastrar Funcionario
			 */
			
			
		//	ffuncionario.cadastrar(func);
			/**
			  * Cadastrar Endereï¿½o
			  */
			fendereco.cadastrar(e1);
			ffornecedor.cadastrar(f1);
			fproduto.cadastrar(p1);
			fproduto.cadastrar(p2);
			fpedido.cadastrar(pedido);
			
			
		/*	Cliente cliente_excluir = new Cliente();
			cliente_excluir.setId(1);
			fcliente.excluir(cliente_excluir);
			*/
			
			//Listando os clientes -- ok
		/*	for(Cliente pe : fcliente.listar()){
	            System.out.println(pe.getId());
	            System.out.println(pe.getNome());
	            System.out.println();
	        }
			//Consultando por Id -- ok
			System.out.println(fcliente.consultar(3).getEmail());
			
			//Alterar Cliente -- Inserindo 2 endereÃ§os
			//fcliente.alterar(c1);
			
			
			/**
			 * Consultar Cliente  -- ok	
			 */
			//Cliente cliConsulta = fcliente.consultar(1);
			//System.out.println(cliConsulta.getNome());
			
			/**
			 * Cadastrar Fornecedor
			 */
			//ffornecedor.cadastrar(f1);
			
			/**
			 * Cadastrar Loja
			 */
			//floja.cadastrar(l1);
			
			/**
			 * Cadastrar Produto
			 */
			//fproduto.cadastrar(p1);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
