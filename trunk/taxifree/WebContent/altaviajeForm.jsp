<%@ page language="java" import="domain.*,java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>AltaViaje Conductor</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>

<form action="FrontController?res=altaviaje.jsp" method="post" name="formAltaViaje">
<table>
<tr>
<td>
<label for="from">Desde:</label>
</td>
<td>
<input class="mayusculas" type="text" size="20" id="fromAddress" name="desde" value="SEVILLA"/>

</td>
<td>
<p>
<label for="toAddress">Hasta:</label>
</td>
<td>
<input class="mayusculas" type="text" size="20" id="toAddress" name="hasta" value="SANTANDER"/>

</td>
<td>

<label for="date">Fecha:</label>
</td>
<td>
<input size="10" id="date" name="date" value="30/06/2010" type="text"></input>

</td>
</tr>
<tr><td>

<label for="pto01">Parada  1:</label>
</td>
<td>
<input class="mayusculas" type="text" size="20" id="pto01" name="pto01" value="CACERES"/>

</td>
<td>

<label for="pto02">Parada  2:</label>
</td>
<td>
<input class="mayusculas" type="text" size="20" id="pto02" name="pto02" value="SALAMANCA"/>

</td>
<td>

<label for="pto03">Parada  3:</label>
</td>
<td>
<input class="mayusculas" type="text" size="20" id="pto03" name="pto03" value="VALLADOLID"/>

</td>
</tr>
<tr>
<td colspan="3" />
<td>

<input name="submit" type="submit" value="Alta Viaje" />
</td>
<td colspan="2" />
</tr>
</table>
</form>

</body>
</html>