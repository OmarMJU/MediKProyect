<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.helper.*" %>
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
               String correo = request.getParameter("correo");
               String date_n = request.getParameter("date_n");
               String curp = request.getParameter("curp");
               String pass = request.getParameter("pass");
               String pass_conf = request.getParameter("pass_conf");
               
               if(request.getParameter("rol_n").equals("Paciente"))
               {
            	   Paciente paciente = new Paciente(nombre, apellido_p, apellido_m, correo, date_n, curp, pass);
            	   paciente.insertarPersona();
               }
               else if(request.getParameter("rol_n").equals("Medico"))
               {
            	   Medico medico = new Medico(nombre, apellido_p, apellido_m, correo, date_n, curp, pass);
            	   medico.insertarPersona();
               }
               %>
	</body>
</html>