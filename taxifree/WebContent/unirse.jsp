<%@ page language="java" import="domain.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Unirse al viaje</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
<%
	//De la sesion selecciono el nick y la ruta buscada
	String sessionUser= (String)session.getAttribute("session.user");
	Ruta rutaPasajero = (Ruta)session.getAttribute("session.ruta");
	//A partir de la url tomo el vid
	String vid = request.getParameter("vid");
	//Nos creamos la accion para poder añadir al pasajero en el viaje
	//Ver si el usuario tiene al menos una estrella para gastar
	IAccionPasajero accionPas = new AccionPasajeroImpl();
	Pasajero p = accionPas.datosPasajero(sessionUser);
	int numEstrellas = p.getEstrella();
	boolean hayEstrellas = true;
	if(numEstrellas>0){
		//Nos creamos un viaje nuevo para almacenar el que ha seleccionado el usuario
		Viaje viajePasajero = accionPas.seleccionaViajePasajero(vid);
		
		if(vid!=null && vid.length()>0){
			 accionPas.apuntarseAViaje(p, rutaPasajero, viajePasajero);
		}
	}else{
		hayEstrellas = false;
	}
	
	
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
	<table id="tablaUnirse">
		<tr valign ="middle" align="center">
			<% if(hayEstrellas){ %>
			<td>SE HA UNIDO CORRECTAMENTE AL VIAJE</td>
			<%}else{%>
			<td>NO TIENE ESTRELLAS SUFICIENTES</td>
			<%} %>
		</tr>
	</table>
</div>
</body>
</html>