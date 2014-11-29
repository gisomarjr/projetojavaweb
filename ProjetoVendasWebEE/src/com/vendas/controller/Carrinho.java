package com.vendas.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vendas.basicas.Produto;

/**
 * Servlet implementation class Carrinho
 */
@WebServlet("/Carrinho")
public class Carrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
       HttpSession sessao = request.getSession(true);
		Writer outWriter = response.getWriter();
		String idLoja = request.getParameter("l");
		
		 Integer idProduto = Integer.parseInt(request.getParameter("p"));
		 ArrayList<Produto> lista_produtos = new ArrayList<Produto>();
		
		 
	     lista_produtos.addAll((ArrayList<Produto>) sessao.getAttribute("qtdCarrinho"));
		 Produto p = new Produto();
		 p.setId(idProduto);
		 lista_produtos.add(p);
		 
		/* for(Produto pro: lista_produtos){
			 	
			 	if(pro.getId() != idProduto){
			 		lista_produtos.remove(p);			 		
			 	}
		 }*/
		 
		 sessao.setAttribute("qtdCarrinho", lista_produtos);
		 
		 response.sendRedirect("Loja/index.jsp?l="+idLoja);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
