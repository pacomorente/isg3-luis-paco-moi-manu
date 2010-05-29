<%@ page language="java" import="domain.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TAXIFREE - Alta Viaje</title>
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

setDirections("Sevilla", "Santander", "es");

}
}

function setDirections(fromAddress, toAddress, locale) {
gdir.load("from: " + fromAddress + " to: " + toAddress,
{ "locale": locale });
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
<%
	//String nick="USER6";
	String sessionUser= (String)session.getAttribute("session.user");

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

</table>
<table summary ="Acciones del Usuario" cellSpacing="1" cellPadding="3" width="770" align="center" border="0" style="width: 475px">
	<tr valign ="middle" align="center">
		<td  colspan="3"><b>CONDUCTOR</b><br> <%=sessionUser%><br><br><br></td>
	</tr>
	</table>

<table>
<tr>
<td>
<div id="mapa_ruta" align="center" style="width: 710px; height: 300px; border: 4px solid #FF6600;"></div>
<form action="#" onsubmit="setDirections(this.from.value, this.to.value, this.locale.value); return false" name="form">

Origen: <input type="text" size="25" id="fromAddress" name="from"/ value="SEVILLA">

Destino: <input name="to" type="text" id="toAddress" size="25" value="SANTANDER"/><br>

Idioma: <select id="locale" name="locale">
<option value="es" selected>Castellano</option>
<option value="en">English</option>
<option value="fr">French</option>
<option value="de">German</option>
<option value="ja">Japanese</option>
</select>

<input type="submit" name="Submit" value="Calcular Viaje"/>

</form> 

</div>
</td>

<td>
<div id="right">

<form action="FrontController?res=altaviaje.jsp" method="post">

<br />
<p><label for="from">Desde:</label>
<input class="mayusculas" type="text" size="20" id="fromAddress" name="desde" value="SEVILLA"/>
</p>
<p>
<label for="toAddress">Hasta:</label>
<input class="mayusculas" type="text" size="20" id="toAddress" name="hasta" value="SANTANDER"/>
</p>
<p>
<label for="date">Fecha:</label>
<input size="10" id="date" name="date" value="30/06/2010" type="text"></input>
</p>
<p>
<label for="pto01">Punto Intermedio 1:</label>
<input class="mayusculas" type="text" size="20" id="pto01" name="pto01" value="CACERES"/>
</p>
<p>
<label for="pto02">Punto Intermedio 2:</label>
<input class="mayusculas" type="text" size="20" id="pto02" name="pto02" value="SALAMANCA"/>
</p>
<p>
<label for="pto03">Punto Intermedio 3:</label>
<input class="mayusculas" type="text" size="20" id="pto03" name="pto03" value="VALLADOLID"/>
</p>

<p>
<input name="submit" type="submit" value="Alta Viaje" />
</p>


</form>
</div>
<div id="testdiv1" style="position:absolute;visibility:hidden;background-color:white;layer-background-color:white;"></div>

</td>
</tr>
</table>


<div id="direcciones" style="width: 710px"></div> 
</body>
</html>

