package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_EL_ID_VEHICULO = "Se debe ingresar el id del vehiculo";
    private static final String SE_DEBE_INGRESAR_EL_ID_USUARIO = "Se debe ingresar el id del usuario";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO_RESERVA = "Se debe ingresar la fecha de inicio de la reserva";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FIN_RESERVA = "Se debe ingresar la fecha de fin de la reserva";

    private Long id;
    private Long idVehiculo;
    private Long idUsuario;
    private Double precioTotalReservaCOP;
    private Double precioTotalReservaUS;
    private LocalDateTime fechaInicioReserva;
    private LocalDateTime fechaFinRerserva;
    private LocalDateTime fechaCreacion;

    public Reserva(Long id, Long idVehiculo, Long idUsuario, Double precioTotalReservaCOP, Double precioTotalReservaUS,LocalDateTime fechaInicioReservacion, LocalDateTime fechaFinRerservacion, LocalDateTime fechaCreacion) {
        validarObligatorio(idVehiculo, SE_DEBE_INGRESAR_EL_ID_VEHICULO);
        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_USUARIO);
        validarObligatorio(fechaInicioReservacion, SE_DEBE_INGRESAR_LA_FECHA_INICIO_RESERVA);
        validarObligatorio(fechaFinRerservacion, SE_DEBE_INGRESAR_LA_FECHA_FIN_RESERVA);

        this.id = id;
        this.idVehiculo = idVehiculo;
        this.idUsuario = idUsuario;
        this.precioTotalReservaCOP = precioTotalReservaCOP;
        this.precioTotalReservaUS = precioTotalReservaUS;
        this.fechaInicioReserva = fechaInicioReservacion;
        this.fechaFinRerserva = fechaFinRerservacion;
        this.fechaCreacion = fechaCreacion;
    }
}