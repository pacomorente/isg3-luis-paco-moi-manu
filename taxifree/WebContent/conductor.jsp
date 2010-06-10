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
<tr style="height: 15px"></tr>
</table>
<table summary ="Acciones del Usuario" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	<tr valign ="middle" align="center" id="nickconductor">
		<td  colspan="3"><b>CONDUCTOR</b><br> <%=sessionUser%><br></td>
	</tr>
	<tr style="height: 15px"></tr>
	<tr valign ="middle" align="center" id="separador">
		<th><a href="FrontController?res=altaViajeConductor.jsp">ALTA DE VIAJE </a></th><th><a href="FrontController?res=vAsignadosConductor.jsp">VIAJES ASIGNADOS</a></th> <th><a href="FrontController?res=datosConductor.jsp">DATOS PERSONALES</a></th>
	</tr>
<tr style="height: 15px"></tr>

			<tr align="center" id="conductor">
				
				<td></td>
				<td> </td>
				<td>  </td>
			</tr>

</table>

</div>
</body>
</html>