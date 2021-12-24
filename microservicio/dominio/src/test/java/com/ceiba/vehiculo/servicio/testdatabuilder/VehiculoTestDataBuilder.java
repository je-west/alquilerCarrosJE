package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

import java.time.LocalDateTime;

public class VehiculoTestDataBuilder {

    private Long id;
    private String placa;
    private String marca;
    private String estado;
    private LocalDateTime fechaCreacion;

    public VehiculoTestDataBuilder() {
        this.id = Long.parseLong("123456");
        this.placa = "ABC123";
        this.marca = "ABCMarca";
        this.estado = "Disponible";
        this.fechaCreacion = LocalDateTime.now();;
    }

    public VehiculoTestDataBuilder conPlaca(){
        this.placa = placa;
        return this;
    }

    public VehiculoTestDataBuilder conMarca(){
        this.marca = marca;
        return this;
    }

    public VehiculoTestDataBuilder conEstado(){
        this.estado = estado;
        return this;
    }

    public VehiculoTestDataBuilder conFechaCreacion(){
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Vehiculo build() {
        return new Vehiculo(id, placa, marca, estado,fechaCreacion);
    }

}
