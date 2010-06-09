<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eliminar Ruta</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
<%
	//De la sesion selecciono el nick
	String sessionUser= (String)session.getAttribute("session.user");
	//Como parametro del get tomo la ruta
	String rutaID = request.getParameter("rid");
	System.out.println(rutaID);
	//A partir del ID sacamos el objeto ruta
	IAccionPasajero accionPas = new AccionPasajeroImpl();
	Ruta r = accionPas.seleccionaRuta(rutaID);
	accionPas.eliminaRuta(r);
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
			<td>SE HA ELIMINADO CORRECTAMENTE DEL VIAJE</td>
		</tr>
	</table>
</div>
</body>
</html>