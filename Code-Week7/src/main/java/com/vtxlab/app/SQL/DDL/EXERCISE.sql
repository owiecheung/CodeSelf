table: LOCATIONS
location_id  street_address        postal_code  city        state_province  country_id
-----------  --------------------  -----------  ----------  --------------  ----------
1000         1297 Via Cola di Rie  989          Roma                        IT
1100         93091 Calle della Te  10934        Venice                      IT
1200         2017 Shinjuku-ku      1689         Tokyo       Tokyo Prefectu  JP
1400         2014 Jabberwocky Rd   26192        uthlakeSo   Texas           US

table: COUNTRIES
country_id  country_name  region_id
----------  ------------  ----------
DE          Germany       1
IT          Italy         1
JP          Japan         3
US          United State  2

table: DEPARTMENTS
+---------------+----------------------+------------+-------------+
| DEPARTMENT_ID | DEPARTMENT_NAME      | MANAGER_ID | LOCATION_ID |
+---------------+----------------------+------------+-------------+
|            10 | Administration       |        200 |        1100 |
|            20 | Marketing            |        201 |        1200 |
|            30 | Purchasing           |        202 |        1400 |

table: EMPLOYEES
+-------------+-------------+-------------+----------+--------------------+------------+------------+----------+----------------+------------+---------------+
| EMPLOYEE_ID | FIRST_NAME  | LAST_NAME   | EMAIL    | PHONE_NUMBER       | HIRE_DATE  | JOB_ID     | SALARY   | COMMISSION_PCT | MANAGER_ID | DEPARTMENT_ID |
+-------------+-------------+-------------+----------+--------------------+------------+------------+----------+----------------+------------+---------------+
|         100 | Steven      | King        | SKING    | 515-1234567        | 1987-06-17 | ST_CLERK   | 24000.00 |           0.00 |        109 |            10 |
|         101 | Neena       | Kochhar     | NKOCHHAR | 515-1234568        | 1987-06-18 | MK_REP     | 17000.00 |           0.00 |        103 |            20 |
|         102 | Lex         | De Haan     | LDEHAAN  | 515-1234569        | 1987-06-19 | AC_ACCOUNT | 17000.00 |           0.00 |        108 |            30 |
|         103 | Alexander   | Hunold      | AHUNOLD  | 590-4234567        | 1987-06-20 | MK_REP     |  9000.00 |           0.00 |        105 |            20 |

table: JOB_HISTORY
employee_id  start_date  end_date    job_id      department_id
-----------  ----------  ----------  ----------  -------------
102          1993-01-13  1998-07-24  IT_PROG     20
101          1989-09-21  1993-10-27  AC_ACCOUNT  10
101          1993-10-28  1997-03-15  AC_MGR      30
100          1996-02-17  1999-12-19  MK_REP      30
103          1998-03-24  1999-12-31  ST_CLERK    20

1. Create all the above tables, with the provided structures and PK/ FK if required.
2. Insert some data, you can add your own data.
3. Write a query to find the location_id, street_address, city, state_province, country_name of locations
4. Write a query to find the first_name, last name, department ID of all the employees.
5. Write a query to find the first_name, last_name, job_id, department ID of the employees who works in Japan.
6. Write a query to find the employee id, last_name along with their manager_id and last_name.
7. Write a query to find the first_name, last_name and hire date of the employees who was hired after 'Lex De Haan'.
8. Write a query to get the department name and number of employees for each the department.
9. Write a query to find the employee ID, job title, number of days between ending date and starting date for all jobs in department 30.
10. Write a query to display all department name, manager name, and city.
12. Create table JOBS
13. Write a query to display the average salary of each department.



-- 1. Create all the above tables, with the provided structures and PK/ FK if required.
CREATE TABLE LOCATIONS ( 
  location_id NUMERIC (4,0),
  street_address VARCHAR(50) ,
  postal_code NUMERIC(5,0),
  city VARCHAR(20),
  state_province VARCHAR(20),
  country_id VARCHAR(2),
  CONSTRAINT Location_ID PRIMARY KEY (location_id)
  );
  
CREATE TABLE COUNTRIES ( 
  country_id VARCHAR(2) PRIMARY KEY,
  country_name VARCHAR(20),
  region_id NUMERIC(1)
  );
  
CREATE TABLE DEPARTMENTS ( 
  DEPARTMENT_ID NUMERIC(2) PRIMARY KEY,
  DEPARTMENT_NAME VARCHAR(20),
  MANAGER_ID NUMERIC(3,0),
  LOCATION_ID NUMERIC(4,0)
  );
  
  CREATE TABLE EMPLOYEES ( 
  EMPLOYEE_ID NUMERIC(3,0) PRIMARY KEY,
  FIRST_NAME VARCHAR(15),
  LAST_NAME VARCHAR(10),
  EMAIL VARCHAR(20),
  PHONE_NUMBER VARCHAR(11),
  HIRE_DATE DATE,
  JOB_ID VARCHAR(10),
  SALARY NUMERIC(7,2),
  COMMISSION_PCT NUMERIC(2,2),
  MANAGER_ID NUMERIC(3,0),
  DEPARTMENT_ID NUMERIC(2,0)
  );
  
  CREATE TABLE JOB_HISTORY ( 
  employee_id NUMERIC(3,0),
  start_date DATE,
  end_date DATE,
  job_id VARCHAR(10),
  department_id NUMERIC(2,0),
  CONSTRAINT JOB_HISTORY PRIMARY KEY (employee_id,start_date)
  );
  
  
ALTER TABLE LOCATIONS    -- ERROR
ADD CONSTRAINT FK_Locations_ID
FOREIGN KEY (location_id) REFERENCES DEPARTMENTS(LOCATION_ID);

ALTER TABLE LOCATIONS  -- Done
ADD CONSTRAINT FK_Country_ID
FOREIGN KEY (country_id) REFERENCES COUNTRIES(country_id);

ALTER TABLE COUNTRIES  -- Done
ADD CONSTRAINT FK_Country_ID_c
FOREIGN KEY (country_id) REFERENCES LOCATIONS(country_id);

ALTER TABLE DEPARTMENTS  -- ERROR
ADD CONSTRAINT  FK_D_LOCATION_ID
FOREIGN KEY (LOCATION_ID) REFERENCES LOCATIONS(location_id);
  

ALTER TABLE EMPLOYEES -- DONE   
ADD CONSTRAINT FK_EMPLOYEE_ID
FOREIGN KEY (EMPLOYEE_ID) REFERENCES JOB_HISTORY(employee_id);

ALTER TABLE EMPLOYEES -- DONE   
ADD CONSTRAINT FK_DEPARTMENT_ID
FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENTS(DEPARTMENT_ID);

ALTER TABLE JOB_HISTORY -- DONE   
ADD CONSTRAINT FK_Job_HIS
FOREIGN KEY (employee_id) REFERENCES EMPLOYEES(EMPLOYEE_ID);


ALTER TABLE JOB_HISTORY -- DONE   
ADD CONSTRAINT FK_Dep_HIS
FOREIGN KEY (department_id) REFERENCES DEPARTMENTS(DEPARTMENT_ID);


  -- 2. Insert some data, you can add your own data.
  -- LOCATIONS
INSERT INTO LOCATIONS (location_id,street_address,postal_code,city,country_id) VALUES (1000, '1297 Via Cola di Rie',989,'Roma','IT');
INSERT INTO LOCATIONS (location_id,street_address,postal_code,city,country_id) VALUES (1100, '93091 Calle della Te', 10934,'Venice', 'IT');
INSERT INTO LOCATIONS (location_id,street_address,postal_code,city,state_province,country_id) VALUES (1200, '2017 Shinjuku-ku', 1689, 'Tokyo' ,'Tokyo Prefectu',  'JP');
INSERT INTO LOCATIONS (location_id,street_address,postal_code,city,state_province,country_id) VALUES (1400 , '2014 Jabberwocky Rd', 26192 , 'uthlakeSo', 'Texas','US');
select * from locations;

-- COUNTRIES
INSERT INTO COUNTRIES (country_id,country_name,region_id) VALUES ('DE' , 'Germany' ,1);
INSERT INTO COUNTRIES (country_id,country_name,region_id) VALUES ('IT','Italy', 1);
INSERT INTO COUNTRIES (country_id,country_name,region_id) VALUES ('JP','Japan',3);
INSERT INTO COUNTRIES (country_id,country_name,region_id) VALUES ('US', 'United State', 2);
select * from COUNTRIES;

-- DEPARTMENTS
INSERT INTO DEPARTMENTS (DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID) VALUES (10, 'Administration', 200,1100);
INSERT INTO DEPARTMENTS (DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID) VALUES (20, 'Marketing', 201,1200);
INSERT INTO DEPARTMENTS (DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID) VALUES (30, 'Purchasing', 202,1300);
select * from DEPARTMENTS;

-- EMPLOYEES
INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) 
VALUES (100 , 'Steven','King' , 'SKING' ,'515-1234567' ,'1987-06-17', 'ST_CLERK', 24000.00,  0.00 , 109 ,10);
INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) 
VALUES (101 ,'Neena', 'Kochhar', 'NKOCHHAR','515-1234568', '1987-06-18','MK_REP ',17000.00, 0.00, 103, 20);
INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) 
VALUES (102 ,'Lex', 'De Haan', 'LDEHAAN', '515-1234569', '1987-06-19', 'AC_ACCOUNT', 17000.00 , 0.00 ,108 ,30 );
INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) 
VALUES (103 ,'Alexander', 'Hunold', 'AHUNOLD', '590-4234567', '1987-06-20','MK_REP',  9000.00, 0.00, 105, 20);
select * from EMPLOYEES;

-- JOB_HISTORY
INSERT INTO JOB_HISTORY (employee_id,start_date,end_date,job_id,department_id)
VALUES (102, '1993-01-13', '1998-07-24', 'IT_PROG', 20);
INSERT INTO JOB_HISTORY (employee_id,start_date,end_date,job_id,department_id)
VALUES (101, '1989-09-21', '1993-10-27', 'AC_ACCOUNT', 10);
INSERT INTO JOB_HISTORY (employee_id,start_date,end_date,job_id,department_id)
VALUES (101, '1993-10-28', '1997-03-15', 'AC_MGR',30);
INSERT INTO JOB_HISTORY (employee_id,start_date,end_date,job_id,department_id)
VALUES (100, '1996-02-17', '1999-12-19', 'MK_REP',30);
INSERT INTO JOB_HISTORY (employee_id,start_date,end_date,job_id,department_id)
VALUES (103, '1998-03-24', '1999-12-31', 'ST_CLERK',20);
select * from JOB_HISTORY;

drop tables  locations;

-- 3. Write a query to find the location_id, street_address, city, state_province, country_name of locations
select location_id AS Location_ID, street_address AS Address, city AS City, state_province AS State, country_name AS Country 
from locations L
left join countries C
on C.country_id = L.country_id;


-- 4. Write a query to find the first_name, last name, department ID of all the employees.
select first_name AS First_Name, last_name AS Last_Name, department_ID AS Dept_ID from EMPLOYEES;

-- 5. Write a query to find the first_name, last_name, job_id, department ID of the employees who works in Japan.
select E.first_name AS First_Name, E.last_name AS Last_Name, E.job_id AS Job_ID, D.department_ID AS Dept_ID
from Employees E
join DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
join LOCATIONS L
ON L.location_id = D.LOCATION_ID
WHERE L.country_id = 'JP';

-- 6. Write a query to find the employee id, last_name along with their manager_id and last_name.
select E.EMPLOYEE_ID AS E_ID, E.last_name AS E_Name ,M.EMPLOYEE_ID AS Manager_ID, M.last_name AS M_Name 
from EMPLOYEES E 
left join EMPLOYEES M 
On E.MANAGER_ID = M.EMPLOYEE_ID ;

-- 7. Write a query to find the first_name, last_name and hire date of the employees who was hired after 'Lex De Haan'.
select E.first_name AS First_Name, E.last_name AS L_Name, E.hire_date AS Hire_D
from EMPLOYEES E
Where E.HIRE_DATE > '1987-06-19';



-- 8. Write a query to get the department name and number of employees for each the department.
select D.DEPARTMENT_NAME AS 'Dept Name', COUNT(*) AS 'No. of Employees'
From EMPLOYEES E
Inner join DEPARTMENTS D
On E.DEPARTMENT_ID = D.DEPARTMENT_ID
Group By D.DEPARTMENT_ID,DEPARTMENT_NAME
order by DEPARTMENT_NAME;


-- 9. Write a query to find the employee ID, job title, number of days between ending date and starting date for all jobs in department 30.
select J.employee_id, J.job_id, to_days(J.end_date)-to_days(J.start_date) AS Daays
from JOB_HISTORY J
Where J.department_id = 30;


-- 10. Write a query to display all department name, manager name, and city.
UPDATE DEPARTMENTS SET LOCATION_ID = 1400 Where DEPARTMENT_ID = 30;
select D.DEPARTMENT_NAME As Dept, E.first_name As 'Manager Name', L.city AS City
From DEPARTMENTS D
Left join EMPLOYEES E
On D.MANAGER_ID = E.EMPLOYEE_ID
Left join LOCATIONS L
On L.LOCATION_ID = D.LOCATION_ID;

-- 12. Create table JOBS
CREATE TABLE JOBS (
	JOB_ID varchar(10) primary key,
    JOB_TITLE VARCHAR(35),
    MIN_SALARY NUMERIC,
    MAX_SALARY NUMERIC
    
   -- constraint JOBS_P primary key (JOB_ID)
);
Drop table JOBS;

alter table JOBS 
ADD FOREIGN KEY(JOB_ID) REFERENCES JOB_HISTORY(job_id);

alter table JOBS 
ADD FOREIGN KEY(JOB_ID) REFERENCES EMPLOYEES(job_id);

alter table EMPLOYEES
ADD FOREIGN KEY (JOB_ID) REFERENCES JOBS(job_id);

-- JOBS INSERT
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) 
Values ('IT_PROG','IT Programmer', 22000,50000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) 
Values ('AC_ACCOUNT','Accounting', 17000,40000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) 
Values ('AC_MGR','Accounting Manager', 20000,40000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) 
Values ('MK_REP', 'Marketing Rep', 16000,30000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) 
Values ('ST_CLERK','Clerk', 14000,30000);

Update JOBS Set JOB_TITLE = 'Clerk' where JOB_ID ='ST_CLERK';
select * from jobs;
select * from EMPLOYEES;

-- 13. Write a query to display the average salary of each department.
SELECT D.DEPARTMENT_Name, AVG(e.salary) 
from DEPARTMENTS D
left join EMPLOYEES E 
On D.DEPARTMENT_id = E.DEPARTMENT_id
left join EMPLOYEES S
On E.DEPARTMENT_ID = S.SALARY
Group By D.DEPARTMENT_Name;
