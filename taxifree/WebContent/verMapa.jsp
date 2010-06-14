<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mapa de la ruta</title>
<%
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");
	String origen = request.getParameter("origen");
	String destino = request.getParameter("destino");
%>
<link rel="stylesheet" type="text/css" href="estilo.css" />
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAcLh6AS0I-FssUKcFU9GPZRTIc-IpND3enRGJyyNbCDc9zQv35RTnJJ6dLi5WkJ8XfZvrhYm9ltpJsA"
type="text/javascript"></script>
<script type="text/javascript">

var map;
var gdir;
var geocoder = null;
var addressMarker;


function initialize() {
	if (GBrowserIsCompatible()) {
		map = new GMap2(document.getElementById("mapa_ruta"));
		map.addControl(new GLargeMapControl());
		map.addControl(new GMapTypeControl());
		gdir = new GDirections(map, document.getElementById("direcciones"));
		GEvent.addListener(gdir, "load", onGDirectionsLoad);
		GEvent.addListener(gdir, "error", handleErrors);
		setDirections("<%=origen%>", "<%=destino%>", "es");
	}
}

function setDirections(fromAddress, toAddress, locale) {
	gdir.load("from: " + fromAddress + " to: " + toAddress,{ "locale": locale });
}

function handleErrors(){
	if (gdir.getStatus().code == G_GEO_UNKNOWN_ADDRESS)
		alert("Dirección no disponible.\nError code: " + gdir.getStatus().code);
	else if (gdir.getStatus().code == G_GEO_SERVER_ERROR)
		alert("A geocoding or directions request could not be successfully processed, yet the exact reason for the failure is not known.\n Error code: " + gdir.getStatus().code);
	else if (gdir.getStatus().code == G_GEO_MISSING_QUERY)
		alert("The HTTP q parameter was either missing or had no value. For geocoder requests, this means that an empty address was specified as input. For directions requests, this means that no query was specified in the input.\n Error code: " + gdir.getStatus().code);
	else if (gdir.getStatus().code == G_GEO_BAD_KEY)
		alert("The given key is either invalid or does not match the domain for which it was given. \n Error code: " + gdir.getStatus().code);
	else if (gdir.getStatus().code == G_GEO_BAD_REQUEST)
		alert("A directions request could not be successfully parsed.\n Error code: " + gdir.getStatus().code);
	else alert("An unknown error occurred.");
}
function onGDirectionsLoad(){
}

</script>
</head>
<body onload="initialize()" onunload="GUnload()">
<div id="top">
	<jsp:include  page="head.html"/>
	<jsp:include  page="cabeceraPasajero.jsp"/>
</div>
<div id="mapa">
	<table>
		<tr>
			<td>
				<div id="mapa_ruta" align="center" style="width: 710px; height: 300px; border: 4px solid #FF6600;"></div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>