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
<div id="top">
	<jsp:include  page="head.html"/>
	<jsp:include  page="cabeceraPasajero.jsp"/>
</div>

<div id="pasajero">
	<table id="tablaBotones">
	<tr valign ="middle" align="center" id="separador">
		<th><a href="FrontController?res=busquedaViajePasajero.jsp">BUSQUEDA DE VIAJE</a></th>
		<th><a href="FrontController?res=vAsignadosPasajero.jsp">VIAJES ASIGNADOS</a></th>
		<th><a href="FrontController?res=datosPasajero.jsp">DATOS PERSONALES</a></th>
	</tr>
	</table>
</div>
</body>
</html>