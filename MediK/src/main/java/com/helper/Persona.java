package com.helper;

import java.util.List;

public interface Persona {
	public void insertarPersona();
	public List<PesonaRol> buscarPersona(String correo, String pass);
}
