package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {

    private Long id;
    private Long idVehiculo;
    private Long idUsuario;
    private LocalDateTime fechaInicioReserva;
    private LocalDateTime fechaFinRerserva;

}