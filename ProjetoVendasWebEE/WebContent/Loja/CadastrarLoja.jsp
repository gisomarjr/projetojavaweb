<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Lojas</title>

	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<script src="../js/bootstrap.js"></script>
</head>
<body>

<div class="jumbotron">
  <div class="container">

    <h1>Ótima escolha!</h1>
  <p>Obrigado por escolher o Shopping Virtual
  Preencha seus dados para efetivar o seu cadastro.</p>


  
<div class="panel panel-default">
  <div class="panel-heading">
    <h2 class="panel-title">Cadastre sua loja</h2>
  </div>
  <div class="panel-body">

  <!--   <img src="img/loja_cadastro.jpg" width="300" height="300" alt="Fuzzy Cardigan" 
   class="img-thumbnail img-responsive">-->
  
  
  
  <form role="form">
  
  <div class="form-group">
  
    <label for="exampleInputEmail1">Nome da Loja</label>
    <input type="text" class="form-control" id="" placeholder="Informe o Nome da Loja">
  </div>
   <div class="form-group">
      <label for="exampleInputEmail1">Razão Social</label>
    <input type="text" class="form-control" id="" placeholder="Informe a Razão social aqui">
    
  </div>
   
   <div class="form-group">
      <label for="exampleInputEmail1">CNPJ</label>
    <input type="text" class="form-control" id="" placeholder="CNPJ">
    
  </div>
  
  <div class="form-group">
      <label for="exampleInputEmail1">Telefone Comercial</label>
    <input type="text" class="form-control" id="" placeholder="Telefone">
    
  </div>
  
  <div class="form-group">
  
    <label for="exampleInputEmail1">Informe seu Email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Informe sua Senha</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">Enviar Foto da Loja - LOGO</label>
    <input type="file" id="exampleInputFile">
    <p class="help-block">Formato aceitos: *jpg e *jpeg </p>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
  
  
<!-- Small modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      ...
    </div>
  </div>
</div>  
  

</form>
  
  
	</div>
	</div>
</body>


</body>
</html>