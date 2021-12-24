package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class ReservaTestDataBuilder {

    private Long id;
    private Long idVehiculo;
    private Long idUsuario;
    private LocalDateTime fechaInicioReserva;
    private LocalDateTime fechaFinRerserva;

    public ReservaTestDataBuilder(){
        id = Long.parseLong("123456");
        idVehiculo = Long.parseLong("123456");
        idUsuario = Long.parseLong("123456");
        fechaInicioReserva = LocalDateTime.now();
        fechaFinRerserva = LocalDateTime.now();
    }

    public ReservaTestDataBuilder conIdVehiculo(){
        this.idVehiculo = idVehiculo;
        return this;
    }

    public ReservaTestDataBuilder conIdUsuario(){
        this.idUsuario = idUsuario;
        return this;
    }

    public ReservaTestDataBuilder conFechaInicioReserva(){
        this.fechaInicioReserva = fechaInicioReserva;
        return this;
    }

    public ReservaTestDataBuilder confechaFinRerserva(){
        this.fechaFinRerserva = fechaFinRerserva;
        return this;
    }

    public Reserva build() {
        return new Reserva(id, idVehiculo, idUsuario, fechaInicioReserva, fechaFinRerserva);
    }
}
