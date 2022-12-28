CREATE DATABASE eCommerce;

CREATE TABLE cliente (
    cliente_id INT NOT NULL AUTO_INCREMENT,
    DNI INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    PRIMARY KEY (cliente_id)
);

CREATE TABLE producto (
    producto_id INT NOT NULL AUTO_INCREMENT,
    codigo INT NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (producto_id)
);

CREATE TABLE comprobante (
    comprobante_id INT NOT NULL AUTO_INCREMENT,
    fecha DATE NOT NULL,
    cantidad INT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    cliente_id INT NOT NULL,
    PRIMARY KEY (comprobante_id),
    FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id)
);

CREATE TABLE producto_venta (
    producto_venta_id INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(255) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    comprobante_id INT NOT NULL,
    producto_id INT NOT NULL,
    PRIMARY KEY (producto_venta_id),
    FOREIGN KEY (comprobante_id) REFERENCES comprobante (comprobante_id),
    FOREIGN KEY (producto_id) REFERENCES producto (producto_id)
);


DROP TABLE producto_venta;
DROP TABLE comprobante;
DROP TABLE producto;
DROP TABLE cliente;
