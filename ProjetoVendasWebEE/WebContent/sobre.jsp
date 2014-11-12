<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
       <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>
   
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sobre - Contato</title>
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
          <a class="navbar-brand" href="index.jsp">Shopping Virtual</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li ><a href="index.jsp">Home</a></li>
            <li class="active" ><a href="sobre.jsp">Sobre</a></li>
             <li><a href="login.jsp">Iniciar Sessão</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>





		<div class="jumbotron jumbotron-sm">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1">
                   Entre em Contato Conosco <br><small>Sinta-se livre para contactar-nos</small></h1>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="well well-sm">
                <form>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Seu Nome:</label>
                            <input type="text" class="form-control" id="name" placeholder="Nome" required="required" />
                        </div>
                        <div class="form-group">
                            <label for="email">
                                Endereço de Email</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="email" class="form-control" id="email" placeholder="Email" required="required" /></div>
                        </div>
                        <div class="form-group">
                            <label for="subject">
                                Assunto:</label>
                            <select id="subject" name="subject" class="form-control" required="required">
                                <option value="na" selected="">Selecione...</option>
                                <option value="service">Geral Atendimento ao Cliente</option>
                                <option value="suggestions">Sugestões</option>
                                <option value="product">Suporte ao Produto</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Mensagem</label>
                            <textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required"
                                placeholder="Digite aqui sua Mensagem"></textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary pull-right" id="btnContactUs">
                            Enviar Mensagem</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <div class="col-md-4">
            <form>
            <legend><span class="glyphicon glyphicon-globe"></span> Nosso Escritório</legend>
            <address>
                <strong>Endereço</strong><br>
                ...<br>
               ....<br>
                <abbr title="Phone">
                    ..:</abbr>
                (81) ...
            </address>
            <address>
                <strong>Shooping Virtual - Lojas</strong><br>
                <a href="mailto:#">loja@shooping.com</a>
            </address>
            </form>
        </div>
    </div>
</div>
		
    

</body>
</html>