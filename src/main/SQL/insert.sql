INSERT INTO producto (codigo, descripcion, cantidad, precio) VALUES (1, 'Producto de prueba 1', 10, 25.00);

INSERT INTO cliente (DNI, nombre, apellido) VALUES (99999999, 'Juan', 'Perez');

INSERT INTO comprobante (fecha, cantidad, total, cliente_id) VALUES ('2019-01-01', 1, 25.00, 1);

INSERT INTO producto_venta (descripcion, cantidad, precio, comprobante_id, producto_id) VALUES ('Producto de prueba 1', 1, 25.00, 1, 1);