insert into usuario(id, nombre, cedula, telefono, fecha_creacion)
    values(1,'test','12345','12345',now());

insert into vehiculo(id, placa, marca, referencia, estado, precioDia, fecha_creacion)
    values(1,'abc123', 'marca123', 'referencia123', 'Disponible', 0, now());

insert into reserva(vehiculo_id, usuario_id, precio_total_reserva_cop, precio_total_reserva_us, fecha_inicio_reserva, fecha_fin_rerserva, fecha_creacion)
    values(1, 1, 400000.00, 100.00, now(), now(), now());

