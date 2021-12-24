package com.ceiba.vehiculo.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoVehiculo {

    private Long id;
    private String placa;
    private String marca;
    private String estado;
    private LocalDateTime fechaCreacion;


}
