SET
search_path TO cinetown;

-- Si ya ejecutaste el script anterior, descomenta esto para empezar limpio:
-- TRUNCATE compra, sesion, pelicula_genero, usuario, sala, pelicula, genero RESTART IDENTITY CASCADE;

-- =========================================================
-- GENERO
-- =========================================================
INSERT INTO genero (id, nombre)
VALUES (1, 'Ciencia ficción'),
       (2, 'Animación'),
       (3, 'Drama'),
       (4, 'Acción'),
       (5, 'Thriller'),
       (6, 'Aventura'),
       (7, 'Terror'),
       (8, 'Romance'),
       (9, 'Comedia');

-- =========================================================
-- PELICULA
-- =========================================================
INSERT INTO pelicula (id, activo, anio, titulo, clasificacion, duracion, sinopsis)
VALUES (1, true, 2010, 'Origen', '+12', 148,
        'Un ladrón especializado en robar secretos a través de los sueños recibe un encargo imposible: implantar una idea en la mente de alguien.'),
       (2, true, 1994, 'El Rey León', 'TP', 88,
        'Un joven león debe asumir su destino tras la muerte de su padre y recuperar el reino que le pertenece.'),
       (3, true, 2019, 'Parásitos', '+16', 132,
        'Una familia sin recursos se infiltra poco a poco en la vida de una familia adinerada con consecuencias inesperadas.'),
       (4, true, 1995, 'Toy Story', 'TP', 81,
        'Los juguetes de un niño cobran vida cuando nadie mira, hasta que llega un nuevo juguete que altera el equilibrio.'),
       (5, true, 2000, 'Gladiator', '+16', 155,
        'Un general romano traicionado se convierte en gladiador para vengar a su familia y desafiar al emperador.'),
       (6, true, 1999, 'Matrix', '+16', 136,
        'Un programador descubre que el mundo que conoce es una simulación y se une a la rebelión contra las máquinas.'),
       (7, true, 1980, 'El Resplandor', '+16', 146,
        'Un escritor se instala con su familia como vigilante de un hotel aislado en invierno, mientras su mente se deteriora.'),
       (8, true, 1997, 'Titanic', '+12', 195,
        'Un joven artista y una chica de clase alta se enamoran a bordo del transatlántico que está a punto de hundirse.'),
       (9, true, 1975, 'Tiburón', '+12', 124,
        'Un jefe de policía, un biólogo y un cazador de tiburones intentan detener a un gran tiburón blanco que ataca una playa.'),
       (10, true, 2001, 'Amélie', '+12', 122,
        'Una joven parisina decide mejorar en secreto la vida de quienes la rodean, mientras busca su propio camino hacia el amor.'),
       (11, true, 2014, 'Interstellar', '+12', 169,
        'Un grupo de astronautas viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad.');

-- =========================================================
-- PELICULA_GENERO
-- =========================================================
INSERT INTO pelicula_genero (id_pelicula, id_genero)
VALUES (1, 1),
       (1, 5),
       (1, 4),
       (2, 2),
       (2, 6),
       (2, 3),
       (3, 5),
       (3, 3),
       (4, 2),
       (4, 6),
       (4, 9),
       (5, 4),
       (5, 3),
       (5, 6),
       (6, 1),
       (6, 4),
       (7, 7),
       (7, 5),
       (8, 8),
       (8, 3),
       (9, 7),
       (9, 6),
       (9, 5),
       (10, 8),
       (10, 9),
       (11, 1),
       (11, 3),
       (11, 6);

-- =========================================================
-- SALA
-- =========================================================
INSERT INTO sala (id, numero, capacidad)
VALUES (1, 1, 80),
       (2, 2, 100),
       (3, 3, 120),
       (4, 4, 60),
       (5, 5, 150);

-- =========================================================
-- SESION
-- (plazas_disponibles = capacidad de la sala - entradas de compras CONFIRMADAS)
-- =========================================================
INSERT INTO sesion (id, precio_base, plazas_disponibles, fecha_hora_inicio, fecha_hora_fin, id_sala, id_pelicula)
VALUES (1, 8.50, 75, '2026-11-20 18:00:00', '2026-11-20 20:28:00', 1, 1),
       (2, 7.00, 96, '2026-11-20 17:00:00', '2026-11-20 18:28:00', 2, 2),
       (3, 9.00, 119, '2026-11-21 20:00:00', '2026-11-21 22:12:00', 3, 3),
       (4, 7.00, 80, '2026-11-22 16:00:00', '2026-11-22 17:21:00', 1, 4),
       (5, 9.50, 100, '2026-11-22 21:00:00', '2026-11-22 23:35:00', 2, 5),
       (6, 9.00, 120, '2026-11-23 22:00:00', '2026-11-24 00:16:00', 3, 6),
       (7, 8.00, 55, '2026-11-21 22:30:00', '2026-11-22 00:56:00', 4, 7),
       (8, 9.50, 146, '2026-11-22 18:00:00', '2026-11-22 21:15:00', 5, 8),
       (9, 8.50, 58, '2026-11-23 20:00:00', '2026-11-23 22:04:00', 4, 9),
       (10, 7.50, 77, '2026-11-24 19:00:00', '2026-11-24 21:02:00', 1, 10),
       (11, 9.50, 144, '2026-11-24 20:00:00', '2026-11-24 22:49:00', 5, 11),
       (12, 8.50, 96, '2026-11-25 20:30:00', '2026-11-25 22:58:00', 2, 1),
       (13, 7.00, 120, '2026-11-23 12:00:00', '2026-11-23 13:21:00', 3, 4),
       (14, 8.00, 60, '2026-11-25 21:00:00', '2026-11-25 23:26:00', 4, 7);

-- =========================================================
-- USUARIO
-- (si usas BCrypt, sustituye por hashes reales o registra los usuarios desde la app)
-- =========================================================
INSERT INTO usuario (id, username, password)
VALUES (1, 'ana', 'cambiar_por_hash_bcrypt'),
       (2, 'carlos', 'cambiar_por_hash_bcrypt'),
       (3, 'lucia', 'cambiar_por_hash_bcrypt');

-- =========================================================
-- COMPRA
-- (precio_total = precio_base * num_entradas; la compra CANCELADA no resta plazas)
-- =========================================================
INSERT INTO compra (id, parking_usado, fecha_compra, num_entradas, email, precio_total, estado, id_sesion, id_usuario)
VALUES (1, true, '2026-11-15 10:30:00', 2, 'ana@example.com', 17.00, 'CONFIRMADA', 1, 1),
       (2, false, '2026-11-15 11:15:00', 3, 'carlos@example.com', 25.50, 'CONFIRMADA', 1, 2),
       (3, false, '2026-11-15 12:00:00', 4, 'ana@example.com', 28.00, 'CONFIRMADA', 2, 1),
       (4, true, '2026-11-15 13:45:00', 1, 'lucia@example.com', 9.00, 'CONFIRMADA', 3, 3),
       (5, false, '2026-11-15 14:10:00', 5, 'carlos@example.com', 40.00, 'CONFIRMADA', 7, 2),
       (6, true, '2026-11-15 14:30:00', 4, 'lucia@example.com', 38.00, 'CONFIRMADA', 8, 3),
       (7, false, '2026-11-15 15:05:00', 2, 'ana@example.com', 17.00, 'CONFIRMADA', 9, 1),
       (8, true, '2026-11-15 15:40:00', 3, 'lucia@example.com', 22.50, 'CONFIRMADA', 10, 3),
       (9, true, '2026-11-15 16:20:00', 6, 'carlos@example.com', 57.00, 'CONFIRMADA', 11, 2),
       (10, false, '2026-11-15 16:45:00', 2, 'ana@example.com', 19.00, 'CANCELADA', 5, 1),
       (11, false, '2026-11-15 16:50:00', 4, 'carlos@example.com', 34.00, 'CONFIRMADA', 12, 2);

-- =========================================================
-- Resincronizar las secuencias SERIAL
-- =========================================================
SELECT setval(pg_get_serial_sequence('genero', 'id'), (SELECT MAX(id) FROM genero));
SELECT setval(pg_get_serial_sequence('pelicula', 'id'), (SELECT MAX(id) FROM pelicula));
SELECT setval(pg_get_serial_sequence('sala', 'id'), (SELECT MAX(id) FROM sala));
SELECT setval(pg_get_serial_sequence('sesion', 'id'), (SELECT MAX(id) FROM sesion));
SELECT setval(pg_get_serial_sequence('usuario', 'id'), (SELECT MAX(id) FROM usuario));
SELECT setval(pg_get_serial_sequence('compra', 'id'), (SELECT MAX(id) FROM compra));