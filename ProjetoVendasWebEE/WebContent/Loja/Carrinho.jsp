<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="com.vendas.basicas.Produto"%>
<%@page import="com.vendas.model.DAOCliente"%>
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

<!-- CSS Produtos -->
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">


<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>


	<!-- MASCARAS -->
	<script type="text/javascript" src="../mascara/jquery.maskedinput.js"></script>
	<script src="../mascara/mascaras.js" ></script>

<!-- Menu Interno -->
<style type="text/css">
//Menu Conta do Usuário
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

//Style Lista de Produtos 

@import url(http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css);
.col-item
{
    border: 1px solid #E1E1E1;
    border-radius: 5px;
    background: #FFF;
}
.col-item .photo img
{
    margin: 0 auto;
    width: 100%;
}

.col-item .info
{
    padding: 10px;
    border-radius: 0 0 5px 5px;
    margin-top: 1px;
}

.col-item:hover .info {
    background-color: #F5F5DC;
}
.col-item .price
{
    /*width: 50%;*/
    float: left;
    margin-top: 5px;
}

.col-item .price h5
{
    line-height: 20px;
    margin: 0;
}

.price-text-color
{
    color: #219FD1;
}

.col-item .info .rating
{
    color: #777;
}

.col-item .rating
{
    /*width: 50%;*/
    float: left;
    font-size: 17px;
    text-align: right;
    line-height: 52px;
    margin-bottom: 10px;
    height: 52px;
}

.col-item .separator
{
    border-top: 1px solid #E1E1E1;
}

.clear-left
{
    clear: left;
}

.col-item .separator p
{
    line-height: 20px;
    margin-bottom: 0;
    margin-top: 10px;
    text-align: center;
}

.col-item .separator p i
{
    margin-right: 5px;
}
.col-item .btn-add
{
    width: 50%;
    float: left;
}

.col-item .btn-add
{
    border-right: 1px solid #E1E1E1;
}

.col-item .btn-details
{
    width: 50%;
    float: left;
    padding-left: 10px;
}
.controls
{
    margin-top: 20px;
}
[data-slide="prev"]
{
    margin-right: 10px;
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
      <!-- Carrinho do Usuário -->
	<ul class="nav navbar-nav navbar-right">
        <% 	HttpSession sessao = request.getSession(true);
        ArrayList<Produto> lista_produtos_s = new ArrayList<Produto>();
         try{
          
         lista_produtos_s.addAll((ArrayList<Produto>) sessao.getAttribute("qtdCarrinho"));
         %>
     
    
	
	<%}catch(NullPointerException e){
          sessao.setAttribute("qtdCarrinho", lista_produtos_s);
       }
    %>
    
             <li class="dropdown"><a href="#" class="fa fa-shopping-cart"><span class="badge"> <%=lista_produtos_s.size()%></span></a>
                                    
                                     </li>
                                     
                                     
                                     <!-- Conta do Usuário -->
                                      <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Sua Conta
                                        <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <div class="navbar-content">
                                                    <div class="row">
                                                        <div class="col-md-5">
                                                        
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
	
	<!-- Inicio corpo da página  -->


<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>	
	
	<tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
	<%
	//Obtendo os produtos no qual consta no carrinho
	Produto produto = new Produto();
	Loja loja = new Loja();
	if(lista_produtos_s.size() > 0){
	for(Produto p : lista_produtos_s){
		 produto.setNome(p.getNome());
		 produto.setDescricao(p.getDescricao());
		 produto.setPreco_produto(p.getPreco_produto());
		 produto.setLojas(p.getLojas());
	
	%>
              
                </thead>
                <tbody>
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#"><%produto.getNome(); %></a></h4>
                                <h5 class="media-heading"> by <a href="#"></a></h5>
                                <span>Descrição: </span><span class="text-success"><strong><%produto.getDescricao(); %></strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="email" class="form-control" id="exampleInputEmail1" value="3">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>$4.87</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>$14.61</strong></td>
                        <td class="col-sm-1 col-md-1">
                        <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </button></td>
                    </tr>
                    
                    <%} 
                    
                    }else{%>
                    <h3>Nenhum Produto no Carrinho :/</h3>
                    
                    <%
                    
                    
                    }%>
                
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                        <td class="text-right"><h5><strong>$24.59</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Estimated shipping</h5></td>
                        <td class="text-right"><h5><strong>$6.94</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>$31.53</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></td>
                        <td>
                        <button type="button" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


	
</body>
</html>