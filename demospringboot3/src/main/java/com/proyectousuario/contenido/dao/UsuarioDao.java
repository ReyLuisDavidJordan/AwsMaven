package com.proyectousuario.contenido.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyectousuario.contenido.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{

}

