create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 cedula varchar(12) not null unique,
 telefono varchar(12) not null,
 fecha_creacion datetime null,
 primary key (id)
);