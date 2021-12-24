package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReserva {
    /**
     * Permite crear una reserva
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);

    /**
     * Permite actualizar uns reserva
     * @param reserva
     */
    void actualizar(Reserva reserva);

    /**
     * Permite eliminar uns reserva
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe uns reserva con un id
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Permite validar si existe uns reserva con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
