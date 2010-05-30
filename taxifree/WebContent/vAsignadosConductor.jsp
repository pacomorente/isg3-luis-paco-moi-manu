<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Viajes Asignados al Conductor</title>
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
<table summary ="Datos del Conductor" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	<tr id="nickconductor" valign ="middle" align="center">
		<td  colspan="7"><b>CONDUCTOR</b><br> <%=sessionUser%><br></td>
	</tr>
	<tr id="nickconductor" valign ="middle" align="center">
		<td  colspan="7"><b>PUNTOS ESTRELLAS ACTUALES: </b> <%=puntosactuales%><br></td>
	</tr>
	<tr style="height: 15px"></tr>	
	<%
        //IAccionConductor accionCond = new AccionConductorImpl();
	
		List<Viaje> viajesCond= accionCond.verViajesAsignados(sessionUser);
		
		if (viajesCond!=null && viajesCond.size()!=0){
	        for (Iterator iter = viajesCond.iterator(); iter.hasNext();) {
	            Viaje viaje = (Viaje) iter.next();
	            String activo="SI";
	            	
	            if (viaje.getAnulado()==true)
	            	activo="NO";
            	
%>
			<tr id="separador" style="height: 20px">
			<td colspan="1"></td>			
			<td colspan="1"></td>
			<td colspan="1" align="center"><b><a class=enlaceboton href="FrontController?res=modificarViajeC.jsp?pid=<%=viaje.getViajeID()%>">MODIFICAR</a></b></td>
			<td colspan="1" align="center"><b><a class=enlaceboton href="FrontController?res=cambiarEstadoViajeC.jsp?pid=<%=viaje.getViajeID()%>">ACTIVAR/ANULAR</a></b></td>
			<td colspan="1" align="center"><b><a class=enlaceboton href="FrontController?res=eliminarViajeC.jsp?pid=<%=viaje.getViajeID()%>">ELIMINAR</a></b></td>
			<td colspan="1"></td>
			<td colspan="1"></td>
			</tr>
			<tr align="center" id="cabecera">
				
				<td><u>Origen</u></td>
				<td style="width: 110px"><u>Destino</u></td>
				<td style="width: 107px"><u>Fecha</u></td>
				<td><u>PuntoIntermedio1</u></td>
				<td><u>PuntoIntermedio2</u></td>
				<td><u>PuntoIntermedio3</u></td>
				<td><u>ACTIVO</u></td>


				

			</tr>
			<tr align="center" id="datosconductor">
				
				<td><%=viaje.getOrigen()%></td>
				<td><%=viaje.getDestino()%></td>
				<td><%=viaje.getFecha()%></td>
				<td><%=viaje.getPuntosInt01()%></td>
				<td><%=viaje.getPuntosInt02()%></td>
				<td><%=viaje.getPuntosInt03()%></td>
				<td><%=activo%></td>

			</tr>
	
	
<%
        	}
        }
        else
        {%>
			<tr align="center" id="cabecera">
			<td colspan='6'>ACTUALMENTE NO EXISTEN VIAJES ASIGNADOS.</td>
			</tr>
        <%}
%>			
</table>
</div>

</body>
</html>