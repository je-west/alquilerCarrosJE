package com.ceiba.reserva.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.ComandoReservaCotizacion;
import com.ceiba.reserva.servicio.testdatabuilder.ComandoReservaCotizacionTestBuilder;
import com.ceiba.reserva.servicio.testdatabuilder.ComandoReservaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorReserva.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorReservaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una reserva")
    void deberiaCrearUnaReserva() throws Exception{
        // arrange
        ComandoReserva reserva = new ComandoReservaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

        mocMvc.perform(get("/reserva")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @DisplayName("Deberia fallar, el usuario no existe")
    void deberiaFallarUsuarioNoExiste() throws Exception{
        // arrange
        ComandoReserva reserva = new ComandoReservaTestDataBuilder().conIdUsuario(5L).build();
        // act - assert
        mocMvc.perform(post("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Deberia fallar, el vehiculo no existe")
    void deberiaFallarVehiculoNoExiste() throws Exception{
        // arrange
        ComandoReserva reserva = new ComandoReservaTestDataBuilder().conIdVehiculo(3L).build();
        // act - assert
        mocMvc.perform(post("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Deberia fallar el vehiculo no esta disponible para la fechas")
    void deberiaFallarVehiculoNoDisponible() throws Exception{
        // arrange
        ComandoReserva reserva = new ComandoReservaTestDataBuilder().conFechaInicio(LocalDate.now().plusDays(-10)).build();
        // act - assert
        mocMvc.perform(post("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reserva)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Deberia cotizar una reserva")
    void deberiaCotizarReserva() throws Exception {
        // arrange
        ComandoReservaCotizacion cotizacion = new ComandoReservaCotizacionTestBuilder().build();
        // act - assert
        mocMvc.perform(post("/reserva/cotizar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cotizacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 855000.0}"));
    }

}
