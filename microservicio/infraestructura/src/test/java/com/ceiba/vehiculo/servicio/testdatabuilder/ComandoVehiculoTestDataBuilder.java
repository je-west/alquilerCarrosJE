package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.vehiculo.comando.ComandoVehiculo;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoVehiculoTestDataBuilder {

    private Long id;
    private String placa;
    private String marca;
    private String estado;
    private LocalDateTime fechaCreacion;

    public ComandoVehiculoTestDataBuilder() {
        placa = UUID.randomUUID().toString();
        marca = UUID.randomUUID().toString();
        estado = UUID.randomUUID().toString();
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoVehiculoTestDataBuilder conPlaca(String placa){
        this.placa = placa;
        return this;
    }

    public ComandoVehiculo build(){
        return new ComandoVehiculo(id, placa, marca, estado, fechaCreacion);
    }
}
