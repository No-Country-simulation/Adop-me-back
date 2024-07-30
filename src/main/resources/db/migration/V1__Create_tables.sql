-- Creación de la tabla `usuario`
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) UNIQUE,
    contrasena VARCHAR(255) NOT NULL
);

-- Creación de la tabla `perfilrefugio`
CREATE TABLE perfilrefugio (
    idrefugio INT AUTO_INCREMENT PRIMARY KEY,
    nombre_refugio VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(255) NOT NULL,
    emailcontacto VARCHAR(255) NOT NULL,
    idusuario BIGINT,
    CONSTRAINT fk_perfilrefugio_usuario FOREIGN KEY (idusuario) REFERENCES usuario(id)
);

-- Creación de la tabla `perfiladoptante`
CREATE TABLE perfiladoptante (
    idperfiladoptante INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Apellido VARCHAR(255) NOT NULL,
    Direccion VARCHAR(255) NOT NULL,
    Telefono VARCHAR(255) NOT NULL,
    historial_de_adopciones VARCHAR(255),
    idusuario BIGINT,
    CONSTRAINT fk_perfiladoptante_usuario FOREIGN KEY (idusuario) REFERENCES usuario(id)
);

-- Creación de la tabla `mascotas`
CREATE TABLE mascotas (
    idmascotas INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Especie VARCHAR(255) NOT NULL,
    Raza VARCHAR(255) NOT NULL,
    Edad INT NOT NULL,
    Tamano DOUBLE NOT NULL,
    Descripcion VARCHAR(255),
    Fotos VARCHAR(255),
    Estado VARCHAR(255),
    fechadeingreso DATE,
    idRefugio INT,
    CONSTRAINT fk_mascotas_perfilrefugio FOREIGN KEY (idRefugio) REFERENCES perfilrefugio(idrefugio)
);

-- Creación de la tabla `perfil`
CREATE TABLE perfil (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Creación de la tabla `usuario_perfil`
CREATE TABLE usuario_perfil (
    usuario_id BIGINT,
    perfil_id BIGINT,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

-- Creación de la tabla `respuesta`
CREATE TABLE respuesta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    texto TEXT NOT NULL,
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
