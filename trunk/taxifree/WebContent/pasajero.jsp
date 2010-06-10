<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acciones del Pasajero</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
<%
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");
%>
<div id="top">
	<jsp:include  page="head.html"/>
</div>

<div id="content">
	<table align="center">
		<tr style="height: 11px"></tr>
		<tr align="center" id="separador">
		<td colspan='6'><a class=enlaceboton href="FrontController?res=pasajero.jsp">Menú Pasajero</a></td>
		<td colspan='6'><a class=enlaceboton href="FrontController?res=acciones.jsp">Menú Usuario</a></td>
		</tr>
	</table>
	<table id="tablaViajero">
	<tr valign ="middle" align="center">
		<td  colspan="3">
			<b>PASAJERO</b>
			<br> 
				<%=sessionUser%>
			<br>
			<br>
			<br>
		</td>
	</tr>
	<tr valign ="middle" align="center" id="separador">
		<th><a href="FrontController?res=busquedaViajePasajero.jsp">BUSQUEDA DE VIAJE</a></th>
		<th><a href="FrontController?res=vAsignadosPasajero.jsp">VIAJES ASIGNADOS</a></th>
		<th><a href="FrontController?res=datosPasajero.jsp">DATOS PERSONALES</a></th>
	</tr>
	</table>
</div>
</body>
</html>