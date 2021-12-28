create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 cedula varchar(12) not null unique,
 telefono varchar(12) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table vehiculo (
 id int(11) not null auto_increment,
 placa varchar(6) not null,
 marca varchar(50) not null,
 referencia varchar(100) not null,
 estado varchar(50) not null,
 precioDia double not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table reserva (
 id int(11) not null auto_increment,
 vehiculo_id int(11) not null,
 usuario_id int(11) not null,
 precio_total_reserva_cop double,
 precio_total_reserva_us double,
 fecha_inicio_reserva date not null,
 fecha_fin_rerserva date not null,
 fecha_creacion datetime null,
 primary key (id),
 foreign key (vehiculo_id) REFERENCES vehiculo(id),
 foreign key (usuario_id) REFERENCES usuario(id)
);