<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Acciones del Usuario</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
	<%
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");

	%>
<div id="top">
	<jsp:include  page="head.html"/>
	<jsp:include  page="cabeceraConductor.jsp"/>
</div>
<div id="conductor">
	<table id="tablaBotones">
	<tr valign ="middle" align="center" id="separador">
		<th><a href="FrontController?res=altaViajeConductor.jsp">- ALTA DE VIAJE -</a></th>
		<th><a href="FrontController?res=vAsignadosConductor.jsp">- GESTIÓN DE VIAJES -</a></th> 
		<th><a href="FrontController?res=datosConductor.jsp">- DATOS PERSONALES -</a></th>

	</tr>
	</table>
</div>
</body>
</html>
