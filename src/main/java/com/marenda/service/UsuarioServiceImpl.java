package com.marenda.service;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marenda.model.Orden;
 
import com.marenda.repository.IOrdenRepository;
 

@Service
public class UsuarioServiceImpl implements IOrdenService {

	@Autowired
	private IOrdenRepository ordenRepository;

	@Override
	public Orden save(Orden orden) {
	 
		return ordenRepository.save(orden);
	}

	@Override
	public List<Orden> fiNdAll() {
		// TODO Auto-generated method stub
		return ordenRepository.findAll();
	}

	 
}
