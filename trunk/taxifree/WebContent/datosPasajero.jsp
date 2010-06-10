<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Datos Personales Pasajero</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
	<div id="top">
		<jsp:include  page="head.html"/>
	</div>
	<%
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");
	%>
	
	<div id="content">
		<table align="center">
			<tr style="height: 11px"></tr>
			<tr align="center" id="separador">
			<td colspan='6'><a class=enlaceboton href="FrontController?res=pasajero.jsp">Menú Pasajero</a></td>
			<td colspan='6'><a class=enlaceboton href="FrontController?res=acciones.jsp"> Menú  Usuario</a></td>
			</tr>
		</table>
	</div>
	
	<table summary ="Datos del Pasajero" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	<tr valign ="middle" align="center">
		<td  colspan="4"><b>PASAJERO</b><br> <%=sessionUser%><br><br><br></td>
	</tr>

	<%
        IAccionPasajero accionPas = new AccionPasajeroImpl();
        Pasajero datosPas= accionPas.datosPasajero(sessionUser);
	%>
			<tr id="" style="height: 24px">
			<td colspan="4"></td>
			</tr>
			<tr align="center" id="separador">
				
				<th colspan="2"><u>Nombre</u></th>
				<th><u>Apellidos</u></th>
				<th><u>DNI</u></th>

			</tr>
			<tr align="center" id="cabecera">
				
				<td colspan="2"><%=datosPas.getNombre()%></td>
				<td><%=datosPas.getApellidos()%></td>
				<td><%=datosPas.getDni()%></td>

			</tr>	
			<tr id="" style="height: 24px">
			<td colspan="4"></td>
			</tr>			
			<tr align="center" id="separador">
				
				<th colspan="2"><u>Correo</u></th>
				<th><u>Nick</u></th>
				<th><u>Estrellas</u></th>

			</tr>

			<tr align="center" id="cabecera">
				
				<td colspan="2"><%=datosPas.getCorreo()%></td>
				<td><%=datosPas.getNick()%></td>
				<td><%=datosPas.getEstrella()%></td>

			</tr>
			<tr id="" style="height: 24px">				
</table>			
</body>
</html>