package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaRerserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearReserva implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<Long>> {

    private final FabricaRerserva fabricaRerserva;
    private final ServicioCrearReserva servicioCrearReserva;

    public ManejadorCrearReserva(FabricaRerserva fabricaRerserva, ServicioCrearReserva servicioCrearReserva) {
        this.fabricaRerserva = fabricaRerserva;
        this.servicioCrearReserva = servicioCrearReserva;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoReserva comandoReserva){
        Reserva reserva = this.fabricaRerserva.crear(comandoReserva);
        return new ComandoRespuesta<>(this.servicioCrearReserva.ejecutar(reserva));
    }
}
