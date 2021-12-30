package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearReservaTest {

    @Test
    @DisplayName("Deberia Crear una reserva correcta")
    void deberiaCrearUnaReservaDeManeraCorrecta() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(10L);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(10L);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioVehiculo, repositorioUsuario);
        // act
        Long idReserva = servicioCrearReserva.ejecutar(reserva);
        //- assert
        assertEquals(10L,idReserva);
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(reserva);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la reserva")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeLaRerserva() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioVehiculo, repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class,"La reserva ya existe en el sistema");
    }


    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(false);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioVehiculo, repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionReserva.class,"El usuario que realizar la reserva no existe en el sistema");
    }


    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del vehiculo")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelVehiculo() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioVehiculo.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioVehiculo, repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionReserva.class,"La vehiculo que intenta reservar no existe en el sistema");
    }
}
