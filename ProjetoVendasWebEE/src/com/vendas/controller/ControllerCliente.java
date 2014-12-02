package com.vendas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Departamento;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Entrega;
import com.vendas.basicas.Pedido;
import com.vendas.basicas.Produto;
import com.vendas.model.DAOCliente;
import com.vendas.model.DAOEndereco;
import com.vendas.model.DAOEntrega;
import com.vendas.model.DAOPedido;

/**
 * Servlet implementation class ControllerCliente
 */
@WebServlet("/ControllerCliente")
public class ControllerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCliente() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    	  Cliente cliente = new Cliente();
    	  Endereco endereco = new Endereco();
	      DAOCliente model_cliente = new DAOCliente();
	      DAOEndereco model_endereco = new DAOEndereco();
	      Collection<Endereco> collection_endereco = null;
	      Collection<Cliente> collection_cliente = null;
	      PrintWriter out;
	      
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	HttpSession sessao = request.getSession(true);
    	out = response.getWriter();
    	
       	/**
       	 * CADASTRAR CLIENTE
       	 */
    	if(request.getParameter("acao").equals("cadastrar")){
    		DAOCliente model_cliente = new DAOCliente();
  	        DAOEndereco model_endereco = new DAOEndereco();
	  	      Cliente cliente = new Cliente();
	    	  Endereco endereco = new Endereco();
    	  //Usu�rio
    	  cliente.setNome(request.getParameter("nome"));
    	  cliente.setCpf(request.getParameter("cpf"));
    	  cliente.setEmail(request.getParameter("email"));
    	  cliente.setTelefone(request.getParameter("telefone"));
    	  cliente.setSenha(request.getParameter("senha"));
   	      //Endereco
   	      endereco.setCep(request.getParameter("cep"));
   	      endereco.setLogradouro(request.getParameter("logradouro"));
   	      endereco.setBairro(request.getParameter("bairro")); 
   	      endereco.setEstado(request.getParameter("estado"));
   	      endereco.setCidade(request.getParameter("cidade"));
   	      endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
   	      endereco.setComplemento(request.getParameter("complemento"));
   	      
   	      collection_endereco = new ArrayList<Endereco>();
   	      collection_cliente = new ArrayList<Cliente>();
   	      collection_endereco.add(endereco);
   	     
   	     
   	      collection_cliente.add(cliente);
   	     
   	      endereco.setClientes(collection_cliente);
   	      
   	      try {
   	    
   	    	  model_cliente.cadastrar(cliente);
   	    	  model_endereco.cadastrar(endereco);  
   	    	  
   	    	sessao.setAttribute("finalizado", "ok");
			response.sendRedirect("Cliente/cadastrar.jsp");
   	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print(e);
			e.printStackTrace();
		}
   	  
    	}
    	
    	/**
    	 * PERFIL USUÁRIO
    	 * 
    	 */
    	else if(request.getParameter("acao").equals("perfil")){
    		
    		response.sendRedirect("Cliente/perfil.jsp");
    	}
    	/**
    	 * Cliente Finaliza Pedido
    	 */
    	else if(request.getParameter("acao").equals("finalizarPedido")){
    		 
    	try {
    		ArrayList<Produto> lista_produtos_s = new ArrayList<Produto>();
    	    lista_produtos_s.addAll((ArrayList<Produto>) sessao.getAttribute("qtdCarrinho"));
    		Collection<Cliente> lista_cliente = new ArrayList<Cliente>();
    		Collection<Endereco> lista_endereco = new ArrayList<Endereco>();
    	    Entrega entrega = new Entrega();
    		Endereco endereco = new Endereco();
    		Pedido pedido = new Pedido();
    		Cliente cliente = new Cliente();
    		DAOCliente model_cliente = new DAOCliente();
    		
    		DAOEntrega model_entrega = new DAOEntrega();
    		DAOPedido model_pedido = new DAOPedido();
    		DAOEndereco model_edereco = new DAOEndereco();
    		
    		endereco.setId(Integer.parseInt(request.getParameter("idEndereco")));
    		endereco.setBairro(request.getParameter("bairro"));
    		endereco.setCep(request.getParameter("cep"));
    		endereco.setCidade(request.getParameter("cidade"));
    		endereco.setComplemento(request.getParameter("complemento"));
    		endereco.setEstado(request.getParameter("estado"));
    		endereco.setLogradouro(request.getParameter("logradouro"));
    		endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
    		
    		
    		pedido.setProdutos(lista_produtos_s);
    		
    		//cliente.setId(Integer.parseInt(sessao.getAttribute("id").toString()));
    		cliente = model_cliente.consultarPorId(Integer.parseInt(sessao.getAttribute("id").toString()));
    		pedido.setCliente(cliente);
    		lista_cliente.add(cliente);
    		
    		endereco.setClientes(lista_cliente);
    	    entrega.setSituacao("Pedido Realizado");
    	    
    	    Date data = new Date();
    	    pedido.setData_pedido(data);
    	    
    	    entrega.setEndereco(endereco);
    	    lista_endereco.add(endereco);
    	    cliente.setEndereco(lista_endereco);
    		pedido.setEntrega(entrega);
    		
    		
    		
    			model_entrega.cadastrar(entrega);
    			model_pedido.cadastrar(pedido);
    			model_cliente.editar(cliente);
    			model_edereco.editar(endereco);
    			
				
				sessao.setAttribute("finalizado", "ok");
				sessao.removeAttribute("qtdCarrinho");
				response.sendRedirect("/ProjetoVendasWebEE/interno/");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
   		
   	}
    	else {
    		out.print("Nenhuma Ação");
    	}
    	
    	
    }	
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		out = response.getWriter();
		out.print("deu post");
	}

}
