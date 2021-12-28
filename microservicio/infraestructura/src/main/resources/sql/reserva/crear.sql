INSERT INTO reserva
(vehiculo_id, usuario_id, precio_total_reserva_cop, precio_total_reserva_us, fecha_inicio_reserva, fecha_fin_rerserva, fecha_creacion)
VALUES(:idVehiculo, :idUsuario, :precioTotalReservaCOP, :precioTotalReservaUS, :fechaInicioReserva, :fechaFinRerserva, :fechaCreacion);
