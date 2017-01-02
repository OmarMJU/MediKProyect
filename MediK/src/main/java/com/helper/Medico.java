package com.helper;

import java.util.List;
//import org.springframework.format.annotation.DateTimeFormat;

public class Medico extends PesonaRol implements Persona {
	
	public Medico(){}
	
	public Medico(String curp, String nombre, String apellido_p, String apellido_m, String correo, String date_n, String pass)    
	{
		super(curp,nombre, apellido_p, apellido_m, correo, date_n, pass);
	}
	
	public void insertarPersona()
	{
		String consultaSQL = "insert into medico (curp, nombre, apellido_p, apellido_m, correo, fecha_n, pass) values";
		consultaSQL += "('" + super.getCurp() + "', '" + super.getNombre() + "', '" + super.getApellidoP() + "', '" + super.getApellidoM() + "','" + super.getCorreo() + "','" + super.getDateN() + "', '" + super.getPass() + "')";
		DataBaseHelper<PesonaRol> dbh = new DataBaseHelper<PesonaRol>();
		dbh.modificarRegistro(consultaSQL);
	}
	
	public List<PesonaRol> buscarPersona(String correo, String pass)
	{
		String consultaSQL = "select curp, nombre, apellido_p, apellido_m, correo, fecha_n from medico where medico.correo='" + correo + "' and medico.pass = '" + pass + "' union select curp_p, nombre, apellido_p, apellido_m, correo, fecha_n from paciente where paciente.correo = '" + correo + "' and paciente.pass = '" + pass+ "'";
		DataBaseHelper<PesonaRol> dbh = new DataBaseHelper<PesonaRol>();
		List<PesonaRol> listaPersonas = dbh.selecionarRegitros(consultaSQL, PesonaRol.class);
		return listaPersonas;
	}
}