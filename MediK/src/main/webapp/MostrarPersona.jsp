<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.helper.Medico" %>
<%@ page import="com.helper.PesonaRol" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			String correo = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			List<PesonaRol> listaPersona = null;
			
			PesonaRol persona = new PesonaRol();
			listaPersona =  persona.logingPersona(correo, pass);
				
				for(PesonaRol lista:listaPersona)
				{ %>
					
					<h2>Bienvenido: <%=lista.getNombre()%></h2>
				<%}
			%>

	</body>
</html>