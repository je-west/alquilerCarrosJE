package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReservaCotizacion;

import java.time.LocalDateTime;

public class ComandoReservaCotizacionTestBuilder {

    private Long idVehiculo;
    private LocalDateTime fechaInicioReserva;
    private LocalDateTime fechaFinRerserva;

    public ComandoReservaCotizacionTestBuilder() {
        this.idVehiculo = 1L;
        this.fechaInicioReserva = LocalDateTime.of(2021, 12, 25, 00, 00);;
        this.fechaFinRerserva = LocalDateTime.of(2021, 12, 29, 00, 00);
    }

    public ComandoReservaCotizacion build(){
        return new ComandoReservaCotizacion(idVehiculo, fechaInicioReserva, fechaFinRerserva);
    }
}
