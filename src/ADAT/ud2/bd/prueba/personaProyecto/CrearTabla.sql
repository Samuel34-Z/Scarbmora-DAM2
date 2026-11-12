create table if not exists persona_proyecto (
    codigo_persona integer,
    codigo_proyecto integer,
    horas_asignadas integer,
    primary key (codigo_persona, codigo_proyecto),
    foreign key (codigo_persona) references persona (codigo_persona),
    foreign key (codigo_proyecto) references proyecto (codigo_proyecto)
)