create database bd_sistema_facturacion;

use bd_sistema_facturacion;

-- creacion de tablas
create table  usuarios(
id_usuario int(11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
usuario varchar (15) not null,
password varchar(15) not null,
telefono varchar (15) not null,
estado int(1) not null
);


create table  cliente(
id_cliente int(11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
cedula varchar(15) not null,
telefono int (15) not null,
direccion varchar(30) not null,
estado int(1) not null
);

select * from cliente;

CREATE TABLE productos (
  id_producto INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  cantidad VARCHAR(100) NOT NULL,
  precio double(10,2) NOT NULL,
  descripcion varchar(300) NOT NULL,
  porcentajeIva int (2) NOT NULL,
  id_categoria int(11) NOT NULL,
  estado int(1) NOT NULL
);

select * from productos; 

CREATE TABLE categorias (
  id_categoria INT AUTO_INCREMENT PRIMARY KEY,
  descripcion VARCHAR(100) NOT NULL,
  estado int(1) NOT NULL
);

select * from categorias; 
select descripcion from categorias where descripcion = '';
truncate table categorias;

CREATE TABLE facturas (
  id_factura INT AUTO_INCREMENT PRIMARY KEY,
  id_cliente INT NOT NULL,
  fecha DATE NOT NULL,
  subtotal decimal (10,2) not NULL,
  iva decimal (10,2) not NULL,
  total decimal (10,2) not NULL,
  FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);



CREATE TABLE detalle_factura (
  id_factura INT AUTO_INCREMENT PRIMARY KEY,
  id_producto INT NOT NULL,
  cantidad int(500) not null,
  precio DECIMAL(10, 2) NOT NULL
);

CREATE TABLE pagos (
  id_pago INT AUTO_INCREMENT PRIMARY KEY,
  nombre varchar(500) not null,
  descripcion varchar(500)  NOT NULL
);
show tables;
