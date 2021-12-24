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
        LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Reserva reserva = new ReservaTestDataBuilder().conFechaCreacion(fechaCreacion).conId(1L).build();
        //assert
        assertEquals(1, reserva.getId());
        assertEquals(123456, reserva.getIdUsuario());
        assertEquals(123456, reserva.getIdVehiculo());
        assertEquals(fechaCreacion, reserva.getFechaCreacion());
    }

//    @Test
//    void deberiaFallarConIdVehiculo() {
//        //Arrange
//        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdVehiculo(null).conId(1L);
//        //act-assert
//        BasePrueba.assertThrows(() -> {
//                    reservaTestDataBuilder.build();
//                },
//                ExcepcionValorObligatorio.class, "Se debe ingresar el id del vehiculo");
//    }


}
