<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Datos Personales Conductor</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
<style type="text/css">
<!--
	#cabecera td{background-color: rgb(238, 238, 238);}
	#separador td{background-color: rgb(124, 123, 134);}
  	#datosconductor td{
		border-top-width: 1px;
    border-top-style: solid;
 		border-top-color: rgb(153, 0, 51);
	}
-->
</style>
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
<table summary ="Datos del Conductor" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	<tr valign ="middle" align="center">
		<td  colspan="4"><b>CONDUCTOR</b><br> <%=sessionUser%><br><br><br></td>
	</tr>
	<%
        IAccionConductor accionCond = new AccionConductorImpl();
        Conductor datosCond= accionCond.datosConductor(sessionUser);

%>
			<tr id="separador" style="height: 24px">
			<td colspan="4"></td>
			</tr>
			<tr align="center" id="cabecera"">
				
				<td colspan="2"><u>Nombre</u></td>
				<td><u>Apellidos</u></td>
				<td><u>DNI</u></td>

			</tr>
			<tr align="center" id="datosconductor">
				
				<td colspan="2"><%=datosCond.getNombre()%></td>
				<td><%=datosCond.getApellidos()%></td>
				<td><%=datosCond.getDni()%></td>

			</tr>	
			<tr id="separador" style="height: 24px">
			<td colspan="4"></td>
			</tr>			
			<tr align="center" id="cabecera">
				
				<td colspan="2"><u>Correo</u></td>
				<td><u>Nick</u></td>
				<td><u>Estrellas</u></td>

			</tr>

			<tr align="center" id="datosconductor">
				
				<td colspan="2"><%=datosCond.getCorreo()%></td>
				<td><%=datosCond.getNick()%></td>
				<td><%=datosCond.getEstrella()%></td>

			</tr>	
			<tr id="separador" style="height: 24px">
			<td colspan="4"></td>
			</tr>
			<tr align="center" id="cabecera">
				
				<td><u>Marca Vehiculo</u></td>
				<td><u>Modelo Vehículo</u></td>
				<td><u>Plazas</u></td>
				<td><u>Color</u></td>

			</tr>

			<tr align="center" id="datosconductor">
				
				<td><%=datosCond.getVehiculo().getMarca()%></td>
				<td><%=datosCond.getVehiculo().getModelo()%></td>
				<td><%=datosCond.getVehiculo().getPlazas()%></td>
				<td><%=datosCond.getVehiculo().getColor()%></td>

			</tr>						
</table>
</div>
<div>
<li><b><a href="FrontController?res=conductor.jsp">Menú Conductor</a></b></li>
<li><a href="FrontController?res=acciones.jsp"><b>Menú Usuario</b></a></li>
<li class="noborder"><a href="#">Salir</a></li>
</div>
</body>
</html>