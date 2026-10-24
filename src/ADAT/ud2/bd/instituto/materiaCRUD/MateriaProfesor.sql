create table if not exists materiaProfesor (
    int codigoMateria,
    int codigoProfesor,
    Primary key (codigoMateria, codigoProfesor)
)