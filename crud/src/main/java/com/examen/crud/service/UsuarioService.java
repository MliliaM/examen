package com.examen.crud.service;

import com.examen.crud.repository.UsuarioRepository;
import com.examen.crud.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario guardarUsuario(Usuario user){
        return repository.save(user);
    }

    public List<Usuario> guardarUsuarios(List<Usuario> users){
        return repository.saveAll(users);
    }

    public List<Usuario> obtenerUsuarios(){
        return repository.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public String eliminarUsuario(Long id){
        repository.deleteById(id);
        return "Se eliminó correctamente";
    }
    public Usuario actualizarUsuario(Usuario user){
        Usuario userUpdate = repository.findById(user.getId()).orElse(null);
        userUpdate.setNombre(user.getNombre());
        userUpdate.setCorreo(user.getCorreo());
        userUpdate.setPassword(user.getPassword());
        return repository.save(userUpdate);
    }

}
