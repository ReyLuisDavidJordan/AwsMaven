package com.proyectousuario.contenido.factory;

import com.proyectousuario.contenido.entity.Usuario;

public interface UsuarioFabric {
	
	 Usuario crearUsuario(String nombre, String clave, String email, Boolean estado);

}
