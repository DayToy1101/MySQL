create database manage;
use manage;
create table student
(
  sc int primary key ,
  name varchar(20) not null,
  sex varchar(10) not null,
  grade varchar(10) not null,
  hid int,
  foreign key (hid) references hourse (id)
);
create table hourse
(
  id int primary key ,
  num int
);
create table daysource
(
  date time primary key ,
  hid int,
  sc int,
  foreign key (sc) references student(sc),
  flag boolean
);

show tables ;