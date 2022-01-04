package com.ceiba.vehiculo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;

import java.time.LocalDateTime;


public class ValidadorReserva {

    private static final String EL_CLIENTE_QUE_INTENTA_REALIZAR_LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "El usuario que realizar la reserva no existe en el sistema";
    private static final String EL_VEHICULO_QUE_INTENTA_RESERVAR_NO_EXISTE_EN_EL_SISTEMA = "La vehiculo que intenta reservar no existe en el sistema";
    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

    private final RepositorioVehiculo repositorioVehiculo;
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioReserva repositorioReserva;

    public ValidadorReserva(RepositorioVehiculo repositorioVehiculo, RepositorioUsuario repositorioUsuario, RepositorioReserva repositorioReserva) {
        this.repositorioVehiculo = repositorioVehiculo;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioReserva = repositorioReserva;
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
        }
    }

    public void validarExistenciaPreviaReserva(Long idVehiculo, LocalDateTime fechaInicioReserva) {
        boolean existe = this.repositorioReserva.disponibilidadVehiculo(idVehiculo, fechaInicioReserva);
        if(existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
