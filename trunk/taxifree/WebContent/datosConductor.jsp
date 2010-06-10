<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Datos Personales Conductor</title>
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
<table summary ="Datos del Conductor" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	<tr valign ="middle" align="center" id="nickconductor">
		<td  colspan="4"><b>CONDUCTOR</b><br> <%=sessionUser%></td>
	</tr>
<tr style="height: 10px"></tr>
	<%
        IAccionConductor accionCond = new AccionConductorImpl();
        Conductor datosCond= accionCond.datosConductor(sessionUser);
	%>
			<tr id="" style="height: 15px">
			<td colspan="4"></td>
			</tr>
			<tr align="center" id="separador"">
				
				<th colspan="2"><u>Nombre</u></th>
				<th><u>Apellidos</u></th>
				<th><u>DNI</u></th>

			</tr>
			<tr align="center" id="cabecera">
				
				<td colspan="2"><%=datosCond.getNombre()%></td>
				<td><%=datosCond.getApellidos()%></td>
				<td><%=datosCond.getDni()%></td>

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
				
				<td colspan="2"><%=datosCond.getCorreo()%></td>
				<td><%=datosCond.getNick()%></td>
				<td><%=datosCond.getEstrella()%></td>

			</tr>	
			<tr id="" style="height: 24px">
			<td colspan="4"></td>
			</tr>
			<tr align="center" id="separador">
				
				<th><u>Marca Vehiculo</u></th>
				<th><u>Modelo Vehículo</u></th>
				<th><u>Plazas</u></th>
				<th><u>Color</u></th>

			</tr>

			<tr align="center" id="cabecera">
				
				<td><%=datosCond.getVehiculo().getMarca()%></td>
				<td><%=datosCond.getVehiculo().getModelo()%></td>
				<td><%=datosCond.getVehiculo().getPlazas()%></td>
				<td><%=datosCond.getVehiculo().getColor()%></td>

			</tr>	
			<tr id="" style="height: 24px">					
</table>

</div>
</body>
</html>