package com.concess.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concess.api.dao.UsuarioDAO;
import com.concess.api.models.Usuario;

@RestController
@RequestMapping("usuarios")
public class UsuarioREST {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	// Metodos HTTP localhost:8083/usuarios/guardar
	@PostMapping("/guardar")
	public void guardar(Usuario usuario) {
		usuarioDAO.save(usuario);
	}
}
