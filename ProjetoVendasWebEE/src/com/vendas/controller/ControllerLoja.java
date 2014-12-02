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
import java.util.ArrayList;
import java.util.Collection;
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;

import org.apache.tomcat.util.http.fileupload.FileItem;

import com.vendas.basicas.Departamento;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.basicas.Funcionario;
import com.vendas.basicas.Loja;
import com.vendas.basicas.Produto;
import com.vendas.model.DAOCliente;
import com.vendas.model.DAODepartamento;
import com.vendas.model.DAOEndereco;
import com.vendas.model.DAOFornecedor;
import com.vendas.model.DAOFuncionario;
import com.vendas.model.DAOLoja;
import com.vendas.model.DAOProduto;
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

   
     
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	HttpSession sessao = request.getSession(true);
    	PrintWriter out = response.getWriter();
    	
    	/**
    	 * CADASTRAR LOJA
    	 */
    	if(request.getParameter("acao").equals("cadastrar")){
    		DAOEndereco model_endereco = new DAOEndereco();
    		DAOLoja model_loja = new DAOLoja();
    		Endereco endereco = new Endereco();
    	    Loja loja = new Loja();
    		
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
				
				sessao.setAttribute("finalizado", "ok");
				response.sendRedirect("Loja/CadastrarLoja.jsp");
			
     	    } catch (Exception e) {
				// TODO Auto-generated catch block
				out.print(e);
			}
    	
     	/**
    	  * CADASTRAR DEPARTAMENTO    
    	  */
    	      
    	} else if(request.getParameter("acao").equals("cadastrarDepartamento")){ 
    		DAOCliente c = new DAOCliente();
    		Loja ld = new Loja();
    		Departamento dl = new Departamento();
    		Collection<Loja> lojasd = new ArrayList<Loja>();
    		lojasd.remove(ld);
    		DAODepartamento model_departamento = new DAODepartamento();
    	   	 
    		dl.setNome(request.getParameter("nome"));
    		ld.setId(Integer.parseInt(request.getParameter("idLoja")));
    		lojasd.add(ld);
    		dl.setLojas(lojasd);
    		
    		try {
				model_departamento.cadastrar(dl);
				
				sessao.setAttribute("finalizado", "ok");
				response.sendRedirect("Loja/CadastrarDepartamento.jsp");
		   	    
			} catch (Exception e) {
				out.print(e);
			}
    		/**
    		 * Cadastrar Funcionário
    		 */
    	} else if(request.getParameter("acao").equals("cadastrarFuncionario")){
    		 DAOFuncionario model_funcionario = new DAOFuncionario();
    		 DAOEndereco model_endereco = new DAOEndereco();
    		 Funcionario funcionario = new Funcionario();
    		 Endereco endereco = new Endereco();
    		 Departamento departamento = new Departamento();
    		 Collection<Loja> lojas = new ArrayList<Loja>();
    		 Loja loja = new Loja();
    		lojas.clear();
    		
    		funcionario.setNome(request.getParameter("nome"));
    		funcionario.setCpf(request.getParameter("cpf"));
    		funcionario.setMatricula(request.getParameter("matricula"));
    		funcionario.setEmail(request.getParameter("email"));
    		funcionario.setTelefone(request.getParameter("telefone"));
    	    departamento.setId(Integer.parseInt(request.getParameter("departamento")));
    		funcionario.setDepartamento(departamento);
    		funcionario.setSenha(request.getParameter("senha"));
    		loja.setId(Integer.parseInt(request.getParameter("idLoja")));
    		funcionario.setLoja(loja);
    		
    		endereco.setCep(request.getParameter("cep"));
     	    endereco.setLogradouro(request.getParameter("logradouro"));
     	    endereco.setBairro(request.getParameter("bairro")); 
     	    endereco.setEstado(request.getParameter("estado"));
     	    endereco.setCidade(request.getParameter("cidade"));
     	    endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
     	    endereco.setComplemento(request.getParameter("complemento"));
     	    endereco.setFuncionario(funcionario);
     	    
     	  
	   	    
    		try {
				model_funcionario.cadastrar(funcionario);
				model_endereco.cadastrar(endereco);
				
				sessao.setAttribute("finalizado", "ok");
				response.sendRedirect("Loja/CadastrarFuncionario.jsp");
			
    		} catch (Exception e) {
				out.print(e);
			}
    		
    	} 
    	/**
    	 * Cadastrar Produto
    	 * 
    	 */
    	 else if(request.getParameter("acao").equals("cadastrarProduto")){
     		DAOProduto model_produto = new DAOProduto();
     		Produto produto = new Produto();
     		Fornecedor fornecedor  = new Fornecedor();
     		Funcionario funcionario = new Funcionario();
     		Loja loja = new Loja();
     		Collection<Loja> lojas = new ArrayList<Loja>();
     		
     		
     		produto.setNome(request.getParameter("nome"));
     		produto.setDescricao(request.getParameter("descricao"));
     	    fornecedor.setId(Integer.parseInt(request.getParameter("fornecedor")));
     		produto.setPreco_produto(Double.parseDouble(request.getParameter("preco")));
     		produto.setFornecedor(fornecedor);
     		loja.setId(Integer.parseInt(request.getParameter("idLoja")));
     		lojas.add(loja);
    		funcionario.setLoja(loja);
     		produto.setLojas(lojas);
      	    
     		try {
 				model_produto.cadastrar(produto);
 				
 				sessao.setAttribute("finalizado", "ok");
 	  		    response.sendRedirect("Loja/CadastrarProduto.jsp");
 	  		    
 			} catch (Exception e) {
 				out.print(e);
 			}
     		
     	} 
    	
    	/**
    	 * CADASTRAR FORNECEDOR
    	 */
    	 else if(request.getParameter("acao").equals("cadastrarFornecedor")){
    		 
    		 Collection<Loja> lojas = new ArrayList<Loja>();
    		 Fornecedor fornecedor = new Fornecedor();
    		 Loja loja = new Loja();
    		 DAOFornecedor model_fornecedor = new DAOFornecedor();
      		 lojas.clear();
      		
      		fornecedor.setCnpj(request.getParameter("cnpj"));
      		fornecedor.setNomeFantasia(request.getParameter("nome_fantasia"));
      		fornecedor.setRazaoSocial(request.getParameter("nome"));
      		loja.setId(Integer.parseInt(request.getParameter("idLoja")));
      		lojas.add(loja);
      	    fornecedor.setLojas(lojas);
       	    
      	    
       	    
      		try {
  				model_fornecedor.cadastrar(fornecedor);
  				
  				sessao.setAttribute("finalizado", "ok");
  	 		    response.sendRedirect("Loja/CadastrarFornecedor.jsp");
  	 		    
  			} catch (Exception e) {
  				out.print(e);
  			}
      		
      	} else if(request.getParameter("acao").equals("carrinho")){
      		
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
