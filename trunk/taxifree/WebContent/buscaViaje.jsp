<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.DateFormat"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado Busqueda</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
<%
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");
	
	//Creamos el BO para poder trabajar
	IAccionPasajero accionPas = new AccionPasajeroImpl();
	//Cogemos los datos del formulario
	String desdeForm = request.getParameter("origen");
	String hastaForm = request.getParameter("destino");
	String fechaForm = request.getParameter("date");
	
	Ruta r = new Ruta();
	r.setOrigen(desdeForm.toLowerCase());
	r.setDestino(hastaForm.toLowerCase());
	r.setFecha(fechaForm);
	session.setAttribute("session.ruta",r);
	Set<Viaje> viajes = (Set<Viaje>)accionPas.buscarViaje(r, sessionUser, false);
%>
<div id="top">
	<jsp:include  page="head.html"/>
	<jsp:include  page="cabeceraPasajero.jsp"/>
</div>
<div id="buscaViajeRes">
	<table id="tablaResultados">
		<tr valign ="middle" align="center">
		<th>Nº</th><th>ORIGEN</th><th>DESTINO</th><th>FECHA</th><th>PASAJEROS</th><th>UNIRSE A VIAJE</th>
		</tr>
		<%
		if(viajes.isEmpty()){
		%>	
		<tr><td colspan = 6 align= "center">NO HAY RESULTADOS PARA SU BUSQUEDA</td></tr>
		<%	
		}else{
			for(Viaje v: viajes){
				String origenPasajero = r.getOrigen().toUpperCase();
				String destinoPasajero = v.getDestino();
				String puntInt1 = v.getPuntosInt01();
				String puntInt2 = v.getPuntosInt02();
				String puntInt3 = v.getPuntosInt03();
				String fecha = v.getFecha();
				Random rnd = new Random();
				String rutaID= Integer.toString(rnd.nextInt());
				
				r.setIdRuta(rutaID);
				r.setViaje(v.getViajeID());
				int numPas = v.getPasajeros().size();
		%>
		<tr>
			<td align="center"><%=v.getViajeID()%> </td>
			<td align="center"><%=origenPasajero%> </td>
			<td align="center"><%=destinoPasajero%> </td>
			<td align="center"><%=fecha%> </td>
			<td align="center"><%=numPas%> </td>
			<td align="center">
				<a href="FrontController?res=unirse.jsp?vid=<%=v.getViajeID()%>">
					<img alt="Unirse" src="images/confirmar.jpg"></img>
				</a>
			</td>
		<%
			}
		}
		
		%>
			
		</tr>
	</table>
	<table id="botonVolverBuscar">
		<tr>
			<td><a class=enlaceboton href="FrontController?res=busquedaViajePasajero.jsp">VOLVER A BUSCAR</a></td>
		</tr>
	</table>
</div>
</body>
</html>
