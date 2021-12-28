package com.ceiba.vehiculo.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Vehiculo {

    private static final String SE_DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO = "Se debe ingresar la placa del vehiculo";
    private static final String SE_DEBE_INGRESAR_LA_MARCA_DEL_VEHICULO = "Se debe ingresar la marca del vehiculo";
    private static final String SE_DEBE_INGRESAR_LA_REFERENCIA_DEL_VEHICULO = "Se debe ingresar la referencia del vehiculo";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA_DEL_VEHICULO = "Se debe ingresar el precio por dia del vehiculo";
    private static final String LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "La placa debe tern una longitud igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";

    private static final int LONGITUD_PLACA = 6;

    private Long id;
    private String placa;
    private String marca;
    private String referencia;
    private String estado;
    private Double precioDia;
    private LocalDateTime fechaCreacion;

    public Vehiculo(Long id, String placa, String marca,String referencia, String estado, Double precioDia,LocalDateTime fechaCreacion){
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA_DEL_VEHICULO);
        validarLongitudcCaracteres(placa, LONGITUD_PLACA+1, String.format(LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A,LONGITUD_PLACA));
        validarObligatorio(marca, SE_DEBE_INGRESAR_LA_MARCA_DEL_VEHICULO);
        validarObligatorio(referencia, SE_DEBE_INGRESAR_LA_REFERENCIA_DEL_VEHICULO);
        validarObligatorio(precioDia, SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA_DEL_VEHICULO);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.referencia = referencia;
        this.estado = estado;
        this.precioDia = precioDia;
        this.fechaCreacion = fechaCreacion;
    }


}
