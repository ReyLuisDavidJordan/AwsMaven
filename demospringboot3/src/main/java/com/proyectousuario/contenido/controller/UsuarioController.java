package com.proyectousuario.contenido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.proyectousuario.contenido.entity.Usuario;
import com.proyectousuario.contenido.services.UsuarioService;
import com.proyectousuario.contenido.services.AwsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/apis")
public class UsuarioController {

	@Autowired
	private UsuarioService Servi;

	@Autowired
	private AwsService s3Service;

	@GetMapping("/list")
	public List<Usuario> getAll() {
		return Servi.listarTodo().stream().peek(usuario -> {
			usuario.setFotoURL(s3Service.getObjectURL(usuario.getFotoPATH()));
			usuario.setCedulaURL(s3Service.getObjectURL(usuario.getCedulaPATH()));
		}).collect(Collectors.toList());
	}


	@GetMapping("/buscar/{id}")
	public Usuario show(@PathVariable Long id) {
		return Servi.buscar(id);
	}

	
	@PostMapping("/Crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		Servi.guardar(usuario);
		usuario.setFotoURL(s3Service.getObjectURL(usuario.getFotoPATH()));
		usuario.setCedulaURL(s3Service.getObjectURL(usuario.getCedulaPATH()));
		return usuario;
	}

	
	@PutMapping("/Editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario uActual = Servi.buscar(id);
		uActual.setNombre(usuario.getNombre());
		uActual.setEmail(usuario.getEmail());
		uActual.setClave(usuario.getClave());
		uActual.setEstado(usuario.getEstado());
		return Servi.guardar(uActual);
	}

	
	@DeleteMapping("/Eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable("id") Long id) {
		Servi.Eliminar(id);
	}
}
