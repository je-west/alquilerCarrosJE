package com.ceiba.configuracion;

import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.vehiculo.servicio.ServicioCrearVehiculo;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo){
        return new ServicioCrearVehiculo(repositorioVehiculo);
    }

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva){
        return new ServicioCrearReserva(repositorioReserva);
    }
	

}
