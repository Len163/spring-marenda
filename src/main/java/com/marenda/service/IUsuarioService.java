package com.marenda.service;

import java.util.Optional;

import com.marenda.model.Usuario;

public interface IUsuarioService {

	Optional<Usuario> findById(Integer id);
	
}
