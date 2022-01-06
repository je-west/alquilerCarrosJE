package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReservaCotizacion {
    private Long idVehiculo;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinReserva;
}
