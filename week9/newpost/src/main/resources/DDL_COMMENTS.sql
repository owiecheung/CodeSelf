

drop table COMMENTS;

create table COMMENTS(
  ID integer auto_increment,
  content varchar(50) not null,
  constraint PK_COMMENTS primary key(ID)
);

