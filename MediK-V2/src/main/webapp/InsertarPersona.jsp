<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.helper.Persona"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%
    String nombre = request.getParameter("nombre");
    String apellido_p = request.getParameter("apellido_p");
    String apellido_m = request.getParameter("apellido_m");
    String date_n = request.getParameter("date_n");
    String correo = request.getParameter("correo");
    String curp = request.getParameter("curp");
    String pass = request.getParameter("pass");
    String rol = null;
    
    if(request.getParameter("rol_n").equals("medico"))
    {
    	rol = "medico";
    }
    if(request.getParameter("rol_n").equals("paciente"))
    {
    	rol = "paciente";    
    }
    
    Persona persona = new Persona(curp, nombre, apellido_p, apellido_m, correo, date_n, pass, rol);
    persona.insertarPersona();
    response.sendRedirect("login.html");
	%>
	</body>
</html>