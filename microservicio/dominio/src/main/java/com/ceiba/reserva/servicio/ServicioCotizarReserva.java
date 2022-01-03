package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionReserva;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ServicioCotizarReserva {

    private static final String LA_FECHA_INICIO_ES_MAYOR_O_IGUAL_A_LA_FINAL = "La fecha de inicio es mayor o igual que la final";
    private static final String DIAS_FIN_DE_SEMANA = "DiasFinDeSemana";
    private static final String DIAS_EN_SEMANA = "DiasEnSemana";
    private static LocalDateTime fechaInicioReserva = LocalDateTime.now();
    private static LocalDateTime fechaFinReserva = LocalDateTime.now();

    public ServicioCotizarReserva() {}

    public Double ejecutar(Double precio, LocalDateTime fechaInicio, LocalDateTime fechaFin){
        fechaInicioReserva = LocalDateTime.of(fechaInicio.toLocalDate(), LocalTime.MIDNIGHT);
        fechaFinReserva = LocalDateTime.of(fechaFin.toLocalDate(), LocalTime.MIDNIGHT);

        validacionFechaInicioMenorALaMayor();

        return calcularPrecio(precio);
    }

    private void validacionFechaInicioMenorALaMayor(){
        Boolean mayorFechaInicioFinal = this.fechaInicioReserva.isBefore(fechaFinReserva) || fechaInicioReserva.equals(fechaFinReserva);
        if (!mayorFechaInicioFinal){
            throw new ExcepcionReserva(LA_FECHA_INICIO_ES_MAYOR_O_IGUAL_A_LA_FINAL);
        }
    }

    private double calcularPrecio(Double precio){
        Map<String, Integer> dias=calcularDias(fechaInicioReserva, fechaFinReserva);
        Double precioTotalReserva= getPrecioTotalReserva(precio, dias.get("DiasFinDeSemana"), dias.get("DiasEnSemana"));

        return precioTotalReserva;
    }


    private Map<String, Integer> calcularDias(LocalDateTime fechaInicioReserva, LocalDateTime fechaFinReserva){
        Map<String, Integer> dias = new HashMap<>();
        int diasFinDeSemana= 0;
        int diasEnSemana= 0;

        while (!fechaInicioReserva.equals(fechaFinReserva.plusDays(1))){
            Boolean esFinDeSemana = (fechaInicioReserva.getDayOfWeek().equals(DayOfWeek.SATURDAY) || fechaInicioReserva.getDayOfWeek().equals(DayOfWeek.SUNDAY));
            if(esFinDeSemana){
                diasFinDeSemana++;
            }else {
                diasEnSemana++;
            }
            fechaInicioReserva = fechaInicioReserva.plusDays(1);
        }
        dias.put(DIAS_FIN_DE_SEMANA, diasFinDeSemana);
        dias.put(DIAS_EN_SEMANA, diasEnSemana);

        return dias;
    }

    private double getPrecioTotalReserva(Double precio, int diasFinDeSemana, int diasEnSemana) {
        return (diasEnSemana * precio)+(diasFinDeSemana *(precio *1.35));
    }


}
