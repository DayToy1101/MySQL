show databases ;
create database emp;
use emp;
create table employee
(
  id int primary key ,
  name varchar(20) not null,
  sex varchar(10),
  age int
);
create table sourse
(
  time time,
  flag boolean,
  eid int,
  foreign key (eid) references employee(id)
);

show tables ;