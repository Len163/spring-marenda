package com.marenda.service;

import org.springframework.stereotype.Service;

import com.marenda.model.Orden;
import com.marenda.repository.IOrdenRepository;

@Service
public class OrdenService  implements IOrdenService {

	private IOrdenRepository ordenRepository;
	
	
	@Override
	public Orden save(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}

}
