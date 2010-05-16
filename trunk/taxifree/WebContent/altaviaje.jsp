<%@ page language="java" import="domain.*,java.util.*,utils.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

// me va a permitir introductir un trayecto
IAccionConductor accionCond = new AccionConductorImpl();


if(sessionRoute == null)
{
		//saco un mapa con los parametros del formulario
		Map datosForm = request.getParameterMap();

		//datos relativos a la tarjeta de crédito
		String fromForm = request.getParameter("from");
		String toForm = request.getParameter("to");
		String delimiter=",";
		String [] fieldsFrom= fromForm.split(delimiter,-1);
		
		String fromLocalidad=fieldsFrom[0];
		String fromProvincia=fieldsFrom[1];
		String [] fieldsTo= toForm.split(delimiter, -1);
		String toLocalidad=fieldsTo[0];
		String toProvincia= fieldsTo[1];
		String dateForm = request.getParameter("date");
		String descForm = request.getParameter("descripcion");
		String usuario= request.getParameter("u");
		Integer ocupadasForm= Integer.parseInt(request.getParameter("ocupadas"));
		
UsuarioStore sessionUserStore= (UsuarioStore)session.getAttribute("session.userStore");

	List<Usuario> usuarios= sessionUserStore.getInstance().getUsuarios();
	for (Iterator iter = usuarios.iterator(); iter.hasNext();) {
	Usuario u = (Usuario) iter.next();

	if(u.getNombre().equals(usuario)){
	
	
		
		
		if(validar(datosForm))
		{

			Trayecto t = new Trayecto();
			t.setDescripcion(descForm);
			t.setFechaTrayecto(dateForm);
			t.setLocalidadOrigen(fromLocalidad);
			t.setProvinciaOrigen(fromProvincia);
			t.setLocalidadDestino(toLocalidad);
			t.setProvinciaDestino(toProvincia);
			t.setPropietario(u);
			t.setNumeroPlazasOcupadas(ocupadasForm);
			
			atr.añadirTrayecto(t);
			
			mensaje = new String("SU ORDEN HA SIDO PROCESADA CON ÉXITO");
		}
		else
		{
			mensaje = new String("FALTAN CAMPOS POR RELLENAR");
		}

	}
	}

}
else// no tiene orden o no tiene producto
{
		mensaje = new String ("NO TIENE NINGÚN ELEMENTO SELECCIONADO EN SU PEDIDO");
}
	

%>
<p>
<%=mensaje%>
</p>
</body>
</html>