package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private Long idVehiculo;
    private Long idUsuario;
    private Double precioTotalReservaCOP;
    private Double precioTotalReservaUS;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinRerserva;
    private LocalDateTime fechaCreacion;

    public ComandoReservaTestDataBuilder() {
        this.id = 1L;
        this.idVehiculo = Long.parseLong("1");
        this.idUsuario = Long.parseLong("1");
        this.precioTotalReservaCOP = 400000.00;
        this.precioTotalReservaUS = 200.00;
        this.fechaInicioReserva = LocalDate.now();;
        this.fechaFinRerserva = LocalDate.now();;
    }

    public ComandoReservaTestDataBuilder conIdVehiculo(Long idVehiculo){
        this.idVehiculo = idVehiculo;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdUsuario(Long idUsuario){
        this.idUsuario = idUsuario;
        return this;
    }

    public ComandoReservaTestDataBuilder conFechaInicio(LocalDate fechaInicioReserva){
        this.fechaInicioReserva = fechaInicioReserva;
        return this;
    }


    public ComandoReserva build(){
        return new ComandoReserva(id, idVehiculo, idUsuario, precioTotalReservaCOP, precioTotalReservaUS,fechaInicioReserva, fechaFinRerserva, fechaCreacion);
    }
}
