<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busqueda de Viaje Pasajero</title>
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
	</table>
	<form action="FrontController?res=buscaViaje.jsp" id="formularioPasajero" method="post">
		<label for="from" id="lfrom">Desde:</label>
		<input class="mayusculas" type="text" size="25" id="from" name="origen" />
		<br></br><br></br>
		<label for="to" id="lto">Hasta:</label>
		<input class="mayusculas" type="text" size="25" id="to" name="destino" />
		<br></br><br></br>
		<label for="date" id="lfecha">Fecha:</label>
		<input type="text" size="25" id="date" name="date" value="mm/dd/aaaa" />
		<br></br><br></br>
		<label for="move" id="lmove">Desplazamiento:</label>
		<input class="mayusculas" type="text" size="25" id="move" name="desplazamiento" />
		<p id="botonEnviar">
			<input name="submit" type="submit" value="Buscar" />
		</p>
	</form>
</div>
</body>
</html>