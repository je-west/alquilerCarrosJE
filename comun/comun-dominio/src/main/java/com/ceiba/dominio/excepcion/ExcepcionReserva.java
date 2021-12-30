package com.ceiba.dominio.excepcion;

public class ExcepcionReserva extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionReserva(String mensaje) {
        super(mensaje);
    }
}
