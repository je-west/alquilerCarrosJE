package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDateTime;

public class ReservaTestDataBuilder {

    private Long id;
    private Long idVehiculo;
    private Long idUsuario;
    private Double precioTotalReservaCOP;
    private Double precioTotalReservaUS;
    private LocalDateTime fechaInicioReserva;
    private LocalDateTime fechaFinRerserva;
    private LocalDateTime fechaCreacion;

    public ReservaTestDataBuilder(){
        id = Long.parseLong("123456");
        idVehiculo = Long.parseLong("123456");
        idUsuario = Long.parseLong("123456");

        fechaInicioReserva = LocalDateTime.now();
        fechaFinRerserva = LocalDateTime.now();
        fechaCreacion = LocalDateTime.now();
    }

    public ReservaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public ReservaTestDataBuilder conIdVehiculo(Long idVehiculo){
        this.idVehiculo = idVehiculo;
        return this;
    }

    public ReservaTestDataBuilder conIdUsuario(Long idUsuario){
        this.idUsuario = idUsuario;
        return this;
    }

    public ReservaTestDataBuilder conFechaInicioReserva(LocalDateTime fechaInicioReserva){
        this.fechaInicioReserva = fechaInicioReserva;
        return this;
    }

    public ReservaTestDataBuilder confechaFinRerserva(LocalDateTime fechaFinRerserva){
        this.fechaFinRerserva = fechaFinRerserva;
        return this;
    }

    public ReservaTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion){
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Reserva build() {
        return new Reserva(id, idVehiculo, idUsuario, precioTotalReservaCOP, precioTotalReservaUS,fechaInicioReserva, fechaFinRerserva, fechaCreacion);
    }
}
