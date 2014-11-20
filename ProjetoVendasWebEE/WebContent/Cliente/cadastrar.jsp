<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JQuery -->
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>


	<!-- MASCARAS -->
	<script type="text/javascript" src="../mascara/jquery.maskedinput.js"></script>
	<script src="../mascara/mascaras.js" ></script>

	<!-- CEP -->
	<script src="../cep/script.js" ></script>	

<script type="text/javascript">
/**
 * Fecha a mensagem antes do tempo - usuário quando clica em fechar
 */
function closeMsg(){
	document.getElementById("modal_msg").style = "none";
}
/**
 * Em um determinado tempo a mensagem fecha automaticamente
 */
$(document).ready(function(){
	var myVar = setInterval(function () {myTimer()}, 5000);
	
	function myTimer() {
	    var d = new Date();
	    document.getElementById("modal_msg").style = "none";
	}
	
});
</script>

<title>Cadastrar Cliente</title>

</head>
<body">

	
 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle </span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="../index.jsp">Shopping Virtual</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li ><a href="../index.jsp">Home</a></li>
            <li><a href="../sobre.jsp">Sobre</a></li>
             <li><a href="../login.jsp">Iniciar Sessão</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

<div class="jumbotron">
  <div class="container">

    <h1>Otima escolha!</h1>
  <p>Obrigado por escolher o Shopping Virtual
  Preencha seus dados para efetivar o seu cadastro.</p>


  
<div class="panel panel-default">
  <div class="panel-heading">
    <h2 class="panel-title">Informe seus dados cadastrais para efetuar o seu cadastro.</h2>
  </div>
  	<div class="panel-body">
	
		<form class="form-horizontal" action="../ControllerCliente" method="post">
<fieldset>

<!-- Form Name -->
<legend>Cadastrar Cliente</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">Nome Completo</label>  
  <div class="col-md-6">
  <input id="nome" name="nome" type="text" placeholder="Seu Nome" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cpf">CPF</label>  
  <div class="col-md-4">
  <input id="cpf" name="cpf" type="text" placeholder="CPF" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Informe seu Email</label>  
  <div class="col-md-6">
  <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="telefone">Telefone / Celular</label>  
  <div class="col-md-4">
  <input id="telefone" name="telefone" type="text" placeholder="Contato" class="form-control input-md" required="">
    
  </div>
</div>


<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="senha">Senha de Acesso</label>
  <div class="col-md-4">
    <input id="senha" name="senha" type="password" placeholder="senha" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cep">CEP</label>  
  <div class="col-md-4">
  <input id="cep" name="cep" type="text" placeholder="CEP" class="form-control input-md" required="">
  <input type="button" class="btn btn-default" id="getEndereco" value="Procurar Endereço" name="procurar"> 
 
 <h5 id="loadingCep"></h5>
 
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="logradouro">Logradouro</label>  
  <div class="col-md-6">
  <input id="logradouro" name="logradouro" type="text" placeholder="Logradouro" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="logradouro">Bairro</label>  
  <div class="col-md-6">
  <input id="bairro" name="bairro" type="text" placeholder="Bairro" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="estado">Estado</label>  
  <div class="col-md-4">
  <input id="estado" name="estado" type="text" placeholder="Estado" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cidade">Cidade</label>  
  <div class="col-md-4">
  <input id="cidade" name="cidade" type="text" placeholder="Cidade" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="numero">Número</label>  
  <div class="col-md-2">
  <input id="numero" name="numero" type="text" placeholder="Nº" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="complemento">Complemento</label>  
  <div class="col-md-5">
  <input id="complemento" name="complemento" type="text" placeholder="Complemento" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="enviar"></label>
  <div class="col-md-4">
    <button id="enviar" name="enviar" class="btn btn-primary">Enviar</button>
     
     <% if(request.getAttribute("e") == "1"){  %>
    
			    <div id="modal_msg" class="modal fade bs-example-modal-sm in" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: block; padding-right: 17px;">
			    <div class="modal-backdrop fade in" style="height: 679px;"></div>
			    <div class="modal-dialog modal-sm">
			      <div class="modal-content">
			
			        <div class="modal-header">
			        <button type="button" onclick="closeMsg()" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			         
			          <h4 align="center" class="modal-title" id="mySmallModalLabel">Cliente Cadastrado com Sucesso!</h4>
			        </div>
			        <div class="modal-body">
			       <div align="center"> <img src="img/sucesso.png" width="50"></div>
			        </div>
			      </div><!-- /.modal-content -->
			    </div><!-- /.modal-dialog -->
			  </div>
        <% }%>
  </div>
</div>
	 <input type="hidden" value="cadastrar" name="acao">
</fieldset>


<!--  <input id="bt_mensagem" type="hidden" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm" />
-->
  




</form>
		
		
	
	</div>
</div>

</body>
</html>