create database mebelshop;

create table if not exists roles (
   id int8 not null,
   name varchar (20),
   primary key (id)
);

insert into roles (id, name)
    values (1, 'ROLE_USER'), (2, 'ROLE_MODERATOR'), (3, 'ROLE_ADMIN');

create table if not exists users (
    id int8 generated by default as identity,
    username varchar(50) not null,
    email varchar(100) not null,
    password varchar(50) not null,
    primary key (id),
    UNIQUE (username, email)
);

create  table if not exists user_role (
    user_id int8 not null,
    role_id int8 not null,
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);