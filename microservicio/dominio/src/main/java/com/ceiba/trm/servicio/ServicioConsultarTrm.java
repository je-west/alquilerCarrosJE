package com.ceiba.trm.servicio;

import com.ceiba.trm.puerto.repositorio.RepositorioTrm;

import static com.ceiba.dominio.formato.FormatoDouble.darFormatoDosDecimales;

public class ServicioConsultarTrm {

    private final RepositorioTrm repositorioTrm;

    public ServicioConsultarTrm(RepositorioTrm repositorioTrm) {
        this.repositorioTrm = repositorioTrm;
    }

    public double ejecutar() {
        return darFormatoDosDecimales(repositorioTrm.obtenerTrm());
    }
}
