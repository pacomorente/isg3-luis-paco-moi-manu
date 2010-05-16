<%@ page language="java" import="domain.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TAXIFREE</title>
<link rel="stylesheet" type="text/css" href="Styles/style.css" />

<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAcLh6AS0I-FssUKcFU9GPZRTIc-IpND3enRGJyyNbCDc9zQv35RTnJJ6dLi5WkJ8XfZvrhYm9ltpJsA"
type="text/javascript"></script>
<script type="text/javascript">

var map;
var gdir;
var geocoder = null;
var addressMarker;

function initialize() {
if (GBrowserIsCompatible()) {
map = new GMap2(document.getElementById("map_canvas"));
map.setCenter(new GLatLng(40.4419, -4.1419), 5);
map.setUIToDefault();
gdir = new GDirections(map, document.getElementById("directions"));
GEvent.addListener(gdir, "load", onGDirectionsLoad);
GEvent.addListener(gdir, "error", handleErrors);

//setDirections(" ", " ", "es_ES");
}
}

function setDirections(fromAddress, toAddress, locale) {
gdir.load("from: " + fromAddress + " to: " + toAddress,
{ "locale": locale });
}

function handleErrors(){
if (gdir.getStatus().code == G_GEO_UNKNOWN_ADDRESS)
alert("No corresponding geographic location could be found for one of the specified addresses. This may be due to the fact that the address is relatively new, or it may be incorrect.\nError code: " + gdir.getStatus().code);
else if (gdir.getStatus().code == G_GEO_SERVER_ERROR)
alert("A geocoding or directions request could not be successfully processed, yet the exact reason for the failure is not known.\n Error code: " + gdir.getStatus().code);

else if (gdir.getStatus().code == G_GEO_MISSING_QUERY)
alert("The HTTP q parameter was either missing or had no value. For geocoder requests, this means that an empty address was specified as input. For directions requests, this means that no query was specified in the input.\n Error code: " + gdir.getStatus().code);

// else if (gdir.getStatus().code == G_UNAVAILABLE_ADDRESS) <--- Doc bug... this is either not defined, or Doc is wrong
// alert("The geocode for the given address or the route for the given directions query cannot be returned due to legal or contractual reasons.\n Error code: " + gdir.getStatus().code);

else if (gdir.getStatus().code == G_GEO_BAD_KEY)
alert("The given key is either invalid or does not match the domain for which it was given. \n Error code: " + gdir.getStatus().code);

else if (gdir.getStatus().code == G_GEO_BAD_REQUEST)
alert("A directions request could not be successfully parsed.\n Error code: " + gdir.getStatus().code);

else alert("An unknown error occurred.");

}

function onGDirectionsLoad(){
// Use this function to access information about the latest load()
// results.

// e.g.
// document.getElementById("getStatus").innerHTML = gdir.getStatus().code;
// and yada yada yada...
}
</script>

</head>

<body onload="initialize()" onunload="GUnload()">
<div id="content">
<div id="uppad"></div>
<div id="head">

<%
String sessionUser= (String)session.getAttribute("session.user");


%>



<form id="buscador" method="get" action="" onsubmit="">
<input type="text" name="buscar" id="buscar" value="Buscar Trayecto..." />
<input name="search" type="submit" class="search" id="search" value="Buscar" />
</form>

</div>
<hr />
<div id="principal">

<div id="middle">
<br/>
<div id="map_canvas" style="width:90%;height:350px;"></div>

</div>
<div id="right">

<form action="FrontController?res=altaviaje.jsp" method="post">

<br />
<p><label for="from">&nbsp;&nbsp;Desde:&nbsp;</label>
<input type="text" size="25" id="fromAddress" name="from" value="Origen..."/>
</p>
<p>
<label for="toAddress">&nbsp;&nbsp;Hasta:&nbsp;</label>
<input type="text" size="25" id="toAddress" name="to"
value="Destino..." />
</p>
<p>
<label for="date">&nbsp;&nbsp;Fecha:&nbsp;</label>
<input type="text" size="25" id="date" name="date"
value="dd/mm/aaaa" />
</p>
<p>
<label for="ocupado">&nbsp;&nbsp;Plazas ocupadas:&nbsp;</label>
<input type="text" size="25" id="ocupadas" name="ocupadas"
value="Plazas ocupadas" />
</p>



<p>
<label for="descripcion">&nbsp;&nbsp;Descripcion:&nbsp; </label>
<textarea name="descripcion" id="descripcion" cols="20" rows="5"></textarea>
</p>

<p>
<label for="locale">&nbsp;&nbsp;Lenguaje:&nbsp;</label>
<select id="locale" name="locale">

<option value="es" selected>Espa&ntilde;ol</option>
<option value="fr">French</option>
<option value="de">German</option>
<option value="ja">Japanese</option>
<option value="en">English</option>
</select>
</p>
<p>
<input name="submit" type="submit" value="A&ntilde;adir trayecto" />
</p>


</form>
<%


%>
<!--<div id="directions" style="width:95%"></div>
-->
</div>
<div id="down">
<div id="directions" style="width:95%"></div>
</div>
</div>
<div id="footer">

</div>
</div>
</body>
</html>

