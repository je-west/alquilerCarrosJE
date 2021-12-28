package com.ceiba.reserva.comando.fabrica;

import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;

@Component
public class FabricaRerserva {

    public Reserva crear(ComandoReserva comandoReserva){
        return new Reserva(
                comandoReserva.getId(),
                comandoReserva.getIdVehiculo(),
                comandoReserva.getIdUsuario(),
                comandoReserva.getPrecioTotalReservaCOP(),
                comandoReserva.getPrecioTotalReservaUS(),
                comandoReserva.getFechaInicioReserva(),
                comandoReserva.getFechaInicioReserva(),
                comandoReserva.getFechaCreacion()
        );

    }
}
