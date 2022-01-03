package com.ceiba.reserva.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.reserva.comando.ComandoReservaCotizacion;
import com.ceiba.reserva.controlador.ConsultaControladorReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ComandoReservaCotizacionTestBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorReserva.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorReservaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar reservas")
    void deberiaListarReservas() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/reserva")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].idVehiculo", is(1)))
                .andExpect(jsonPath("$[0].idUsuario", is(1)));

    }

    @Test
    @DisplayName("Deberia cotizar una reserva")
    void deberiaCotizarReserva() throws Exception {
        // arrange
        ComandoReservaCotizacion cotizacion = new ComandoReservaCotizacionTestBuilder().build();
        // act - assert
        mocMvc.perform(get("/reserva/cotizar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cotizacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 855000.0}"));
    }


}
