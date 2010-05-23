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
	.enlaceboton {
	PADDING-RIGHT: 2px; PADDING-LEFT: 2px; FONT-WEIGHT: bold; FONT-SIZE: 8pt; PADDING-BOTTOM: 2px; COLOR: #666666; PADDING-TOP: 2px; FONT-FAMILY: verdana, arial, sans-serif; BACKGROUND-COLOR: #ffffcc; TEXT-DECORATION: none
}
.enlaceboton:link {
	BORDER-RIGHT: #666666 2px solid; BORDER-TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; BORDER-BOTTOM: #666666 2px solid
}
.enlaceboton:visited {
	BORDER-RIGHT: #666666 2px solid; BORDER-TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; BORDER-BOTTOM: #666666 2px solid
}
.enlaceboton:hover {
	BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #666666 2px solid; BORDER-LEFT: #666666 2px solid; BORDER-BOTTOM: #cccccc 1px solid
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
		<td  colspan="7"><b>CONDUCTOR</b><br> <%=sessionUser%><br><br><br></td>
	</tr>
	<%
        IAccionConductor accionCond = new AccionConductorImpl();
		List<Viaje> viajesCond= accionCond.verViajesAsignados(sessionUser);
		
		
        for (Iterator iter = viajesCond.iterator(); iter.hasNext();) {
            Viaje viaje = (Viaje) iter.next();
            String activo="SI";
            	
            if (viaje.getAnulado()==true)
            	activo="NO";
            	
%>
			<tr id="separador" style="height: 24px">
			<td colspan="2">VIAJE -- <%=viaje.getViajeID()%><b></b></td>
			<td colspan="2"><b><a class=enlaceboton href="FrontController?res=modificarViajeC.jsp?pid=<%=viaje.getViajeID()%>">Modificar</a></b></td>
			<td colspan="1"><b><a class=enlaceboton href="FrontController?res=cambiarEstadoViajeC.jsp?pid=<%=viaje.getViajeID()%>">Activar/Anular</a></b></td>
			<td colspan="2"><b><a class=enlaceboton href="FrontController?res=eliminarViajeC.jsp?pid=<%=viaje.getViajeID()%>">Eliminar Viaje</a></b></td>
			</td>
			</tr>
			<tr align="center" id="cabecera">
				
				<td><u>Origen</u></td>
				<td><u>Destino</u></td>
				<td><u>Fecha</u></td>
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
%>	
				
</table>
</div>
<div id="menu">
<li><b><a href="FrontController?res=conductor.jsp">Menú Conductor</a></b></li>
<li><a href="FrontController?res=acciones.jsp"><b>Menú Usuario</b></a></li>
</div>
</body>
</html>