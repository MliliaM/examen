package com.examen.crud.controller;

import com.examen.crud.entity.Usuario;
import com.examen.crud.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UsuarioControllerTest {
    @Mock
    private UsuarioService service;

    @InjectMocks
    private UsuarioController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAgregarUsr() {
        // Arrange
        Usuario usuario = new Usuario();
        when(service.guardarUsuario(usuario)).thenReturn(usuario);

        // Act
        Usuario resultado = controller.agregarUsr(usuario);

        // Assert
        assertEquals(usuario, resultado);
    }

    @Test
    public void testAgregarUsuario() {
        // Arrange
        Usuario usr1 = new Usuario();
        usr1.setNombre("Jose");
        usr1.setCorreo("jose.1@gmail.com");
        usr1.setPassword("data1234");

        Usuario usr2 = new Usuario();
        usr2.setNombre("martha");
        usr2.setCorreo("amrtha.1@gmail.com");
        usr2.setPassword("data1234");

        List<Usuario> usuarios = Arrays.asList(usr1, new Usuario());
        when(service.guardarUsuarios(usuarios)).thenReturn(usuarios);

        // Act
        List<Usuario> resultado = controller.agregarUsuario(usuarios);

        // Assert
        assertEquals(usuarios, resultado);
    }

    @Test
    public void testListarUsuarios() {
        // Arrange
        List<Usuario> usuarios = Arrays.asList(new Usuario(), new Usuario());
        when(service.obtenerUsuarios()).thenReturn(usuarios);

        // Act
        List<Usuario> resultado = controller.listarUsuarios();

        // Assert
        assertEquals(usuarios, resultado);
    }
}