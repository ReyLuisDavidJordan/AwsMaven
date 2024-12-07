package com.proyectousuario.contenido.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectousuario.contenido.dao.UsuarioDao;
import com.proyectousuario.contenido.entity.Usuario;
import com.proyectousuario.contenido.factory.UsuarioFabric;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao UDao;

    @Autowired
    private UsuarioFabric usuarioFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarTodo() {
        return (List<Usuario>) UDao.findAll();
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return UDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscar(Long id) {
        return UDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void Eliminar(Long id) {
        UDao.deleteById(id);
    }

    public Usuario CrearUsuario(String nombre, String clave, String email, Boolean estado) {
        Usuario usuario = usuarioFactory.crearUsuario(nombre, clave, email, estado);
        return guardar(usuario);
    }
}
