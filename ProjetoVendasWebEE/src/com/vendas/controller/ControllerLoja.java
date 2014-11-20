package com.vendas.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vendas.basicas.Endereco;
import com.vendas.basicas.Loja;
import com.vendas.model.DAOEndereco;
import com.vendas.model.DAOLoja;

/**
 * Servlet implementation class ControllerLoja
 */
@WebServlet("/ControllerLoja")
public class ControllerLoja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLoja() {
        super();
        // TODO Auto-generated constructor stub
    }

    	Loja loja = new Loja();
    	Endereco endereco = new Endereco();
    	DAOEndereco model_endereco = new DAOEndereco();
    	DAOLoja model_loja = new DAOLoja();
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	/**
    	 * CADASTRAR LOJA
    	 */
    	if(request.getParameter("acao").equals("cadastrar")){
    		
    		loja.setCnpj(request.getParameter("cnpj"));
    		loja.setEmail(request.getParameter("Email"));
    		loja.setCnpj(request.getParameter("nome"));
    		loja.setRazao_social(request.getParameter("razao_social"));
    		loja.setTelefone_comercial(request.getParameter("telefone"));
    		loja.setFoto(request.getParameter("logo_foto"));
    		
    		String caminhoSalvar = "/home/gisomar/git/projetojavaweb/ProjetoVendasWebEE/WebContent/Loja/logo";  
            File file = new File(caminhoSalvar);  
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));  
            bos.write(request.getParameter("logo_foto").getBytes());  
            bos.close();  
    		
    		endereco.setCep(request.getParameter("cep"));
     	    endereco.setLogradouro(request.getParameter("logradouro"));
     	    endereco.setBairro(request.getParameter("bairro")); 
     	    endereco.setEstado(request.getParameter("estado"));
     	    endereco.setCidade(request.getParameter("cidade"));
     	    endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
     	    endereco.setComplemento(request.getParameter("complemento"));
     	    endereco.setLoja(loja);
     	    
     	    try {
				model_loja.cadastrar(loja);
				model_endereco.cadastrar(endereco);
				 request.setAttribute("e", "1");
		   	      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Loja/CadastrarLoja.jsp");
		   	      requestDispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	}

}
