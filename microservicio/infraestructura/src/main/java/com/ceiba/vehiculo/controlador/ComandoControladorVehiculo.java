package com.ceiba.vehiculo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.vehiculo.comando.ComandoVehiculo;
import com.ceiba.vehiculo.comando.manejador.ManejadorCrearVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculo")
@Api(tags = {"Controlador comando vehiculo"})
public class ComandoControladorVehiculo {

    private final ManejadorCrearVehiculo manejadorCrearVehiculos;

    @Autowired
    public ComandoControladorVehiculo(ManejadorCrearVehiculo manejadorCrearVehiculos){
        this.manejadorCrearVehiculos = manejadorCrearVehiculos;
    }

    @PostMapping
    @ApiOperation("Crear vehiculo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoVehiculo comandoVehiculo){
        return manejadorCrearVehiculos.ejecutar(comandoVehiculo);
    }


}
