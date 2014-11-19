package com.vendas.controller;


import com.vendas.basicas.Cliente;

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
	   
	   	 DAOCliente model = new DAOCliente();
	   	 
	   	 /**
	   	  * Verifica o tipo de perfil e redericiona
	   	  * 1 - Cliente
	   	  * 2 - Fornecedor
	   	  * 3 - Loja
	   	  */
	   	switch (Integer.parseInt(perfil)) {
		case 1:
			int cont =0;
		 	for (Cliente cliente : model.realizarLogin(usuario, senha)) {
				String nome = cliente.getNome();
				String email = cliente.getEmail();
				Integer id = cliente.getId();
				
				sessao.setAttribute("id", id);
				sessao.setAttribute("usuario", nome);
				sessao.setAttribute("email", email);
				
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
