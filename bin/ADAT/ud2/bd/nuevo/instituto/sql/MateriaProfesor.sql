create table if not exists materiaProfesor (
    id Integer primary key auto_increment,
    codigo_Materia integer unique,
    codigo_Profesor integer unique,
    foreign key (codigo_Materia) references materias (codigo_Materia),
    foreign key (codigo_Profesor) references profesores (codigo_Profesor),
)