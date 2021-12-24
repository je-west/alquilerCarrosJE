package com.ceiba.vehiculo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVehiculoMysql implements RepositorioVehiculo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

//    @SqlStatement(namespace="vehiculo", value="crear")
//    private static String sqlCrear;
//
//
//    @SqlStatement(namespace="vehiculo", value="existe")
//    private static String sqlExiste;

    public RepositorioVehiculoMysql (CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Vehiculo vehiculo) {
//      return this.customNamedParameterJdbcTemplate.crear(vehiculo, sqlCrear);
        return Long.parseLong("123456");
    }

    @Override
    public void actualizar(Vehiculo vehiculo) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("placa", nombre);

        //return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
        return false;
    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    }
}
