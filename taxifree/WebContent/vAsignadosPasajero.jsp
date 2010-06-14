<%@ page language="java" import="domain.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Viajes Asignados al Pasajero</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
<%
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");
	//Seleccionar las rutas asociadas al Pasajero
	IAccionPasajero accion = new AccionPasajeroImpl();
	List<Ruta> rutasPasajero = accion.seleccionaRutasDelPasajero(sessionUser);
%>
<div id="top">
	<jsp:include  page="head.html"/>
	<jsp:include  page="cabeceraPasajero.jsp"/>
</div>
<div id="vAsignadosPas">
	<table id="tablaResultados">
		<tr valign ="middle" align="center">
		<th>ORIGEN</th><th>DESTINO</th><th>FECHA</th><th>VER MAPA</th><th>MODIFICAR</th><th>ELIMINAR</th>
		</tr>
		<%
		if(rutasPasajero.isEmpty()){
		%>	
		<tr><td colspan = 6 align= "center">NO TIENE NINGUNA RUTA ASIGNADA</td></tr>
		<%	
		}else{
			for(Ruta r: rutasPasajero){
				String origenPasajero = r.getOrigen();
				String destinoPasajero = r.getDestino();
				String f = r.getFecha();
		%>
		<tr>
			<td align="center"><%=origenPasajero%> </td>
			<td align="center"><%=destinoPasajero%> </td>
			<td align="center"><%=f%> </td>
			<td align="center">
				<a href="FrontController?res=verMapa.jsp?origen=<%=origenPasajero%>&destino=<%=destinoPasajero%>&rol=pasajero">
					<img alt="Unirse" src="images/logoMaps.gif"></img>
				</a>
			</td>
			<td align="center">
				<a href="FrontController?res=modificarRuta.jsp?rid=<%=r.getIdRuta()%>">
					<img alt="Unirse" src="images/update.jpg"></img>
				</a>
			</td>
			<td align="center">
				<a href="FrontController?res=eliminarRuta.jsp?rid=<%=r.getIdRuta()%>">
					<img alt="Unirse" src="images/delete.jpg"></img>
				</a>
			</td>
		<%
			}
		}
		
		%>
		</tr>
	</table>
</div>
</body>
</html>