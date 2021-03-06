package com.ceiba.vehiculo.puerto.repositorio;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public interface RepositorioVehiculo {
    /**
     * Permite crear un vehiculo
     * @param vehiculo
     * @return el id generado
     */
    Long crear(Vehiculo vehiculo);

    /**
     * Permite validar si existe un vehiculo con un nombre
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);

    /**
     * Permite validar si existe un vehiculo con un nombre excluyendo un id
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
