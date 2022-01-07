package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaCotizacion;
import com.ceiba.reserva.comando.manejador.ManejadorCotizarReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reserva.comando.manejador.ManejadorEliminarRerserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
@Api(tags = {"Controlador comando reserva"})
public class ComandoControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorCotizarReserva manejadorCotizarReserva;
    private final ManejadorEliminarRerserva manejadorEliminarRerserva;

    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorCotizarReserva manejadorCotizarReserva, ManejadorEliminarRerserva manejadorEliminarRerserva) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        this.manejadorCotizarReserva = manejadorCotizarReserva;
        this.manejadorEliminarRerserva = manejadorEliminarRerserva;
    }

    @PostMapping
    @ApiOperation("Crear reserva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva) {
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }


    @DeleteMapping()
    @ApiOperation("Eliminar reseva")
    public void eliminarReserva(@RequestParam Long id) {
        manejadorEliminarRerserva.ejecutar(id);
    }


    @PostMapping(value="/cotizar")
    @ApiOperation("Cotizar reserva")
    public ComandoRespuesta<Double> cotizarReserva(@RequestBody ComandoReservaCotizacion comandoReservaCotizacion) {
        return this.manejadorCotizarReserva.ejecutar(comandoReservaCotizacion);
    }


}
