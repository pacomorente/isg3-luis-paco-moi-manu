<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Alta Viaje Conductor</title>
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

// me va a permitir introductir un trayecto
IAccionConductor accionCond = new AccionConductorImpl();


		//saco un mapa con los parametros del formulario
		Map datosForm = request.getParameterMap();

		//datos relativos a la tarjeta de crédito
		String desdeForm = request.getParameter("desde");
		String hastaForm = request.getParameter("hasta");
		
		String fechaForm = request.getParameter("date");
		String punto01Form = request.getParameter("pto01");
		String punto02Form = request.getParameter("pto02");
		String punto03Form = request.getParameter("pto03");

		Random rnd = new Random();
		String viajeID= Integer.toString(rnd.nextInt());

		
		if(validar(datosForm))
		{

			Viaje viaje = new Viaje();
			viaje.setOrigen(desdeForm);
			viaje.setFecha(fechaForm);
			viaje.setDestino(hastaForm);
			viaje.setPuntosInt01(punto01Form);
			viaje.setPuntosInt02(punto02Form);
			viaje.setPuntosInt03(punto03Form);
			viaje.setViajeID(viajeID);
			viaje.setAnulado(false);
			// ID vIAJE ?? VER CÓMO AÑADIR
			
			accionCond.insertarViajeConductor(sessionUser,viaje);
			
			mensaje = new String("SU VIAJE SE HA DADO DE ALTA CORRECTAMENTE.");
		}
		else
		{
			mensaje = new String("FALTAN CAMPOS POR RELLENAR");
		}


		String mensajefinal="<script language='javascript'>alert('" + mensaje + "');</script>";
		out.println(mensajefinal);

%>
<p>

</p>
<jsp:include page="altaViajeConductor.jsp"></jsp:include>
</body>
</html>