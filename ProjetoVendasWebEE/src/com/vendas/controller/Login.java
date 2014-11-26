package com.vendas.controller;


import com.vendas.basicas.Cliente;
import com.vendas.basicas.Funcionario;
import com.vendas.basicas.Loja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.vendas.model.DAOCliente;
import com.vendas.model.DAOFuncionario;
import com.vendas.model.DAOLoja;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	HttpSession sessao = request.getSession(true);
    	
    	try{
	   	 String usuario = request.getParameter("usuario");
	   	 String perfil = request.getParameter("perfil");
	   	 String senha = request.getParameter("senha");
	   	
	   	 sessao.setAttribute("cpf", usuario);
	   	 sessao.setAttribute("perfil", perfil);
	   	 
	   	 PrintWriter out = response.getWriter();
	   
	   	 DAOCliente model_cliente = new DAOCliente();
	   	 DAOLoja model_loja = new DAOLoja();
	   	 DAOFuncionario model_funcionario = new DAOFuncionario();
	   	 
	   	 /**
	   	  * Verifica o tipo de perfil e redericiona
	   	  * 1 - Cliente
	   	  * 2 - Funcionario
	   	  * 3 - Loja
	   	  */
	   	switch (Integer.parseInt(perfil)) {
		case 1:
			int cont =0;
		 	for (Cliente cliente : model_cliente.realizarLogin(usuario, senha)) {
				String nome = cliente.getNome();
				String email = cliente.getEmail();
				Integer id = cliente.getId();
				
				sessao.setAttribute("id", id);
				sessao.setAttribute("usuario", nome);
				sessao.setAttribute("email", email);
				sessao.setAttribute("perfil", "Cliente");
				
				cont++;
				}
				if(cont >0){
				
					 
			   		request.setAttribute("e", "");
			   		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/interno/index.jsp");
			        requestDispatcher.forward(request, response);
					
				}else{
					
				 	request.setAttribute("e", "1");
			   		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			        requestDispatcher.forward(request, response);
					
				}
			break;
			
		case 2:
			cont = 0;
			
			for(Funcionario funcionario : model_funcionario.realizarLogin(usuario, senha)){
				sessao.setAttribute("id", funcionario.getId());
				sessao.setAttribute("usuario", funcionario.getNome());
				sessao.setAttribute("email", funcionario.getEmail());
				sessao.setAttribute("perfil", "Funcionario");
				cont++;
			}
			if(cont >0){
				 
		   		request.setAttribute("e", "");
		   		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/interno/indexFuncionario.jsp");
		        requestDispatcher.forward(request, response);
				
			}else{
				
			 	request.setAttribute("e", "1");
		   		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		        requestDispatcher.forward(request, response);
				
			}
			
			break;
			
			
		case 3:
			
			cont = 0;
		 	for (Loja loja : model_loja.realizarLogin(usuario, senha)) {
		 		sessao.setAttribute("id", loja.getId());
				sessao.setAttribute("usuario", loja.getNome());
				sessao.setAttribute("email", loja.getEmail());
				sessao.setAttribute("perfil", "Loja");
				sessao.setAttribute("logo", loja.getFoto());
				cont++;
			}
			if(cont >0){
			 
		   		request.setAttribute("e", "");
		   		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/interno/indexLoja.jsp");
		        requestDispatcher.forward(request, response);
				
			}else{
				
			 	request.setAttribute("e", "1");
		   		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		        requestDispatcher.forward(request, response);
				
			}
			
			break;
				
			
		default:
			request.setAttribute("e", "1");
	   		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
	        requestDispatcher.forward(request, response);
			break;
		}
	   	 
    	}catch(java.lang.NullPointerException erro){
    		request.setAttribute("e", "1");
	   		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
	        requestDispatcher.forward(request, response);
			
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
		
	}
	
		

}
