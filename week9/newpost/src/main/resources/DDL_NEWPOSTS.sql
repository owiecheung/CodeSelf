

drop table NEWPOSTS;

Create table NEWPOSTS(

  ID integer auto_increment,
  TITLE VARCHAR(20) not null,
  CONTENT VARCHAR(50) not null,
  PUBLISHED BOOLEAN,
   constraint PK_NEWPOSTS  primary key(ID)
);