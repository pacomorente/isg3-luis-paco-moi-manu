<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Acciones del Usuario</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
<style type="text/css">
<!--
	#cabecera td{background-color: rgb(238, 238, 238);}
  	#productos td{
		border-top-width: 1px;
    border-top-style: solid;
 		border-top-color: rgb(153, 0, 51);
	}
-->
</style>
</head>
<body>

<div id="top">
<jsp:include  page="head.html"/>
</div>

<div id="content">
<table summary ="Acciones del Usuario" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	<tr valign ="middle" align="center">
		<td  colspan="3">ACCIONES DEL USUARIO<br>¿ Qué desea hacer ?<br><br><br></td>
	</tr>
	<tr valign ="middle" align="center" id="cabecera">
		<td>CONDUCTOR</td><td>PASAJERO</td> <td>LOCALIZAR MAPAS</td>
	</tr>
	<%
	System.out.println("El usuario debe elegir el rol a usar");
	%>

			<tr align="center" id="productos">
				
				<td>  <img src='images/coche.jpeg' style="height: 45px; width: 50px"> </td>
				<td> <img src='images/pasajero.jpeg' style="height: 45px; width: 50px"></td>
				<td> <img src='images/localizar.jpeg' style="height: 45px; width: 50px"> </td>
			</tr>

</table>
</div>
</body>
</html>