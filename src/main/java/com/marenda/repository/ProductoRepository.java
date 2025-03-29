package com.marenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marenda.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	

}
