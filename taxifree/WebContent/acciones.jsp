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

	System.out.println("El usuario debe elegir el rol a usar");
	%>
<div id="top">
<jsp:include  page="head.html"/>
</div>

<div id="content">
<table summary ="Acciones del Usuario" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	<tr valign ="middle" align="center"  id="nickconductor">
		<td  colspan="3"><br><br><u>ACCIONES DEL USUARIO<b></b></u><b><br></b><b><br></b><b>BIENVENIDO : </b><%=sessionUser%><br><br><b>� Qu� desea hacer ?</b><br><br></td>
	</tr>
	<tr valign ="middle" align="center" id="separador">
		<th>CONDUCTOR</th><th/><th>PASAJERO</th>
	</tr>


			<tr align="center" id="acciones">
				
				<td>
					<a href="FrontController?res=conductor.jsp"> 
					<img src='images/coche.jpeg' alt="Utilidades rol Conductor" border="0" style="height: 45px; width: 50px"> 
					</a>
				</td>
				<td></td>
				<td>
					<a href="FrontController?res=pasajero.jsp">
					<img src='images/pasajero.jpeg' border="0" style="height: 45px; width: 50px">
					</a>
					</td>

			</tr>

</table>
</div>
</body>
</html>