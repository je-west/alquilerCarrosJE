package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReservaCotizacion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoReservaCotizacionTestBuilder {

    private Long idVehiculo;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinRerserva;

    public ComandoReservaCotizacionTestBuilder() {
        this.idVehiculo = 1L;
        this.fechaInicioReserva = LocalDate.of(2021, 12, 25);;
        this.fechaFinRerserva = LocalDate.of(2021, 12, 29);
    }

    public ComandoReservaCotizacion build(){
        return new ComandoReservaCotizacion(idVehiculo, fechaInicioReserva, fechaFinRerserva);
    }
}
