<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cambio de la Ruta</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
<%!
//función de validación simple que permite mirar si se han rellenado todos los campos
private boolean validar(Map elements)
{
	boolean valido = true;
	if(elements != null)
	{
	Collection parameters = elements.values();
	Iterator iter = parameters.iterator();
	
	while (iter.hasNext() && valido) {
		String[] element = (String[]) iter.next();
		for (int i = 0; i < element.length; i++) {
			if(! (element[i].length() > 0)){
				valido = false;
			}
		}
	}
	}
	return valido;
}
%>
<%
	String mensaje = new String();
	//saco un mapa con los parametros del formulario
	Map datosForm = request.getParameterMap();
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");

	// me va a permitir introductir una ruta
	IAccionPasajero accionPas = new AccionPasajeroImpl();

	//datos relativos a la Ruta
	String rutaID = request.getParameter("rid");
	String desdeForm = request.getParameter("desde");
	String hastaForm = request.getParameter("hasta");
	String fechaForm = request.getParameter("date");
			
	Ruta ruta = new Ruta();
	Set<Viaje> viajes = null;
	boolean falta = false;
	if(validar(datosForm)){
	ruta.setOrigen(desdeForm.toLowerCase());
	ruta.setDestino(hastaForm.toLowerCase());
	ruta.setFecha(fechaForm);
	Ruta rAnt = accionPas.seleccionaRuta(rutaID);
	session.setAttribute("session.rutaAnt",rAnt);
	session.setAttribute("session.ruta",ruta);
	viajes = (Set<Viaje>)accionPas.buscarViaje(ruta, sessionUser, true);
	}else{
		falta = true;
		mensaje = new String("FALTAN CAMPOS POR RELLENAR");
	}
%>
<div id="top">
	<jsp:include  page="head.html"/>
	<jsp:include  page="cabeceraPasajero.jsp"/>
</div>

<div id="aceptarCamRuta">
	<table id="tablaResultados">
		<tr valign ="middle" align="center">
			<th>Nº</th><th>ORIGEN</th><th>DESTINO</th><th>FECHA</th><th>PASAJEROS</th><th>UNIRSE A VIAJE</th>
		</tr>
		<%if(falta){%>
			<tr><td colspan = 6 align= "center"><%=mensaje%></td></tr>
		<%}else if(viajes.isEmpty()){
%>	
		<tr><td colspan = 6 align= "center">NO HAY RESULTADOS PARA SU BUSQUEDA</td></tr>
<%	
	}else{
		for(Viaje v: viajes){
			String origenPasajero = ruta.getOrigen().toUpperCase();
			String destinoPasajero = v.getDestino();
			String fecha = v.getFecha();
			int numPas = v.getPasajeros().size();
%>
		<tr>
			<td align="center"><%=v.getViajeID()%> </td>
			<td align="center"><%=origenPasajero%> </td>
			<td align="center"><%=destinoPasajero%> </td>
			<td align="center"><%=fecha%> </td>
			<td align="center"><%=numPas%> </td>
			<td align="center">
				<a href="FrontController?res=actualizarRuta.jsp?vidNuevo=<%=v.getViajeID()%>">
					<img alt="Unirse" src="images/confirmar.jpg"></img>
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