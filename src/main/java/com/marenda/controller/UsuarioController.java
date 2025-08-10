package com.marenda.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marenda.model.Orden;
import com.marenda.model.Usuario;
import com.marenda.service.IOrdenService;
import com.marenda.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final Logger logger= LoggerFactory.getLogger(UsuarioController.class );
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IOrdenService ordenService;
	
	@GetMapping("/registro")
	public String create() {
		
		return "usuario/registro";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		
		logger.info("Usuario registro: {}" , usuario);
		usuario.setTipo("USER");
		usuarioService.save(usuario);
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "usuario/login";
	}
	
	@PostMapping("/acceder")
	public String accerder(Usuario usuario, HttpSession session) {
		logger.info(" accesos: {}" , usuario);
		Optional<Usuario> user =usuarioService.findByEmail(usuario.getEmail());
		//logger.info("usuario de db: {}", user.get());
		
		if (user.isPresent()) {
			session.setAttribute("idusuario", user.get().getId());
			if (user.get().getTipo().equals("ADMIN")) {
				return"redirect:/administrador";
			}else { 
				return "redirect:/";
			} 
		}else {
			logger.info("usuario no existe");
		}
	 		
		
		return "redirect:/";
	}
	
	@GetMapping("/compras")
	public String obtenerCompras(Model model, HttpSession session) {
		model.addAttribute("session", session.getAttribute("idusuario"));
		Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		List<Orden> ordenes =ordenService.findByUsuario(usuario);
		
		model.addAttribute("ordenes", ordenes);
		
		return "usuario/compras";
	}	
	
	
}
