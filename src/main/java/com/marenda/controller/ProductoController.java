package com.marenda.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marenda.model.Producto;
import com.marenda.model.Usuario;
import com.marenda.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String show() {
		return "productos/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	
	/**
	 * @param producto
	 * @return
	 */
	@PostMapping("/save")
	public String save(Producto producto) {
		LOGGER.info("este es objeto de producto{}",producto);
		Usuario U = new Usuario(1, "", "", "", "", "", "", "");
		producto.setUsuario(U);
		productoService.save(producto);
		
		
		return "redirect:/productos";
	}
}
