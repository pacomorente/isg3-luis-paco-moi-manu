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
<div id="content">
<table summary ="Datos del Conductor" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">

	<%
        IAccionConductor accionCond = new AccionConductorImpl();
		String pid = request.getParameter("pid");
		
		Viaje viaje= accionCond.cambiaEstadoViaje(pid);
		
		/*List<Viaje> viajemod= accionCond.verViajesAsignados(sessionUser);
		for (Iterator iter = viajemod.iterator(); iter.hasNext();) {
            Viaje viaje = (Viaje) iter.next();
            if (viaje.getViajeID()==pid){
            
                String activo="SI";
            	
                if (viaje.getAnulado()==true){
                
                	activo="NO";
                	}
            	*/
%>

				
</table>
<jsp:include page="vAsignadosConductor.jsp"></jsp:include>
</div>
</body>
</html>