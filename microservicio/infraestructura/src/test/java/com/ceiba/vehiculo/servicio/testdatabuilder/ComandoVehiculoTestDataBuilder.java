package com.ceiba.vehiculo.servicio.testdatabuilder;

import com.ceiba.vehiculo.comando.ComandoVehiculo;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoVehiculoTestDataBuilder {

    private Long id;
    private String placa;
    private String marca;
    private String referencia;
    private String estado;
    private Double precioDia;
    private LocalDateTime fechaCreacion;

    public ComandoVehiculoTestDataBuilder() {
        placa = UUID.randomUUID().toString().substring(0, 5);
        marca = UUID.randomUUID().toString();
        referencia = UUID.randomUUID().toString();;
        estado = UUID.randomUUID().toString();
        precioDia = 100000.00;
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoVehiculoTestDataBuilder conPlaca(String placa){
        this.placa = placa;
        return this;
    }

    public ComandoVehiculo build(){
        return new ComandoVehiculo(id, placa, marca, referencia, estado, precioDia,fechaCreacion);
    }
}
