package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionReserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCotizarReservaTest {


    @Test
    @DisplayName("Deberia crear una reserva correcta")
    void deberiaCotizarUnaReserva(){
        Double resultadoEsperado= 855000.00;
        LocalDateTime fechaInicioReserva = LocalDateTime.of(2021, 12, 25, 00, 00);
        LocalDateTime fechaFinReserva = LocalDateTime.of(2021, 12, 29, 00, 00);

        ServicioCotizarReserva servicioCotizarReserva = new ServicioCotizarReserva();
        Double precio =servicioCotizarReserva.ejecutar(150000.00, fechaInicioReserva, fechaFinReserva);

        assertEquals(precio,resultadoEsperado);
    }


    @Test
    @DisplayName("Deberia fallar al cotizar una reserva, fechas inicio y final iguales")
    void deberiaFallarAlCotizarUnaReservaFechaInicioYFinIguales(){
        LocalDateTime fechaInicioReserva = LocalDateTime.of(2021, 12, 30, 00, 00);
        LocalDateTime fechaFinReserva = LocalDateTime.of(2021, 12, 30, 00, 00);

        ServicioCotizarReserva servicioCotizarReserva = new ServicioCotizarReserva();

        BasePrueba.assertThrows(() -> servicioCotizarReserva.ejecutar(150000.00, fechaInicioReserva, fechaFinReserva), ExcepcionReserva.class,"La fecha de inicio es mayor o igual que la final");
    }


}
