package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idVehiculo = resultSet.getLong("vehiculo_id");
        Long idUsuario = resultSet.getLong("usuario_id");
        Double precioTotalReservaCOP = resultSet.getDouble("precio_total_reserva_cop");
        Double precioTotalReservaUS = resultSet.getDouble("precio_total_reserva_us");
        LocalDateTime fechaInicioReserva = extraerLocalDateTime(resultSet, "fecha_inicio_reserva");
        LocalDateTime fechaFinRerserva = extraerLocalDateTime(resultSet, "fecha_fin_rerserva");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoReserva(id, idVehiculo, idUsuario,precioTotalReservaCOP,precioTotalReservaUS, fechaInicioReserva,fechaFinRerserva,fechaCreacion);
    }
}
