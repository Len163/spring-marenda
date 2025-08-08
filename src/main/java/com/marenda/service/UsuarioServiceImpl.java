package com.marenda.service;

import java.util.List;
 import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.marenda.model.Usuario;
 
import com.marenda.repository.IUsuarioRepository;
 

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findById(Integer id) { 
		return usuarioRepository.findById(id);
	}

 
 }
