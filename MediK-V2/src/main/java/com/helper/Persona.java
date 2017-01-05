package com.helper;

import java.util.List;

public class Persona {
	private String curp;
	private String nombre;
	private String apellido_p;
	private String apellido_m;
	private String correo;
	private String fecha_n;
	private String pass;
	private String rol;
	
	public Persona() {}
	
	public Persona(String rol)
	{
		this.rol = rol;
	}
	
	public Persona(String curp, String nombre, String apellido_p, String apellido_m, String correo, String fecha_n, String pass, String rol)
	{
		this.curp = curp;
		this.nombre = nombre;
		this.apellido_p = apellido_p;
		this.apellido_m = apellido_m;
		this.correo = correo;
		this.fecha_n = fecha_n;
		this.pass = pass;
		this.rol = rol;
	}
	
	// get set curp
	public String getCurp()
	{
		return this.curp;
	}
	
	public void setCurp(String curp)
	{
		this.curp = curp;
	}
	
	// get set nombre
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	// get set apellido_p
	public String getApellido_p()
	{
		return this.apellido_p;
	}
	
	public void setApellido_p(String apellido_p)
	{
		this.apellido_p = apellido_p;
	}
	
	// get set apellido_m
	public String getApellido_m()
	{
		return this.apellido_m;
	}
	
	public void setApellido_m(String apellido_m)
	{
		this.apellido_m = apellido_m;
	}
	
	// get set correo
	public String getCorreo()
	{
		return this.correo;
	}
	
	public void setCorreo(String correo)
	{
		this.correo = correo;
	}
	
	// get set fecha_n
	public String getFecha_n()
	{
		return this.fecha_n;
	}
	
	public void setFecha_n(String fecha_n)
	{
		this.fecha_n = fecha_n;
	}
	
	// get set pass
	public String getPass()
	{
		return this.pass;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
	public void insertarPersona()
	{
		String consultaSQL = "set datestyle to 'European'; insert into " + this.rol + " (curp, nombre, apellido_p, apellido_m, correo, fecha_n, pass) values";
		consultaSQL += " ('" + this.curp + "', '" + this.nombre + "', '" + this.apellido_p + "', '" + this.apellido_m + "', '" + this.correo + "', '" + this.fecha_n + "', '" + this.pass + "')";
		DataBaseHelper<Persona> dbh = new DataBaseHelper<Persona>();
		dbh.modificarRegistro(consultaSQL);
	}
	
	public static List<Persona> loginPersona(String correo, String pass)
	{
		String consultaSQL = "select curp,nombre,apellido_p,apellido_m,correo,fecha_n from medico where correo = '" + correo + "' and pass = '" + pass + "'";
		consultaSQL += " union select curp,nombre,apellido_p,apellido_m,correo,fecha_n from paciente where correo = '" + correo + "' and pass = '" + pass + "'";
		DataBaseHelper<Persona> dbh = new DataBaseHelper<Persona>();
		List<Persona> persona = dbh.selecionarRegitros(consultaSQL, Persona.class);
		return persona;
	}
}