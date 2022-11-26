
  Drop table TSTUDENTS;
  
  CREATE TABLE TSTUDENTS(
    ID integer auto_increment,
    S_NAME varchar(20) not null,
    S_HEIGHT numeric (5,2) not null ,
    constraint PK_STUDENTS  primary key(ID)
  );
  
