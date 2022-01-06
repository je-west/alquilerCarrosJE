package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReservaCotizacion;
import com.ceiba.reserva.servicio.ServicioCotizarReserva;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorCotizarReserva implements ManejadorComandoRespuesta<ComandoReservaCotizacion, ComandoRespuesta<Double>> {

    private final ServicioCotizarReserva servicioCotizarReserva;
    private final DaoVehiculo daoVehiculo;


    public ManejadorCotizarReserva(ServicioCotizarReserva servicioCotizarReserva, DaoVehiculo daoVehiculo) {
        this.servicioCotizarReserva = servicioCotizarReserva;
        this.daoVehiculo = daoVehiculo;
    }

    @Override
    public ComandoRespuesta<Double> ejecutar(ComandoReservaCotizacion comando) {
        final Double precio = consultarTarifaVehiculo(comando.getIdVehiculo());
        return new ComandoRespuesta<>(this.servicioCotizarReserva.ejecutar(precio, comando.getFechaInicioReserva().atStartOfDay(), comando.getFechaFinReserva().atStartOfDay()));
    }

    private Double consultarTarifaVehiculo(Long idVehiculo){
        final List<DtoVehiculo> vehiculos = this.daoVehiculo.consultarVehiculo(idVehiculo);
        return vehiculos.get(0).getPrecioDia();
    }
}
