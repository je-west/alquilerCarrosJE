package com.ceiba.configuracion;

import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioCotizarReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.trm.puerto.repositorio.RepositorioTrm;
import com.ceiba.trm.servicio.ServicioConsultarTrm;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.vehiculo.servicio.ServicioCrearVehiculo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo){
        return new ServicioCrearVehiculo(repositorioVehiculo);
    }

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioVehiculo repositorioVehiculo, RepositorioUsuario repositorioUsuario){
        return new ServicioCrearReserva(repositorioReserva, repositorioVehiculo, repositorioUsuario);
    }

    @Bean
    public ServicioCotizarReserva servicioCotizarReserva(){
        return new ServicioCotizarReserva();
    }

    @Bean
    public ServicioConsultarTrm servicioConsultarTrm(RepositorioTrm repositorioTrm) {
        return new ServicioConsultarTrm(repositorioTrm);
    }


}
