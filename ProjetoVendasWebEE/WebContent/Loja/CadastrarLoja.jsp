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

	
<title>Cadastrar Lojas</title>



</head>
<body>


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

     
  
  
  <form class="form-horizontal">
<fieldset>

<!--  
<div align="center">
	<img src="img/loja_cadastro.jpg" width="300" height="300" alt="" 
   	class="img-thumbnail img-responsive">
</div>
-->   	
   	
<!-- Form Name -->
<legend>Cadastrar Loja</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">Nome da Loja</label>  
  <div class="col-md-5">
  <input id="nome" name="nome" type="text" placeholder="Nome" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="razao_social">Razão Social da Loja</label>  
  <div class="col-md-5">
  <input id="razao_social" name="razao_social" type="text" placeholder="Razão Social" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cnpj">Informe o CNPJ</label>  
  <div class="col-md-4">
  <input id="cnpj" name="cnpj" type="text" placeholder="CNPJ" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Email">Email</label>  
  <div class="col-md-6">
  <input id="Email" name="Email" type="text" placeholder="Email" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="telefone">Telefone Comercial</label>  
  <div class="col-md-4">
  <input id="telefone" name="telefone" type="text" placeholder="Telefone Comercial" class="form-control input-md" required="">
    
  </div>
</div>

<!-- File Button --> 
<div class="form-group">
  <label class="col-md-4 control-label" for="logo_foto">Logo Marca Loja</label>
  <div class="col-md-4">
    <input id="logo_foto" name="logo_foto" class="input-file" type="file">
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
  </div>
</div>

</fieldset>
</form>

  
  
	</div>
	</div>
</body>


</body>
</html>