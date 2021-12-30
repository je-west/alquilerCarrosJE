package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;



public class ValidadorReserva {

    private static final String EL_CLIENTE_QUE_INTENTA_REALIZAR_LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "El usuario que realizar la reserva no existe en el sistema";
    private static final String EL_VEHICULO_QUE_INTENTA_RESERVAR_NO_EXISTE_EN_EL_SISTEMA = "La vehiculo que intenta reservar no existe en el sistema";

    private final RepositorioVehiculo repositorioVehiculo;
    private final RepositorioUsuario repositorioUsuario;

    public ValidadorReserva(RepositorioVehiculo repositorioVehiculo, RepositorioUsuario repositorioUsuario) {
        this.repositorioVehiculo = repositorioVehiculo;
        this.repositorioUsuario = repositorioUsuario;
    }

    public void validarExistenciaUsuario(Long id){
        boolean existe = this.repositorioUsuario.existePorId(id);
        if (!existe) {
            throw new ExcepcionReserva(EL_CLIENTE_QUE_INTENTA_REALIZAR_LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    public void validarExistenciaVehiculo(Long id){
        boolean existe = this.repositorioVehiculo.existePorId(id);
        if (!existe) {
            throw new ExcepcionReserva(EL_VEHICULO_QUE_INTENTA_RESERVAR_NO_EXISTE_EN_EL_SISTEMA);
        }else {

        }
    }

    public void validarDisponibilidadVehiculo(Long id){
        boolean existe = this.repositorioVehiculo.existePorId(id);
        if (!existe) {
            throw new ExcepcionReserva(EL_VEHICULO_QUE_INTENTA_RESERVAR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
