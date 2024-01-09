create database gestion_comandas;

use gestion_comandas;

create table empleado (
    id int not null primary key,
    usuario varchar(50) not null,
    password varchar(50) not null,
    nombre varchar(100) not null,
    nif varchar(10) not null,
    foto varchar(50) not null
);

insert into empleado values (1, 'diqi', 'diqi', 'Di Qi Chen', '54436737S', 'default.jpg');
insert into empleado values (2, 'antonio', 'antonio', 'Antonio Alonso', '84830054M', '1001.jpg');
insert into empleado values (3, 'bruno', 'bruno', 'Bruno Bueno', '45368157J', '1002.jpg');

create table plato (
    id int not null primary key,
    nombre varchar(100) not null,
    precio float(5,2) not null
);

insert into plato values (1, 'Ensalada mixta', 3.50);
insert into plato values (2, 'Hamburguesa con queso', 6.80);
insert into plato values (3, 'Espaguetis a la boloñesa', 4.90);
insert into plato values (4, 'Entrecot de ternera', 10.75);
insert into plato values (5, 'Dorada al horno', 8.99);

create table comanda (
    id int not null primary key,
    mesa int not null,
    nombre varchar(50) not null,
    fecha date not null,
    total float(10,2) not null,
    total_maximo float(10, 2) not null,
    id_empleado int not null,
    foreign key (id_empleado) references empleado(id) on delete cascade
);

insert into comanda values (1, 1, 'Andrés', curdate(), 22, 100, 1);
insert into comanda values (2, 10, 'Belén', curdate(), 71.73, 100, 2);
insert into comanda values (3, 5, 'Carlos', curdate(), 39.9, 100, 3);
insert into comanda values (4, 3, 'Daniel', curdate(), 22, 100, 1);
insert into comanda values (5, 7, 'Elena', curdate(), 71.73, 100, 1);
insert into comanda values (6, 12, 'Fernando', curdate(), 39.9, 100, 2);
insert into comanda values (7, 8, 'Gabriela', curdate(), 22, 100, 2);
insert into comanda values (8, 4, 'Humberto', curdate(), 71.73, 100, 3);
insert into comanda values (9, 2, 'Irina', curdate(), 39.9, 100, 3);

create table comanda_plato (
    id_comanda int not null,
    id_plato int not null,
    cantidad int not null,
    primary key(id_comanda, id_plato),
    foreign key(id_comanda) references comanda(id) on delete cascade,
    foreign key(id_plato) references plato(id)
);

insert into comanda_plato values (1, 1, 1);
insert into comanda_plato values (1, 2, 2);
insert into comanda_plato values (1, 3, 1);
insert into comanda_plato values (2, 4, 5);
insert into comanda_plato values (2, 5, 2);
insert into comanda_plato values (3, 1, 3);
insert into comanda_plato values (3, 3, 6);
insert into comanda_plato values (4, 1, 1);
insert into comanda_plato values (4, 2, 2);
insert into comanda_plato values (4, 3, 1);
insert into comanda_plato values (5, 4, 5);
insert into comanda_plato values (5, 5, 2);
insert into comanda_plato values (6, 1, 3);
insert into comanda_plato values (6, 3, 6);
insert into comanda_plato values (7, 1, 1);
insert into comanda_plato values (7, 2, 2);
insert into comanda_plato values (7, 3, 1);
insert into comanda_plato values (8, 4, 5);
insert into comanda_plato values (8, 5, 2);
insert into comanda_plato values (9, 1, 3);
insert into comanda_plato values (9, 3, 6);

commit;

