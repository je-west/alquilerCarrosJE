package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoReserva {
    private Long id;
    private Long idVehiculo;
    private Long idUsuario;
    private Double precioTotalReservaCOP;
    private Double precioTotalReservaUS;
    private LocalDateTime fechaInicioReserva;
    private LocalDateTime fechaFinReserva;
    private LocalDateTime fechaCreacion;
}


