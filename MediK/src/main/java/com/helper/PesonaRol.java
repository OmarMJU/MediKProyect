package com.helper;

import java.util.List;

public class PesonaRol {
	
	private String curp;
	private String nombre;
	private String apellido_p;
	private String apellido_m;
	private String correo;
	private String date_n;
	private String pass;
	
	public PesonaRol(){ super(); }
	
	public PesonaRol(String curp, String nombre, String apellido_p, String apellido_m, String correo, String date_n, String pass)
	{
		super();
		this.curp = curp;
		this.nombre = nombre;
		this.apellido_p = apellido_p;
		this.apellido_m = apellido_m;
		this.correo = correo;
		this.date_n = date_n;
		this.pass = pass;
	}
	
	public String getCurp() 
	{
		return this.curp;
	}
	
	public void setCurp(String curp)
	{
		this.curp = curp;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getApellidoP()
	{
		return this.apellido_p;
	}
	
	public void setApellidoP(String apellido_p)
	{
		this.apellido_p = apellido_p;
	}
	
	public String getApellidoM()
	{
		return this.apellido_m;
	}
	
	public void setApellidoM(String apellido_m)
	{
		this.apellido_m = apellido_m;
	}
	
	public String getCorreo()
	{
		return this.correo;
	}
	
	public void setCorreo(String correo)
	{
		this.correo = correo;
	}
	
	public String getDateN()
	{
		return this.date_n;
	}
	
	public void setDateN(String date_n)
	{
		this.date_n = date_n;
	}
	
	public String getPass()
	{
		return this.pass;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
	public List<PesonaRol> logingPersona(String correo, String pass)
	{
		String consultaSQL = "select curp, nombre, apellido_p, apellido_m, correo, fecha_n from medico where correo='" + correo + "' and pass = '" + pass + "' union select curp_p, nombre, apellido_p, apellido_m, correo, fecha_n from paciente where correo = '" + correo + "' and pass = '" + pass+ "'";
		DataBaseHelper<PesonaRol> dbh = new DataBaseHelper<PesonaRol>();
		List<PesonaRol> listaPersonas = dbh.selecionarRegitros(consultaSQL, PesonaRol.class);
		return listaPersonas;
	}
}
