-- =========================================================
-- TABLA PELICULA
-- =========================================================

CREATE TABLE "pelicula"(
    "id" SERIAL NOT NULL,
    "activo" BOOLEAN NOT NULL,
    "anio" INTEGER NOT NULL,
    "titulo" VARCHAR(255) NOT NULL,
    "clasificacion" VARCHAR(255) NOT NULL,
    "duracion" INTEGER NOT NULL,
    "sinopsis" VARCHAR(255) NOT NULL,

    PRIMARY KEY ("id")
);


-- =========================================================
-- TABLA GENERO
-- =========================================================

CREATE TABLE "genero"(
    "id" SERIAL NOT NULL,
    "nombre" VARCHAR(255) NOT NULL,

    PRIMARY KEY ("id")
);


-- =========================================================
-- TABLA PELICULA_GENERO
-- =========================================================

CREATE TABLE "pelicula_genero"(
    "id_pelicula" INTEGER NOT NULL,
    "id_genero" INTEGER NOT NULL,

    PRIMARY KEY ("id_pelicula", "id_genero"),

    CONSTRAINT "pelicula_genero_id_pelicula_foreign"
        FOREIGN KEY ("id_pelicula")
        REFERENCES "pelicula"("id"),

    CONSTRAINT "pelicula_genero_id_genero_foreign"
        FOREIGN KEY ("id_genero")
        REFERENCES "genero"("id")
);


-- =========================================================
-- TABLA SALA
-- =========================================================

CREATE TABLE "sala"(
    "id" SERIAL NOT NULL,
    "numero" INTEGER NOT NULL,
    "capacidad" INTEGER NOT NULL,

    PRIMARY KEY ("id")
);


-- =========================================================
-- TABLA SESION
-- =========================================================

CREATE TABLE "sesion"(
    "id" SERIAL NOT NULL,
    "precio_base" FLOAT(53) NOT NULL,
    "plazas_disponibles" INTEGER NOT NULL,
    "fecha_hora_inicio" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "fecha_hora_fin" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "id_sala" INTEGER NOT NULL,
    "id_pelicula" INTEGER NOT NULL,

    PRIMARY KEY ("id"),

    CONSTRAINT "sesion_id_pelicula_foreign"
        FOREIGN KEY ("id_pelicula")
        REFERENCES "pelicula"("id"),

    CONSTRAINT "sesion_id_sala_foreign"
        FOREIGN KEY ("id_sala")
        REFERENCES "sala"("id")
);


-- =========================================================
-- TABLA USUARIO
-- =========================================================

CREATE TABLE "usuario"(
    "id" SERIAL NOT NULL,
    "username" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,

    PRIMARY KEY ("id"),

    CONSTRAINT "usuario_username_unique"
        UNIQUE ("username")
);


-- =========================================================
-- TABLA COMPRA
-- =========================================================

CREATE TABLE "compra"(
    "id" SERIAL NOT NULL,
    "parking_usado" BOOLEAN NOT NULL,
    "fecha_compra" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    "num_entradas" INTEGER NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "precio_total" FLOAT(53) NOT NULL,
    "estado" VARCHAR(255) NOT NULL,
    "id_sesion" INTEGER NOT NULL,
    "id_usuario" INTEGER NOT NULL,

    PRIMARY KEY ("id"),

    CONSTRAINT "compra_id_sesion_foreign"
        FOREIGN KEY ("id_sesion")
        REFERENCES "sesion"("id"),

    CONSTRAINT "compra_id_usuario_foreign"
        FOREIGN KEY ("id_usuario")
        REFERENCES "usuario"("id")
);