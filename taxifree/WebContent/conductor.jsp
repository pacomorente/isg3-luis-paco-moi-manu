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
</div>

<div id="content">
<table align="center">
<tr style="height: 11px"></tr>
<tr align="center" id="separador">
<td colspan='6'><a class=enlaceboton href="FrontController?res=conductor.jsp">Menú Conductor</a></td>
<td colspan='6'><a class=enlaceboton href="FrontController?res=acciones.jsp"> Menú  Usuario</a></td>

</tr>

</table>
<table summary ="Acciones del Usuario" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	<tr valign ="middle" align="center">
		<td  colspan="3"><b>CONDUCTOR</b><br> <%=sessionUser%><br><br><br></td>
	</tr>
	<tr valign ="middle" align="center" id="cabecera">
		<td><a href="FrontController?res=altaViajeConductor.jsp">ALTA DE VIAJE </a></td><td><a href="FrontController?res=vAsignadosConductor.jsp">VIAJES ASIGNADOS</a></td> <td><a href="FrontController?res=datosConductor.jsp">DATOS PERSONALES</a></td>
	</tr>


			<tr align="center" id="conductor">
				
				<td></td>
				<td> </td>
				<td>  </td>
			</tr>

</table>

</div>
</body>
</html>