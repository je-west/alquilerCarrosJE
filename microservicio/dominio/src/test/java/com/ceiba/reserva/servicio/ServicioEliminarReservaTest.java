package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioEliminarReservaTest {

    @Test
    @DisplayName("Deberia eliminar una reserva sin errores")
    void deberiaCrearUnaReservaDeManeraCorrecta() {
        // arrange
        Long idReserva = 1L;
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);

        Mockito.doNothing().when(repositorioReserva).eliminar(Mockito.anyLong());
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        // act
        servicioEliminarReserva.ejecutar(idReserva);
        //- assert
        Mockito.verify(repositorioReserva, Mockito.times(1)).eliminar(idReserva);
    }
}
