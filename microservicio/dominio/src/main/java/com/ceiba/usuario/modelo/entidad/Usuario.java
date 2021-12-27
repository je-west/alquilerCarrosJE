package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_CEDULA_DEBE_TENER_UNA_LONGITUD_MAXIMA = "La cedula debe tener una longitud maxima de %s";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private static final int LONGITUD_MAXIMA_CEDULA = 12;

    private Long id;
    private String nombre;
    private String cedula;
    private String telefono;
    private LocalDateTime fechaCreacion;

    public Usuario(Long id, String nombre, String cedula, String telefono, LocalDateTime fechaCreacion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarLongitudMaxima(cedula, LONGITUD_MAXIMA_CEDULA, String.format(LA_CEDULA_DEBE_TENER_UNA_LONGITUD_MAXIMA, LONGITUD_MAXIMA_CEDULA));
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fechaCreacion = fechaCreacion;
    }

}
