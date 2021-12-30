package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReservaCotizacion;
import com.ceiba.reserva.comando.manejador.ManejadorCotizarReserva;
import com.ceiba.reserva.consulta.ManejadorListarReserva;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@Api(tags={"Controlador consulta reservas"})
public class ConsultaControladorReserva {

    private final ManejadorListarReserva manejadorListarReserva;
    private final ManejadorCotizarReserva manejadorCotizarReserva;

    public ConsultaControladorReserva(ManejadorListarReserva manejadorListarReserva, ManejadorCotizarReserva manejadorCotizarReserva) {
        this.manejadorListarReserva = manejadorListarReserva;
        this.manejadorCotizarReserva = manejadorCotizarReserva;
    }

    @GetMapping
    @ApiOperation("Listar reservas")
    public List<DtoReserva> listar() {
        return this.manejadorListarReserva.ejecutar();
    }


    @GetMapping(value="/cotizar")
    @ApiOperation("Cotizar reserva")
    public ComandoRespuesta<Double> cotizarReserva(@RequestBody ComandoReservaCotizacion comandoReservaCotizacion) {
        return this.manejadorCotizarReserva.ejecutar(comandoReservaCotizacion);
    }


}


