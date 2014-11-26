<%@page import="com.vendas.model.DAOFuncionario"%>
<%@page import="com.vendas.model.DAOCliente"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="com.vendas.basicas.Loja"%>
<%@page import="com.vendas.model.DAOLoja"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	 <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/cover/cover.css" rel="stylesheet">

    
    <script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>

   	<script src="js/bootstrap.js"></script>

<title>Shopping Virtual</title>
</head>
<body>

	 <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Shopping Virtual</h3>
              <ul class="nav masthead-nav">
                <li class="active"><a href="#">Pagina Inicial</a></li>
                <li><a href="sobre.jsp">Sobre</a></li>
                <li><a href="login.jsp">Iniciar Sessão</a></li>
              </ul>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Empresas Participantes</h1>
            <p class="lead"></p>
            <p class="lead">
              
            </p>
            
            
          </div>
		
		<%
		//Iniciando Conexão
		DAOCliente model_cliente = new DAOCliente();
	   	 DAOLoja model_loja = new DAOLoja();
	   	 DAOFuncionario model_funcionario = new DAOFuncionario();
	   	 
		Loja loja = new Loja();
		Collection<Loja> lista_lojas = new ArrayList<Loja>();
		
		
		lista_lojas = model_loja.listar();
		int i = 0;
		for(Loja a : lista_lojas){
			i++;
			a.getNome();
			a.getFoto();
			 byte[] foto = loja.getFoto();
			try{
	            FileOutputStream fos = new FileOutputStream("/home/gisomar/git/projetojavaweb/ProjetoVendasWebEE/WebContent/Loja/logo/logo"+a.getId()+".gif"); 
	            fos.write(foto);
	            fos.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		 %>
			
			<a href="#<%=a.getId()%>"><img class="img-circle" src="Loja/logo/logo<%=a.getId()%>.gif" alt="<%=a.getNome()%>" style="width: 140px; height: 140px;"> </a>
		 <%
		}
		if(i <= 0){
		 %><br><br><h1 class="cover-heading">Nenhuma Empressa Cadastrada!!! :(</h1><%
		}%>
		
		
		<br clear="all"><br clear="all"><br clear="all">
		
		<a href="Loja/CadastrarLoja.jsp" class="btn btn-lg btn-default">Cadastre sua Loja Aqui</a>
		<a href="Cliente/cadastrar.jsp" class="btn btn-lg btn-default">Cliente se Cadastre Aqui</a>

          <div class="mastfoot">
            <div class="inner">
              <p>Projeto Faculdade Unibratec</a>.</p>
              
              
              
            </div>
            
          </div>

        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
  </body>


</body>
</html>