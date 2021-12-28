package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

import java.time.LocalDateTime;

public class VehiculoTestDataBuilder {

    private Long id;
    private String placa;
    private String marca;
    private String referencia;
    private String estado;
    private Double precioDia;
    private LocalDateTime fechaCreacion;

    public VehiculoTestDataBuilder() {
        this.id = Long.parseLong("123456");
        this.placa = "ABC123";
        this.marca = "ABCMarca";
        this.referencia = "ABCReferencia";
        this.precioDia = 100000.00;
        this.estado = "Disponible";
        this.fechaCreacion = LocalDateTime.now();;
    }

    public VehiculoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public VehiculoTestDataBuilder conPlaca(String placa){
        this.placa = placa;
        return this;
    }

    public VehiculoTestDataBuilder conMarca(String marca){
        this.marca = marca;
        return this;
    }

    public VehiculoTestDataBuilder conEstado(String estado){
        this.estado = estado;
        return this;
    }

    public VehiculoTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion){
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Vehiculo build() {
        return new Vehiculo(id, placa, marca, referencia, estado, precioDia,fechaCreacion);
    }

}
