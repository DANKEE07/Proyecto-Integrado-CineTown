-- =========================================================
-- DATOS TABLA GENERO
-- =========================================================

INSERT INTO "genero" ("nombre") VALUES
('Acción'),
('Aventura'),
('Ciencia ficción'),
('Comedia'),
('Drama'),
('Terror'),
('Animación'),
('Thriller'),
('Romance'),
('Fantasía');


-- =========================================================
-- DATOS TABLA PELICULA
-- =========================================================

INSERT INTO "pelicula"
("activo", "anio", "titulo", "clasificacion", "duracion", "sinopsis")
VALUES
(TRUE, 2010, 'Origen', '12', 148,
 'Un ladrón especializado en robar secretos mediante los sueños recibe una misión aparentemente imposible.'),

(TRUE, 1999, 'Matrix', '16', 136,
 'Un programador descubre que la realidad que conoce es una simulación creada por máquinas.'),

(TRUE, 1994, 'Forrest Gump', '12', 142,
 'La vida de un hombre con una visión inocente del mundo se cruza con importantes acontecimientos históricos.'),

(TRUE, 2008, 'El Caballero Oscuro', '16', 152,
 'Batman se enfrenta a un peligroso criminal que pretende sembrar el caos en Gotham.'),

(TRUE, 2019, 'Parásitos', '16', 132,
 'Una familia con pocos recursos consigue introducirse poco a poco en la vida de una familia adinerada.'),

(TRUE, 2001, 'El Señor de los Anillos', '12', 178,
 'Un joven hobbit debe emprender un viaje para destruir un poderoso anillo.'),

(TRUE, 2010, 'Toy Story 3', 'Apta', 103,
 'Woody y sus amigos se enfrentan a un nuevo capítulo de sus vidas cuando Andy se prepara para ir a la universidad.'),

(TRUE, 2019, 'Joker', '18', 122,
 'Un hombre marginado inicia una transformación que tendrá consecuencias en toda Gotham.'),

(FALSE, 2020, 'Tenet', '12', 150,
 'Un agente secreto intenta evitar una amenaza que podría provocar una guerra mundial.'),

(TRUE, 2022, 'Top Gun: Maverick', '12', 130,
 'Un veterano piloto regresa para entrenar a una nueva generación de pilotos de combate.');


-- =========================================================
-- DATOS TABLA PELICULA_GENERO
-- =========================================================

-- Origen: Ciencia ficción + Acción + Thriller
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(1, 3),
(1, 1),
(1, 8);

-- Matrix: Ciencia ficción + Acción
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(2, 3),
(2, 1);

-- Forrest Gump: Drama + Romance
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(3, 5),
(3, 9);

-- El Caballero Oscuro: Acción + Drama + Thriller
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(4, 1),
(4, 5),
(4, 8);

-- Parásitos: Drama + Thriller
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(5, 5),
(5, 8);

-- El Señor de los Anillos: Fantasía + Aventura + Acción
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(6, 10),
(6, 2),
(6, 1);

-- Toy Story 3: Animación + Comedia + Aventura
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(7, 7),
(7, 4),
(7, 2);

-- Joker: Drama + Thriller
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(8, 5),
(8, 8);

-- Tenet: Ciencia ficción + Acción + Thriller
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(9, 3),
(9, 1),
(9, 8);

-- Top Gun: Maverick: Acción + Drama
INSERT INTO "pelicula_genero" ("id_pelicula", "id_genero") VALUES
(10, 1),
(10, 5);


-- =========================================================
-- DATOS TABLA SALA
-- =========================================================

INSERT INTO "sala" ("numero", "capacidad") VALUES
(1, 100),
(2, 80),
(3, 120),
(4, 60),
(5, 150);


-- =========================================================
-- DATOS TABLA SESION
-- =========================================================

INSERT INTO "sesion"
("precio_base", "fecha_hora_inicio", "fecha_hora_fin",
 "id_sala", "id_pelicula")
VALUES

-- Origen
(8.50, '2026-10-05 17:00:00', '2026-10-05 19:28:00', 1, 1),
(9.50, '2026-10-05 21:00:00', '2026-10-05 23:28:00', 3, 1),

-- Matrix
(7.50, '2026-10-05 16:00:00', '2026-10-05 18:16:00', 2, 2),
(8.50, '2026-10-06 20:00:00', '2026-10-06 22:16:00', 4, 2),

-- Forrest Gump
(7.00, '2026-10-05 18:00:00', '2026-10-05 20:22:00', 4, 3),
(8.00, '2026-10-07 21:00:00', '2026-10-07 23:22:00', 2, 3),

-- El Caballero Oscuro
(9.00, '2026-10-05 19:00:00', '2026-10-05 21:32:00', 5, 4),
(10.00, '2026-10-06 22:00:00', '2026-10-07 00:32:00', 3, 4),

-- Parásitos
(8.00, '2026-10-05 20:00:00', '2026-10-05 22:12:00', 1, 5),
(9.00, '2026-10-08 18:30:00', '2026-10-08 20:42:00', 4, 5),

-- El Señor de los Anillos
(10.00, '2026-10-06 17:00:00', '2026-10-06 19:58:00', 5, 6),
(11.00, '2026-10-07 20:00:00', '2026-10-07 22:58:00', 3, 6),

-- Toy Story 3
(6.00, '2026-10-06 16:30:00', '2026-10-06 18:13:00', 2, 7),
(7.00, '2026-10-08 17:00:00', '2026-10-08 18:43:00', 1, 7),

-- Joker
(8.50, '2026-10-06 19:00:00', '2026-10-06 21:02:00', 4, 8),
(9.50, '2026-10-08 21:00:00', '2026-10-08 23:02:00', 5, 8),

-- Tenet
(8.50, '2026-10-07 18:00:00', '2026-10-07 20:30:00', 2, 9),

-- Top Gun: Maverick
(9.00, '2026-10-07 19:30:00', '2026-10-07 21:40:00', 1, 10),
(10.00, '2026-10-08 20:00:00', '2026-10-08 22:10:00', 3, 10);


-- =========================================================
-- DATOS TABLA USUARIO
-- =========================================================

INSERT INTO "usuario" ("username", "password") VALUES
('juan', '1234'),
('maria', 'abcd'),
('carlos', 'pass123'),
('ana', 'ana2026'),
('pedro', 'qwerty'),
('laura', 'laura123'),
('admin', 'admin');


-- =========================================================
-- DATOS TABLA COMPRA
-- =========================================================

INSERT INTO "compra"
("parking_usado", "fecha_compra", "num_entradas",
 "email", "precio_total", "estado",
 "id_sesion", "id_usuario")
VALUES

(TRUE, '2026-10-04 12:30:00', 2,
 'juan@email.com', 17.00, 'CONFIRMADA',
 1, 1),

(FALSE, '2026-10-04 15:20:00', 3,
 'maria@email.com', 28.50, 'CONFIRMADA',
 2, 2),

(TRUE, '2026-10-04 18:10:00', 1,
 'carlos@email.com', 7.50, 'CONFIRMADA',
 3, 3),

(FALSE, '2026-10-05 09:00:00', 4,
 'ana@email.com', 36.00, 'CONFIRMADA',
 7, 4),

(TRUE, '2026-10-05 10:15:00', 2,
 'pedro@email.com', 16.00, 'CONFIRMADA',
 9, 5),

(FALSE, '2026-10-05 11:45:00', 1,
 'laura@email.com', 10.00, 'CONFIRMADA',
 11, 6),

(TRUE, '2026-10-05 13:00:00', 5,
 'juan@email.com', 30.00, 'CONFIRMADA',
 13, 1),

(FALSE, '2026-10-05 14:30:00', 2,
 'maria@email.com', 17.00, 'CANCELADA',
 15, 2),

(TRUE, '2026-10-05 15:00:00', 3,
 'carlos@email.com', 28.50, 'CONFIRMADA',
 16, 3),

(FALSE, '2026-10-05 16:20:00', 1,
 'ana@email.com', 8.50, 'PENDIENTE',
 17, 4),

(TRUE, '2026-10-05 17:00:00', 2,
 'pedro@email.com', 18.00, 'CONFIRMADA',
 18, 5),

(FALSE, '2026-10-05 17:30:00', 4,
 'laura@email.com', 40.00, 'CONFIRMADA',
 19, 6);
