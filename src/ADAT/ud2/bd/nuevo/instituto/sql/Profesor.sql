create table if not exists profesores (
    codigo_Profesor integer primary key auto_increment,
    nombre VARCHAR(50),
    apellidos VARCHAR(100),
    fecha_nacimiento text,
    direccion varchar(150),
    telefono char(9)
)