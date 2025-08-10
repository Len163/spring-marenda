package com.marenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marenda.model.Orden;
import com.marenda.model.Usuario;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {

	List<Orden> findByUsuario(Usuario usuario);
}
