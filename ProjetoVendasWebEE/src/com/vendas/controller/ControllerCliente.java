package com.vendas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vendas.basicas.Cliente;
import com.vendas.basicas.Departamento;
import com.vendas.basicas.Endereco;
import com.vendas.model.DAOCliente;
import com.vendas.model.DAOEndereco;

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
	      PrintWriter out;
	      
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	out = response.getWriter();
    	
       	
    	if(request.getParameter("acao").equals("cadastrar")){
    		 
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
   	      collection_endereco.add(endereco);
   	     
   	      cliente.setEndereco(collection_endereco);
   	      endereco.setClientes(cliente);
   	      
   	      try {
   	    
   	    	  model_cliente.cadastrar(cliente);
   	    	  model_endereco.cadastrar(endereco);  
   	    	request.setAttribute("e", "1");
   	    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Cliente/cadastrar.jsp");
   	        requestDispatcher.forward(request, response);
   	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print(e);
			e.printStackTrace();
		}
   	  
    	}else{
    		out.print("Nenhuma a��o encontrada");
    		out.print(request.getParameter("acao"));
    		request.setAttribute("e", "");
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
