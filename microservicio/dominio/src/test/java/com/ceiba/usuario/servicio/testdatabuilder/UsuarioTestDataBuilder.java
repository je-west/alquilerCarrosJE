package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
    private String cedula;
    private String telefono;
    private LocalDateTime fecha;

    public UsuarioTestDataBuilder() {
        Long id = 1L;
        nombreUsuario = "1234";
        cedula = "12345";
        telefono = "12345";
        fecha = LocalDateTime.now();
    }

    public UsuarioTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public UsuarioTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fecha = fechaCreacion;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public Usuario build() {
        return new Usuario(id, nombreUsuario, cedula, telefono,fecha);
    }
}
