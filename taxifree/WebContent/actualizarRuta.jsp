<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualizar Ruta</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
<%
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");
	String vidNuevo = request.getParameter("vidNuevo");
	Ruta rutaNueva = (Ruta)session.getAttribute("session.rutaNueva");
	Ruta rutaAntigua = (Ruta)session.getAttribute("session.rutaAnt");
	String vidAntiguo = rutaAntigua.getViajeID();
	IAccionPasajero accionPas = new AccionPasajeroImpl();
	boolean rutaAct = false;
	if(vidNuevo.equals(vidAntiguo)){
		//El numero de pasajeros no varia pq seguiria en el mismo viaje
		rutaNueva.setViaje(null);
		accionPas.modificaRuta(rutaAntigua, rutaNueva);
		rutaAct = true;
	}else{
		//El pasajero ha seleccionado otro viaje diferente
		accionPas.modificaViajePasajero(vidAntiguo, vidNuevo, rutaAntigua.getIdRuta());
		rutaNueva.setViaje(vidNuevo);
		accionPas.modificaRuta(rutaAntigua, rutaNueva);
		rutaAct = true;
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
	<table id="tablaUnirse">
		<tr valign ="middle" align="center">
			<% if(rutaAct){ %>
			<td>SE HA ACTUALIZADO CORRECTAMENTE LA RUTA</td>
			<%}else{%>
			<td>NO TIENE ESTRELLAS SUFICIENTES</td>
			<%} %>
		</tr>
	</table>
</div>
</body>
</html>