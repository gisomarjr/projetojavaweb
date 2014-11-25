<%@page import="java.io.FileOutputStream"%>
<%@page import="com.vendas.basicas.Loja"%>
<%@page import="com.vendas.model.DAOLoja"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Área Interna</title>

	
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

<!-- Menu Interno -->
<style type="text/css">
/* Special class on .container surrounding .navbar, used for positioning it into place. */
.navbar-wrapper {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  z-index: 20;
  margin-top: 20px;
}

/* Flip around the padding for proper display in narrow viewports */
.navbar-wrapper .container {
  padding-left: 0;
  padding-right: 0;
}
.navbar-wrapper .navbar {
  padding-left: 15px;
  padding-right: 15px;
}

.navbar-content
{
    width:320px;
    padding: 15px;
    padding-bottom:0px;
}
.navbar-content:before, .navbar-content:after
{
    display: table;
    content: "";
    line-height: 0;
}
.navbar-nav.navbar-right:last-child {
margin-right: 15px !important;
}
.navbar-footer 
{
    background-color:#DDD;
}
.navbar-footer-content { padding:15px 15px 15px 15px; }
.dropdown-menu {
padding: 0px;
overflow: hidden;
}
</style>


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

</head>
<body>
	
	<!-- Inicio do Menu -->
	
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
      
        <% 	HttpSession sessao = request.getSession(true);%>
       
        <!-- Conta usuário -->
	<ul class="nav navbar-nav navbar-right">
                                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Sua Conta
                                        <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <div class="navbar-content">
                                                    <div class="row">
                                                        <div class="col-md-5">
                                                        <%
                                                    	 //Get image from database
                                            		        Loja loja = new Loja();
                                                    	 	DAOLoja model_loja = new DAOLoja();
                                                        	loja = model_loja.consultarPorId(Integer.parseInt(sessao.getAttribute("id").toString()));
                                            		        byte[] bAvatar = loja.getFoto();
                                            		 
                                            		        try{
                                            		            FileOutputStream fos = new FileOutputStream("/home/gisomar/git/projetojavaweb/ProjetoVendasWebEE/WebContent/Loja/logo/logo"+sessao.getAttribute("id")+".gif"); 
                                            		            fos.write(bAvatar);
                                            		            fos.close();
                                            		        }catch(Exception e){
                                            		            e.printStackTrace();
                                            		        }
                                            		       
                                                        %>
                                                            <img src="logo/logo<%=sessao.getAttribute("id")%>.gif"
                                                                alt="IMG" class="img-responsive" />
                                                            <p class="text-center small">
                                                                <a href="#">Alterar Foto<%=sessao.getAttribute("id")%></a></p>
                                                        </div>
                                                        <div class="col-md-7">
                                                            <span> <%  out.print(sessao.getAttribute("usuario")); %></span>
                                                            <p class="text-muted small">
                                                                <%  out.print(sessao.getAttribute("email")); %></p>
                                                            <div class="divider">
                                                            </div>
                                                            <a href="ControllerCliente?acao=perfil"  class="btn btn-primary btn-sm active">Ver perfil</a>
                                                        	
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="navbar-footer">
                                                    <div class="navbar-footer-content">
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <a href="#" class="btn btn-default btn-sm">Alterar Senha</a>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <a href="Sair" class="btn btn-default btn-sm pull-right">Sair</a>
                                                                <input type="hidden" name="sair" value="true"/>
                                                           </div>
                                                           </div>
                                                </div>
                                               </div>
                                            </li>
                                       </ul>
                                     </li>
                              </ul>
      </div>
      </div><!--/.nav-collapse -->
    </nav>
	
	
	
	
	<!-- Fim do Menu -->
	<br><br><br>
	
	<!-- Inicio corpo da página e segundo Menu -->
	
	<p>
	<h3><span class="glyphicon glyphicon-th-list"></span>Cadastrar Departamento</h3>
	</p>
	<!-- Conteúdo -->
	
	
	
	
  <form method="post" class="form-horizontal" action="../ControllerLoja">
<fieldset>

<!--  
<div align="center">
	<img src="img/loja_cadastro.jpg" width="300" height="300" alt="" 
   	class="img-thumbnail img-responsive">
</div>
-->   	
   	
<!-- Form Name 
<legend>Cadastrar Loja</legend>-->

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">Nome do Departamento</label>  
  <div class="col-md-5">
  <input id="nome" name="nome" type="text" placeholder="Nome do Departamento" class="form-control input-md" required="">
    
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="enviar"></label>
  <div class="col-md-4">
    <button id="enviar" name="enviar" class="btn btn-primary">Enviar</button>
    <a href="../interno/indexLoja.jsp" class="btn btn-primary">Voltar</a>
     <% if(request.getAttribute("e") == "1"){  %>
    
			    <div id="modal_msg" class="modal fade bs-example-modal-sm in" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: block; padding-right: 17px;">
			    <div class="modal-backdrop fade in" style="height: 679px;"></div>
			    <div class="modal-dialog modal-sm">
			      <div class="modal-content">
			
			        <div class="modal-header">
			        <button type="button" onclick="closeMsg()" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			         
			          <h4 align="center" class="modal-title" id="mySmallModalLabel">Departamento Cadastrado com Sucesso!</h4>
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
<input type="hidden" value="cadastrarDepartamento" name="acao">
<input type="hidden" value="<%=sessao.getAttribute("id")%>" name="idLoja">
</fieldset>
</form>
	
	
	
</body>
</html>