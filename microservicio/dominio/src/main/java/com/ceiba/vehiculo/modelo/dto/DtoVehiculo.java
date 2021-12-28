package com.ceiba.vehiculo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoVehiculo {
    private Long id;
    private String placa;
    private String marca;
    private String referencia;
    private String estado;
    private Double precioDia;
    private LocalDateTime fechaCreacion;
}
