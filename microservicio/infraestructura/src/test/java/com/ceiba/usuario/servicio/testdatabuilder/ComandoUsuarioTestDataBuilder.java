package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String cedula;
    private String telefono;
    private LocalDateTime fecha;

    public ComandoUsuarioTestDataBuilder() {
        id = 1L;
        nombre = "Nombre";
        cedula = "123456789";
        telefono = "12345";
        fecha = LocalDateTime.now();
    }

    public ComandoUsuarioTestDataBuilder conID(Long id) {
        this.id = id;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }


    public ComandoUsuario build() {
        return new ComandoUsuario(id, nombre, cedula, telefono, fecha);
    }
}
