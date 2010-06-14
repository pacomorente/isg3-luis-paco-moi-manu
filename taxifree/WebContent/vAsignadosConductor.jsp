<%@ page language="java" import="domain.*,java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		<td  colspan="9"><b>CONDUCTOR</b><br> <%=sessionUser%><br></td>
	</tr>
	<tr id="nickconductor" valign ="middle" align="center">
		<td  colspan="9"><b>PUNTOS ESTRELLAS ACTUALES: </b> <%=puntosactuales%><br></td>
	</tr>
	<tr style="height: 15px"></tr>
				<tr align="center" id="separador">
				
				<th><u>ORIGEN</u></th>
				<th><u>DESTINO</u></th>
				<th><u>FECHA</u></th>
				<th><u>PARADA 1</u></th>
				<th><u>PARADA 2</u></th>
				<th><u>PARADA 3</u></th>
				<th><u>PLAZAS LIBRES</u></th>				
				<th><u>ACTIVO</u></th>
				<th><u>OPCIONES</u></th>
				<th><u>VER MAPA</u></th>
	

		</tr>	
	<%
        //IAccionConductor accionCond = new AccionConductorImpl();
	
		List<Viaje> viajesCond= accionCond.verViajesAsignados(sessionUser);
		//OrdenaLista.ordena(viajesCond,"fecha");		
		//System.out.println(viajesCond);  
		if (viajesCond!=null && viajesCond.size()!=0){
		
	        for (Iterator iter = viajesCond.iterator(); iter.hasNext();) {
	            Viaje viaje = (Viaje) iter.next();
	            String activo="SI";
	            	
	            if (viaje.getAnulado()==true)
	            	activo="NO";
	            int plazasLibres=4;
	            Viaje v=accionCond.consultaViaje(viaje.getViajeID());
	            if (v.getPasajeros()!=null)
	            	plazasLibres=plazasLibres - v.getPasajeros().size();
	            
	            
            	
%>

			<tr align="center" id="cabecera">
				
				<td><%=viaje.getOrigen()%></td>
				<td><%=viaje.getDestino()%></td>
				<td><%=viaje.getFecha()%></td>
				<td><%=viaje.getPuntosInt01()%></td>
				<td><%=viaje.getPuntosInt02()%></td>
				<td><%=viaje.getPuntosInt03()%></td>
				<td><%=plazasLibres%></td>				
				
			<%	  
				
				if (activo.equals("SI")){
				%>
				 <td><%=activo%><img src="images/verde.jpeg" align="middle" style="height: 31px; width: 31px" border="0"></img></td>
				 <%}else{ %>
				 <td><%=activo%><img src="images/rojo.jpeg" align="middle" style="height: 31px; width: 23px" border="0"></img></td>
				<%
				 }
				 %>
			<td  rowspan="1" align="center">
			<b><a class=enlaceboton href="FrontController?res=modificarViajeC.jsp?pid=<%=viaje.getViajeID()%>">MODIFICAR</a></b><br>
			<br><b><a class=enlaceboton href="FrontController?res=eliminarViajeC.jsp?pid=<%=viaje.getViajeID()%>">ELIMINAR</a></b><br>
			<br><b><a class=enlaceboton href="FrontController?res=cambiarEstadoViajeC.jsp?pid=<%=viaje.getViajeID()%>">ACTIVAR/ANULAR</a></b>
			</td>
			<td align="center">
				<a href="FrontController?res=verMapa.jsp?origen=<%=viaje.getOrigen()%>&destino=<%=viaje.getDestino()%>&rol=conductor">
					<img alt="Unirse" src="images/logoMaps.gif" border="0" style="height: 35px; width: 31px"></img>
				</a>
			</td>
			</tr>
			<tr id="" style="height: 5px">
	
	
<%
        	}
        }
        else
        {%>
			<tr align="center" id="cabecera">
			<td colspan='9'>ACTUALMENTE NO EXISTEN VIAJES ASIGNADOS.</td>
			</tr>
        <%}
%>			
</table>
</div>

</body>
</html>