package com.marenda.service;

import java.util.List;

import com.marenda.model.Orden;

public interface IOrdenService    {
	
	List<Orden> fiNdAll(); 
	Orden save (Orden orden);
	String generarNumeroOrden();
}
