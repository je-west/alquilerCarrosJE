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