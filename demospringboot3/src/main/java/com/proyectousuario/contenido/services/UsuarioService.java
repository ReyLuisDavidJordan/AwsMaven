package com.proyectousuario.contenido.services;

import java.util.List;

import com.proyectousuario.contenido.entity.Usuario;

public interface UsuarioService {
    public List<Usuario> listarTodo();
    
    public Usuario guardar(Usuario usuario);
    
    public Usuario buscar(Long id);
    
    public void Eliminar(Long id);
    
    public Usuario CrearUsuario(String nombre, String clave, String email, Boolean estado); 
}
