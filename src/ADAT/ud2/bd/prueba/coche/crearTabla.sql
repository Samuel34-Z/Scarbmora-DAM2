create table if not exists coches(
    matricula varchar(7) primary key,
    marca varchar(50),
    modelo varchar(50),
    codigo_propietario integer,
    foreign key (codigo_propietario) references persona(codigo_persona)
)