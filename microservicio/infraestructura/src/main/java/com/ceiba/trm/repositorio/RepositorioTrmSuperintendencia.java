package com.ceiba.trm.repositorio;

import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;
import com.ceiba.trm.puerto.repositorio.RepositorioTrm;
import com.ceiba.trm.superintendencia.TCRMServicesInterfaceProxy;
import com.ceiba.trm.superintendencia.TcrmResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.Calendar;

@Repository
public class RepositorioTrmSuperintendencia implements RepositorioTrm {

    private static final String ERROR_CONSULTANDO_TRM = "Error consultando trm";

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositorioTrmSuperintendencia.class);

    @Value("${superintendencia.soap.end-point}")
    private String endPoint;

    @Override
    public double obtenerTrm() {
        try {
            TCRMServicesInterfaceProxy tcrmServicesInterfaceProxy = new TCRMServicesInterfaceProxy(endPoint);
            TcrmResponse tcrmResponse = tcrmServicesInterfaceProxy.queryTCRM(Calendar.getInstance());
            return tcrmResponse.getValue();
        } catch (RemoteException | ServiceException e) {
            LOGGER.error(e.getMessage());
            throw new ExcepcionTecnica(ERROR_CONSULTANDO_TRM, e);
        }
    }


}
