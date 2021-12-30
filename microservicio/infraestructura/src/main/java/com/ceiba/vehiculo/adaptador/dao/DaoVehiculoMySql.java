package com.ceiba.vehiculo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.vehiculo.modelo.dto.DtoVehiculo;
import com.ceiba.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoVehiculoMySql implements DaoVehiculo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="vehiculo", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="vehiculo", value="consultar")
    private static String sqlConsultar;

    public DaoVehiculoMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoVehiculo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoVehiculo());
    }

    @Override
    public List<DtoVehiculo>  consultarVehiculo(Long idVehiculo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idVehiculo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlConsultar, paramSource,new MapeoVehiculo());
    }
}
