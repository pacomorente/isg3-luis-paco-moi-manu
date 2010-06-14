<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busqueda de Viaje Pasajero</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body>
<div id="top">
	<jsp:include  page="head.html"/>
	<jsp:include  page="cabeceraPasajero.jsp"/>
</div>
<div id="busquedaViaje">
	<form action="FrontController?res=buscaViaje.jsp" id="formularioPasajero" method="post">
		<label for="from" id="lfrom">Desde:</label>
		<input class="mayusculas" type="text" size="25" id="from" name="origen" value="SALAMANCA"/>
		<br></br><br></br>
		<label for="to" id="lto">Hasta:</label>
		<input class="mayusculas" type="text" size="25" id="to" name="destino" value="SANTANDER"/>
		<br></br><br></br>
		<label for="date" id="lfecha">Fecha:</label>
		<input type="text" size="25" id="date" name="date" value="30/06/2010" />
		<br></br><br></br>
		<p id="botonEnviar">
			<input name="submit" type="submit" value="Buscar" />
		</p>
	</form>
</div>
</body>
</html>