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
import com.vendas.basicas.Loja;
import com.vendas.basicas.Pessoa;
import com.vendas.basicas.Produto;
import com.vendas.fachada.FCliente;
import com.vendas.fachada.FEndereco;
import com.vendas.fachada.FFornecedor;
import com.vendas.fachada.FLoja;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		Collection<Endereco> catalogo_endereco = new ArrayList<Endereco>();
		Collection<Produto> lista_produtos = new ArrayList<Produto>();
	
		//Cadastrar Cliente
		Cliente c1 = new Cliente();
		c1.setCpf("174.477.122-98");
		c1.setEmail("c1@gmail.com");
		c1.setNome("Alterado 3 Cliente");
		c1.setTelefone("8288-6633");
		
		//Cadastrar Endere�o
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
		e2.setLogradouro("Não é minha casa");
		e2.setNumero(85);
		
		 e1.setClientes(c1);
		 e2.setClientes(c1);
			
		catalogo_endereco.add(e1);
		catalogo_endereco.add(e2);
		
	    c1.setEndereco(catalogo_endereco);
		
		
		//Cadastro de Fornecedor
		
		Fornecedor f1 = new Fornecedor();
		f1.setCnpj("24.566.440/0001-79");
		f1.setNomeFantasia("FACEPE");
		f1.setRazaoSocial("Funda��o de ci�ncia e Tecnologia");
		
		//Cadastro de Produtos
		Produto p1 = new Produto();
		p1.setFornecedor(f1);
		p1.setData_vencimento(null);
		p1.setDescricao("Computador Pessoal");
		p1.setNome("Computaador ACER");
		p1.setPreco_produto(987.00);
		
		f1.setProdutos(lista_produtos);
		
		//Cadastrar Loja
		Loja l1 = new Loja();
		l1.setCnpj("89989898989");
		l1.setEmail("loja@gmail.com");
		
		l1.setNome("Loja");
		l1.setRazao_social("lojas minha");
		l1.setTelefone_comercial("818777-9855");
		
		//Erro no endere�o -- Ele n�o leva o id_endereco
		l1.setEndereco(e1);
		
		FCliente fcliente = new FCliente();
		FFornecedor ffornecedor = new FFornecedor();
		FLoja floja = new FLoja();
		FEndereco fendereco = new FEndereco();
		try {
			
			/**
			 * Cadastrar Cliente
			 */
			
			fcliente.cadastrar(c1);
			
			/**
			   * Cadastrar Endere�o
			  */
			
			fendereco.cadastrar(e1);
			
			Cliente cliente_excluir = new Cliente();
			/*cliente_excluir.setId(1);
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
			
			//Alterar Cliente -- Inserindo 2 endereços
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
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
