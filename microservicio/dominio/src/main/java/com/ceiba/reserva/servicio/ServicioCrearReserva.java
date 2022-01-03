package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.ValidadorReserva;

public class ServicioCrearReserva {

    private final RepositorioReserva repositorioReserva;
    private final RepositorioVehiculo repositorioVehiculo;
    private final RepositorioUsuario repositorioUsuario;
    private final ValidadorReserva validadorReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioVehiculo repositorioVehiculo, RepositorioUsuario repositorioUsuario) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioVehiculo = repositorioVehiculo;
        this.repositorioUsuario = repositorioUsuario;
        this.validadorReserva = new ValidadorReserva(this.repositorioVehiculo, this.repositorioUsuario, this.repositorioReserva);
    }

    public Long ejecutar(Reserva reserva){
       validadorReserva.validarExistenciaUsuario(reserva.getIdUsuario());
       validadorReserva.validarExistenciaVehiculo(reserva.getIdVehiculo());
       validadorReserva.validarExistenciaPreviaReserva(reserva.getIdVehiculo(), reserva.getFechaInicioReserva());
       return this.repositorioReserva.crear(reserva);
    }

}

