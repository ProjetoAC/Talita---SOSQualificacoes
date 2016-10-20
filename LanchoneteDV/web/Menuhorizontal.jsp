<%-- 
    Document   : Menuhorizontal
    Created on : 14/10/2016, 14:15:23
    Author     : Gilvan Honorato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  xml:lang="pt" lang="pt">
 
<head>
	<title>Menu Horizontal</title>
	<style type="text/css">
	<!--
		body {
			padding:20px;
			margin:10px;
		}
 
		#menu ul {
                        width: 100%;
                        display: inline-block;
			background-color:#EDEDED;;
			list-style:none;
			font:100% Tahoma;
		}
 
		#menu ul li { display: inline; }
 
		#menu ul li a {
			background-color:#EDEDED;
			color: #333;
			text-decoration: none;
			border-bottom:3px solid #EDEDED;
			padding: 15px 25px;
			float:left;
		}
 
		#menu ul li a:hover {
			background-color:#D6D6D6;
			color: #6D6D6D;
		}
	-->
	</style>
</head>
 
<body>
    <div id="menu" style="text-align: center;">
        <img src="bestfood.png" width="100%" height="450px"  alt="">
		<ul>
			<li><a href="listar_lanchonetes.jsp">Home</a></li>
			<li><a href="Cadastros_Usuarios.jsp">Cadastre-se</a></li>
			<li><a href="Cadastros_Estabelecimentos.jsp">Cadastrar Lanchonetes</a></li>
		        <li><a href="login.jsp">Login</a></li>
                        <li><a href="contato.jsp">Contato</a></li>
		
                <% if(request.getSession().getAttribute("usuario")!=null){%>
                <div class="pull-right">
                    Bem vindo ${sessionScope.usuario.nome_sobrenome}
                    <a href="SairServlet">Sair</a>
                </div>
                <%}%>
                </ul>
	</div>
</body>
</html>
