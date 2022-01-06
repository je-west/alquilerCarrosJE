package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {

    private Long id;
    private Long idVehiculo;
    private Long idUsuario;
    private Double precioTotalReservaCOP;
    private Double precioTotalReservaUS;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinReserva;
    private LocalDateTime fechaCreacion;

}
