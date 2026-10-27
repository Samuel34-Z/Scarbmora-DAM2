create table if not exists materiaProfesor (
    Integer id primary key auto_increment,
    int codigo_Materia unique,
    int codigo_Profesor unique,
    foreign key (codigo_Materia) references materias(codigo_Materia),
    foreign key (codigo_Profesor) references profesores(codigo_Profesor),
)