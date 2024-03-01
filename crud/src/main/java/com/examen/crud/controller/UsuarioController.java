package com.examen.crud.controller;

import com.examen.crud.entity.Usuario;
import com.examen.crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping("/agregarusr")
    public Usuario agregarUsr(@RequestBody Usuario user){
        return service.guardarUsuario(user);
    }

    @PostMapping("/agregarusuarios")
    public List<Usuario> agregarUsuario(@RequestBody List<Usuario> users){
        return service.guardarUsuarios(users);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios(){
        return service.obtenerUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario listarUsuarioId(@PathVariable Long id){
        return service.obtenerUsuarioPorId(id);
    }

    @PutMapping("/actualizar")
    public Usuario actualizarUsr(@RequestBody Usuario user){
        return service.actualizarUsuario(user);
    }

    @DeleteMapping("/eliminar/{id}")
    public String actualizarUsuario(@PathVariable Long id){
        return service.eliminarUsuario(id);
    }

}
