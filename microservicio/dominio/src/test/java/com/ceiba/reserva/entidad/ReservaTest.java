package com.ceiba.reserva.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTest {

    @Test
    @DisplayName("Deberia crear correctamente la reserva")
    void deberiaCrearCorrectamenteLaReserva() {
        // arrange
        LocalDateTime fechaHoy= LocalDateTime.now();
        //act
        Reserva reserva = new ReservaTestDataBuilder().conId(1L).build();
        //assert
        assertEquals(1, reserva.getId());
        assertEquals(123456, reserva.getIdUsuario());
        assertEquals(123456, reserva.getIdVehiculo());
//        assertEquals(fechaHoy, reserva.getFechaCreacion());
//        assertEquals(fechaHoy, reserva.getFechaInicioReserva());
//        assertEquals(fechaHoy, reserva.getFechaFinRerserva());
    }

    @Test
    void deberiaFallarSinIdVehiculo() {
        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdVehiculo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id del vehiculo");
    }

    @Test
    void deberiaFallarSinIdUsuario() {
        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdUsuario(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id del usuario");
    }


    @Test
    void deberiaFallarSinFechaInicioReserva() {
        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaInicioReserva(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de inicio de la reserva");
    }

    @Test
    void deberiaFallarSinFechaFinRerserva() {
        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().confechaFinRerserva(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de fin de la reserva");
    }

}
