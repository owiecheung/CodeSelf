


Create table BOOKS(
    ID integer auto_increment,
    B_NAME varchar(30) not null,
--    A_NAME varchar(30) not null ,
    AUTHOR_ID integer not null,
    P_DATE DATE,
    constraint PK_BOOKS  primary key(ID),
    constraint FK_BOOKS  foreign key(AUTHOR_ID) REFERENCES AUTHORS(ID)
    );
