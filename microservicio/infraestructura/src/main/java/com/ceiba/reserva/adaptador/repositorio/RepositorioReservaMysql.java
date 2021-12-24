package com.ceiba.reserva.adaptador.repositorio;


import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {


    @Override
    public Long crear(Reserva reserva) {
        return null;
    }

    @Override
    public void actualizar(Reserva reserva) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(Long id) {
        return false;
    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    }
}
