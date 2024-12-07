package com.proyectousuario.contenido.factory;

import org.springframework.stereotype.Component;

import com.proyectousuario.contenido.entity.Usuario;

@Component
public class UsuarioFabriclmpl implements UsuarioFabric {

    @Override
    public Usuario crearUsuario(String nombre, String clave, String email, Boolean estado) {
        return new Usuario(nombre, clave, email, estado);
    }
}
