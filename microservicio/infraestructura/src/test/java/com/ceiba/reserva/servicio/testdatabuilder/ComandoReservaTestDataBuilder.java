package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.time.LocalDateTime;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private Long idVehiculo;
    private Long idUsuario;
    private LocalDateTime fechaInicioReserva;
    private LocalDateTime fechaFinRerserva;
    private LocalDateTime fechaCreacion;

    public ComandoReservaTestDataBuilder() {
        this.idVehiculo = Long.parseLong("123");
        this.idUsuario = Long.parseLong("321");
        this.fechaInicioReserva = LocalDateTime.now();;
        this.fechaFinRerserva = LocalDateTime.now();;
    }

    public ComandoReservaTestDataBuilder conIdVehiculo(){
        this.idVehiculo = idVehiculo;
        return this;
    }

    public ComandoReserva build(){
        return new ComandoReserva(id, idVehiculo, idUsuario, fechaInicioReserva, fechaFinRerserva, fechaCreacion);
    }
}
