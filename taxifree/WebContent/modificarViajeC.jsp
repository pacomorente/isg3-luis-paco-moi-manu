<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Modificar Viaje Conductor</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
	<%
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");
	IAccionConductor accionCond = new AccionConductorImpl();
	int puntosactuales=accionCond.verPuntosActualesConductor(sessionUser);
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
<form action="FrontController?res=aceptarcambios.jsp" method="post">
<table summary ="Datos del Conductor" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	
	<tr id="nickconductor" valign ="middle" align="center">
		<td  colspan="6"><b>CONDUCTOR</b><br> <%=sessionUser%><br></td>
	</tr>
	<tr id="nickconductor" valign ="middle" align="center">
		<td  colspan="6"><b>PUNTOS ESTRELLAS ACTUALES: </b> <%=puntosactuales%><br></td>
	</tr>
	<tr style="height: 15px"></tr>
	<%

		String pidViaje = request.getParameter("pid");

        
        boolean viajeEliminado=false;
		boolean noExistePasajeros= accionCond.existePasajerosViaje(pidViaje);
		if (!noExistePasajeros){
		
String mensaje="<script language='javascript'>alert('El viaje seleccionado está asignado a un pasajero. No puede ser modificado.');</script>";
//String mensaje="El viaje seleccionado está asignado a un pasajero. No puede ser modificado.";
out.println(mensaje);
%>

<tr style="height: 11px"></tr>
<tr align="center" >
<td colspan='6'><a class=enlaceboton href="FrontController?res=vAsignadosConductor.jsp">Volver Viajes Asignados</a></td>

<%

 
		
		}else{
		Viaje viaje= accionCond.consultaViaje(pidViaje);
		
		String activo="SI";	
        if (viaje.getAnulado()==true)
        	activo="NO";
            	
%>

			<tr align="center" id="cabecera"">
				
				<td><u>Origen</u></td>
				<td><u>Destino</u></td>
				<td><u>Fecha</u></td>
			</tr>
			<tr align="center" id="datosconductor">
				
				<td><input class="mayusculas" type="text" name="desde" value=<%=viaje.getOrigen()%>></td>
				<td><input  class="mayusculas" type="text" name="hasta" value=<%=viaje.getDestino()%>></td>
				<td><input  class="mayusculas" type="text" name="date" value=<%=viaje.getFecha()%>></td>
			</tr>	
			<tr align="center" id="cabecera"">
				
				<td><u>PuntoIntermedio1</u></td>
				<td><u>PuntoIntermedio2</u></td>
				<td><u>PuntoIntermedio3</u></td>

			</tr>
			<tr align="center" id="datosconductor">
				<td><input class="mayusculas" type="text" name="pto01" value=<%=viaje.getPuntosInt01()%>></td>
				<td><input class="mayusculas"  type="text" name="pto02" value=<%=viaje.getPuntosInt02()%>></td>
				<td><input class="mayusculas"  type="text" name="pto03" value=<%=viaje.getPuntosInt03()%>></td>
			</tr>	
			<tr align="center" id="datosconductor">
				<td colspan="1"><input type="hidden" readonly name="pid" value=<%=pidViaje%>></td>
				<td colspan="2"><input type="hidden" readonly name="anulado" value=<%=activo%>></td>
			</tr>	
			<tr align="center" >
				<td colspan="3">
				<input name="submit" type="submit" value="Aceptar cambios" />
				</td>

			</tr>
	<%
	}
	 %>
</table>
</form>
</div>

</body>
</html>