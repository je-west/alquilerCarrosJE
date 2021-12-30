package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ValidadorReserva;

public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

    private final RepositorioReserva repositorioReserva;
    private final RepositorioVehiculo repositorioVehiculo;
    private final RepositorioUsuario repositorioUsuario;
    private final ValidadorReserva validadorReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioVehiculo repositorioVehiculo, RepositorioUsuario repositorioUsuario) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioVehiculo = repositorioVehiculo;
        this.repositorioUsuario = repositorioUsuario;
        this.validadorReserva = new ValidadorReserva(this.repositorioVehiculo, this.repositorioUsuario);
    }

    public Long ejecutar(Reserva reserva){
       validarExistenciaPrevia(reserva);
       validadorReserva.validarExistenciaUsuario(reserva.getIdUsuario());
       validadorReserva.validarExistenciaVehiculo(reserva.getIdVehiculo());
       return this.repositorioReserva.crear(reserva);
    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarDisponibilidadVehiculo(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}

