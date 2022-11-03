create database quiz;

use quiz;

create table nivel(
	id int not null auto_increment,
	categoria varchar(100) not null,
	puntos int not null,
	dificultad varchar(100) not null,
	primary key (id),
    unique index categoria_UNIQUE (categoria asc) visible
);

------------------------------------------------------------------------------

create table pregunta(
	id int not null auto_increment,
    nivel_id int not null,
    contenido varchar(300) not null,
    primary key (id),
    foreign key fk_pregutna_nivel (nivel_id) references nivel(id) on update no action on delete cascade
);

---------------------------------------------------------------------------------------

create table opcion(
	id int not null auto_increment,
    pregunta_id int not null,
    contenido varchar(300) not null,
    primary key (id),
    foreign key fk_opcion_pregunta (pregunta_id) references pregunta(id) on update no action on delete cascade
);

-----------------------------------------------------------------------------------------------------

create table usuario(
	id int not null auto_increment,
	nombre_usuario varchar(50) not null,
	contraseña varchar(80) not null,
    primary key (id),
	unique index nombre_usuario_UNIQUE (nombre_usuario asc) visible
);

----------------------------------------------------------------------------------------------------------------

create table administrador(
	id int not null auto_increment,
	usuario_id int not null,
	primary key (id),
	foreign key fk_adminitrador_usuario (usuario_id) references usuario(id) on update no action on delete cascade
);

create table jugador(
	id int not null auto_increment,
	usuario_id int not null,
    nivel_id int not null,
	puntos_acumulados int not null default 0,
    primary key (id),
    foreign key fk_jugador_usuario (usuario_id) references usuario(id) on update no action on delete cascade,
    foreign key fk_jugador_nivel (nivel_id) references nivel(id)
);