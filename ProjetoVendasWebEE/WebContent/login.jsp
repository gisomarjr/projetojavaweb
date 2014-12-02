<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
<!-- JQuery -->
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
   
   	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
   
       <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>
   
   	<!-- MASCARAS -->
	<script type="text/javascript" src="mascara/jquery.maskedinput.js"></script>
	<script src="mascara/mascaras.js" ></script>
      
   <script type="text/javascript">
   		
   $(document).ready(function() {
	   //Padrão
	   $("#usuario").mask("999.999.999-99");
	   
	   $('#perfil').change(function() {
	   if ($(this).val() != 3) {
	    	$("#usuario").mask("999.999.999-99");
	   }else{
			$("#usuario").mask("99.999.999/9999-99");
	   }
  });
});
   	
   </script>
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Realizar Login</title>
</head>
<body>
		
<!-- Menu -->
 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle </span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">Shopping Virtual</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li ><a href="index.jsp">Home</a></li>
            <li ><a href="sobre.jsp">Sobre</a></li>
             <li  class="active"><a href="login.jsp">Iniciar Sessão</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<!-- Fim Menu -->		
	
		<!-- Inicio Container -->
		<br><br>
    <div class="container">

      <form class="form-signin" role="form" method="post" action="Login">
        <h2 align="center" class="form-signin-heading"> Realizar Login </h2>
        <input id="usuario" name="usuario" class="form-control" placeholder="Informe seu CPF/CNPJ" required autofocus>
        <input type="password" name="senha" class="form-control" placeholder="Informe sua Senha" required>
           
			    <select id="perfil" name="perfil" class="form-control input-lg">
			      <option value="1">Cliente</option>
			      <option value="2">Funcionario</option>
			      <option value="3">Loja</option>
			    </select>
			
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Continuar conectado
          </label>
        </div>
        
         <% 
         	HttpSession sessao = request.getSession(true);
     try{
		  if(sessao.getAttribute("finalizado").equals("ok")){  %>
        		<div align="center"><label>Atenção Login ou Senha Inválida!</label></div>
       <% } sessao.removeAttribute("finalizado");
     }catch(Exception e){
    	 
    	 
     }
        %>
       
     
        <button class="btn btn-lg btn-primary btn-block" type="submit">Realizar Login</button>
         <button class="btn btn-lg  btn-warning btn-block" type="submit">Esqueceu a Senha</button>
 
         
            <!-- android button -->
  				<a class="btn btn-lg btn-success btn-block" href="#">
  				<img width="50px" class="pull-left" src="http://www.userlogos.org/files/logos/jumpordie/google_play_04.png">
  				<div class="btn-text"><small>Em Desenvolvimento</small><br><strong>Google Play</strong></div></a>
        
     
      </form>
		
		
    

    </div> <!-- /container -->



</body>
</html>