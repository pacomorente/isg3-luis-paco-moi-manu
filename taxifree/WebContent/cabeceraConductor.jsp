<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cabecera</title>
<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>
<body >
<%

	String sessionUser= (String)session.getAttribute("session.user");
%>
<div id="content">
	<table align="center">
		<tr style="height: 11px"></tr>
		<tr align="center" id="separador">
		<td colspan='6'><a class=enlaceboton href="FrontController?res=conductor.jsp">Menú Conductor</a></td>
		<td colspan='6'><a class=enlaceboton href="FrontController?res=acciones.jsp">Menú Usuario</a></td>
		</tr>
		<tr style="height: 15px"></tr>
	</table>
	<table id="nickconductor" align="center">
	<tr valign ="middle" align="center">
		<td  colspan="3" >
			<b>CONDUCTOR: </b><%=sessionUser%>
			<br>
		</td>
	</tr>
	</table>
</div>
</body>
</html>