package com.vendas.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.vendas.basicas.Endereco;
import com.vendas.basicas.Loja;
import com.vendas.model.DAOEndereco;
import com.vendas.model.DAOLoja;
import com.vendas.util.Upload;

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
    	
    	PrintWriter out = response.getWriter();
    	
    	/**
    	 * CADASTRAR LOJA
    	 */
    	if(request.getParameter("acao").equals("cadastrar")){
    		
    		loja.setCnpj(request.getParameter("cnpj"));
    		loja.setEmail(request.getParameter("Email"));
    		loja.setNome(request.getParameter("nome"));
    		loja.setRazao_social(request.getParameter("razao_social"));
    		loja.setTelefone_comercial(request.getParameter("telefone"));
    		loja.setSenha(request.getParameter("senha"));
    		//loja.setFoto(request.getParameter("logo_foto"));
    		
    		/**
    		 * UPLOAD DE FOTO
    		 */
    		
    	   
    		//save image into database
    		
            try {
            	
             File file = new File("/home/gisomar/Imagens/loja.gif");
            
            
             byte[] bFile = new byte[(int) file.length()];
    	     FileInputStream fileInputStream = new FileInputStream(file);
    	     
             
    	     //convert file into array of bytes
    	     fileInputStream.read(bFile);
    	     fileInputStream.close();
    	     loja.setFoto(bFile);
            } catch (Exception e) {
    	    out.print(e);
            }
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
				out.print(e);
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
