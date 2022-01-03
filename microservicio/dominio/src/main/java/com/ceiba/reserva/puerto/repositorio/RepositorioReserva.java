package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDateTime;

public interface RepositorioReserva {
    /**
     * Permite crear una reserva
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);

    /**
     * Permite validar si el vehiculo esta disponible para reservar entre dos fechas
     * @param idVehiculo,
     * @param fechaInicio
     * @return si existe o no
     */
    boolean disponibilidadVehiculo(Long idVehiculo, LocalDateTime fechaInicio);
}
