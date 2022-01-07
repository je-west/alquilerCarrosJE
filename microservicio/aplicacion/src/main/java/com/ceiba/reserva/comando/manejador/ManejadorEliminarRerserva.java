package com.ceiba.reserva.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarRerserva implements ManejadorComando<Long> {

    private final ServicioEliminarReserva servicioEliminarReserva;

    public ManejadorEliminarRerserva(ServicioEliminarReserva servicioEliminarReserva) {
        this.servicioEliminarReserva = servicioEliminarReserva;
    }

    public void ejecutar(Long idReserva) {
        this.servicioEliminarReserva.ejecutar(idReserva);
    }

}
