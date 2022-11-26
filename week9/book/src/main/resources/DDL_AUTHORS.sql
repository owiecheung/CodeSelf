
drop table books;
drop table authors;
create table AUTHORS(
    ID integer auto_increment primary key,
    AUTHOR_NAME varchar(20) not null,
    AUTHOR_NAT varchar(2) not null
);