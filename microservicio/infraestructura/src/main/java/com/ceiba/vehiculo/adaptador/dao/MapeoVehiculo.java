package com.ceiba.vehiculo.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;

public class MapeoVehiculo  implements RowMapper<DtoVehiculo>, MapperResult {

    @Override
    public DtoVehiculo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String placa = resultSet.getString("placa");
        String marca = resultSet.getString("marca");
        String referencia = resultSet.getString("referencia");
        String estado = resultSet.getString("estado");
        Double precioDia =  resultSet.getDouble("precioDia");;
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoVehiculo(id, placa, marca, referencia, estado, precioDia,fecha);
    }
}
