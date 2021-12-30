package com.ceiba.vehiculo.puerto.dao;

import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;

import java.util.List;

public interface DaoVehiculo {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoVehiculo> listar();

    /**
     * Permite consultar un vehiculo
     * @return un vehiculo
     */
    List<DtoVehiculo>  consultarVehiculo(Long idVehiculo);
}
