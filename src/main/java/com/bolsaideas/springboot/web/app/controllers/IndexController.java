package com.bolsaideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({"/index", "/", "/home", ""})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola spring framework");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Camilo");
		usuario.setApellido("Osorio");
		usuario.setEmail("email@mail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: " + usuario.getNombre());
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> listarUsuarios() {
		return Arrays.asList(new Usuario("Camilo", "Osorio", "camilo@gmail.com"),
				new Usuario("Bryan", "Santiago", "bryan@gmail.com"),
				new Usuario("John", "Doe", "john@gmail.com"));
	}
	
}
