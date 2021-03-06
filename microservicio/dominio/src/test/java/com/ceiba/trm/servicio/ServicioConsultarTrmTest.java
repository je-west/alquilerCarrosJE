package com.ceiba.trm.servicio;

import com.ceiba.trm.puerto.repositorio.RepositorioTrm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioConsultarTrmTest {

    private ServicioConsultarTrm servicioConsultarTrm;
    private RepositorioTrm repositorioTrm;

    @BeforeEach
    void setUp() {
        repositorioTrm = Mockito.mock(RepositorioTrm.class);
        servicioConsultarTrm = new ServicioConsultarTrm(repositorioTrm);
    }

    @Test
    void ejecutar() {
        double valorTrm = 4000.1899;
        double valorTrmEsperado = 4000.19;
        Mockito.doReturn(valorTrm).when(repositorioTrm).obtenerTrm();

        double resultado = servicioConsultarTrm.ejecutar();

        assertEquals(valorTrmEsperado, resultado);
    }
}