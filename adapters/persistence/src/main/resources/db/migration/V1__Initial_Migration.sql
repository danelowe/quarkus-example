create sequence hibernate_sequence start 1 increment 1;
create sequence customer_customer_id_seq start 1 increment 50;
create table customer_customer
(
    id         integer not null primary key,
    first_name varchar(255),
    last_name  varchar(255)
);
insert into customer_customer (id, first_name, last_name)
values (1, 'Eleanor', 'Shellstrop'),
       (2, 'Michael', 'Goodley'),
       (3, 'Tahani', 'Al Jamil'),
       (4, 'Chidi', 'Anagonye'),
       (5, 'Jason', 'Mendoza'),
       (6, 'Janet', 'Janet'),
       (7, 'Doug', 'Forcett'),
       (8, 'Larry', 'Hemsworth'),
       (9, 'Mindy', 'St. Claire'),
       (10, 'Chris', 'Baker'),
       (11, 'Derek', 'Derek'),
       (12, 'Simone', 'Garnett'),
       (13, 'John', 'Wheaton'),
       (14, 'François', ' Lloyd-Tort'),
       (15, 'Donkey', 'Doug'),
       (16, 'Brent', 'Norwalk'),
       (17, 'Bambadjan', 'Bambadjan'),
       (18, 'Ken', 'Garoo'),
       (19, 'Lod', 'Raver'),
       (20, 'Quinston', 'Timeclock'),
       (21, 'Gel', 'Mibson'),
       (22, 'Shaun', 'Baddely')
on conflict do nothing;
