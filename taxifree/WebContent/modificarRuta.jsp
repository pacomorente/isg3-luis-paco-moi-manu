<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar Ruta</title>
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
		<td colspan='6'><a class=enlaceboton href="FrontController?res=acciones.jsp"> Menú  Usuario</a></td>
		</tr>
		<tr style="height: 15px"></tr>
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
	<%
		String rutaID = request.getParameter("rid");
		IAccionPasajero accionPas = new AccionPasajeroImpl();
		Ruta r = accionPas.seleccionaRuta(rutaID);
	%>
	<form action="FrontController?res=aceptarCambioRuta.jsp?rid=<%=rutaID%>" method="post">
	<table id="tablaResultados">
		<tr valign ="middle" align="center">
			<th>ORIGEN</th><th>DESTINO</th><th>FECHA</th>
		</tr>
		<tr valign ="middle" align="center">
			<td><input class="mayusculas" type="text" name="desde" value=<%=r.getOrigen()%>></td>
			<td><input  class="mayusculas" type="text" name="hasta" value=<%=r.getDestino()%>></td>
			<td><input  class="mayusculas" type="text" name="date" value=<%=r.getFecha()%>></td>
		</tr>
		<tr align="center" >
			<td colspan="3">
				<input name="submit" type="submit" value="Aceptar cambios" />
			</td>

		</tr>
	</table>
	</form>
</div>
</body>
</html>