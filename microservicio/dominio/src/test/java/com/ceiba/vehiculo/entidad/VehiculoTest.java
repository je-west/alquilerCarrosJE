package com.ceiba.vehiculo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {

    @Test
    @DisplayName("Deberia crear correctamente el vehiculo")
    void deberiaCrearCorrectamenteElVehiculo() {
        // arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Vehiculo vehiculo = new VehiculoTestDataBuilder().conFechaCreacion(fechaCreacion).conId(1L).build();
        //assert
        assertEquals(1, vehiculo.getId());
        assertEquals("ABC123", vehiculo.getPlaca());
        assertEquals("ABCMarca", vehiculo.getMarca());
        assertEquals(fechaCreacion, vehiculo.getFechaCreacion());
    }

    @Test
    void deberiaFallarSinPlacaDeVehiculo() {
        //Arrange
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vehiculoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la placa del vehiculo");
    }

    @Test
    void deberiaFallarSinMarcaDeVehiculo() {
        //Arrange
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conMarca(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vehiculoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la marca del vehiculo");
    }

    @Test
    void deberiaFallarSinFechaDeCreacionDeVehiculo() {
        //Arrange
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conFechaCreacion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    vehiculoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
    }



}
