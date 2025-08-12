package com.marenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marenda.model.Producto;
import com.marenda.service.IUsuarioService;
import com.marenda.service.ProductoService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	@GetMapping("")
	public String home(Model  model) {
		List<Producto> productos=productoService.findAll();
		model.addAttribute("productos", productos);
		
		return "administrador/home";
	}
	
	@GetMapping("/usuarios") 
	public String usuarios(Model model) {
		//meotdo para traer al path adminisrador/usuarios  
		model.addAttribute("usuarios", usuarioService.findAll());
		return"administrador/usuarios";
	}
	
}
