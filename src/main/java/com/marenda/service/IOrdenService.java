package com.marenda.service;

import java.util.List;

import com.marenda.model.Orden;
import com.marenda.model.Usuario;

public interface IOrdenService    {
	
	List<Orden> fiNdAll(); 
	Orden save (Orden orden);
	String generarNumeroOrden();
	List<Orden> findByUsuario(Usuario usuario);
}
