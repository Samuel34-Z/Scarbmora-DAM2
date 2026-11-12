create table if not exists persona (
    codigo_persona integer primary key autoIncrement,
    nif char(9) unique,
    nombre varchar(150)
)