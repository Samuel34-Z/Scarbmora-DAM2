create table if not exists proyecto(
    codigo_proyecto integer primary key autoIncrement,
    nombre_proyecto varchar(50),
    presupuesto decimal(10,2)
)