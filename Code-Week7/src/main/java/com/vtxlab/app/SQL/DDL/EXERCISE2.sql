-- create new database
CREATE DATABASE ORG;
-- show all database;
SHOW DATABASES;
-- get into database
USE ORG;

CREATE TABLE WORKER (
	WORKER_ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME CHAR(25),
	LAST_NAME CHAR(25),
	SALARY NUMERIC(15),
	JOINING_DATE DATETIME,
	DEPARTMENT CHAR(25)
);

-- WORKERS INSERT 
INSERT INTO WORKER 
	(FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		('Monika', 'Arora', 100000, '21-02-20 09:00:00', 'HR'),
		('Niharika', 'Verma', 80000, '21-06-11 09:00:00', 'Admin'),
		('Vishal', 'Singhal', 300000, '21-02-20 09:00:00', 'HR'),
		('Amitabh', 'Singh', 500000, '21-02-20 09:00:00', 'Admin'),
		('Vivek', 'Bhati', 490000, '21-06-11 09:00:00', 'Admin'),
		('Vipul', 'Diwan', 200000, '21-06-11 09:00:00', 'Account'),
		('Satish', 'Kumar', 75000, '21-01-20 09:00:00', 'Account'),
		('Geetika', 'Chauhan', 90000, '21-04-11 09:00:00', 'Admin');
select * from worker;
INSERT INTO WORKER (FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		('Fivw', 'Ec', 90000, '21-04-11 09:00:00', 'Admin');
-- create table bonus
CREATE TABLE BONUS (
	WORKER_REF_ID INTEGER,
	BONUS_AMOUNT NUMERIC(10),
	BONUS_DATE DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
);
select * from BONUS ;



-- Task 1:
-- Vivek, with amount 32000 and bonus date 2021 Nov 02
-- Vivek, with amount 20000 and bonus date 2022 Nov 02
-- Amitabh, with amount 21000 and bonus date 2021 Nov 02
-- Geetika, with amount 30000 and bonus date 2021 Nov 02
-- Satish, with amount 4500 and bonus date 2022 Nov 02
INSERT INTO BONUS(WORKER_REF_ID , BONUS_AMOUNT,	BONUS_DATE ) VALUES 
	(1,32000,'21-11-02 00:00:00'),
	(1,20000,'22-11-02 00:00:00'),
	(4,21000,'21-11-02 00:00:00'),
	(8,30000,'21-11-02 00:00:00'),
	(7,4500,'22-11-02 00:00:00');



-- Task 2:
-- Write an SQL query to show the second highest salary among all workers.
select WORKER_ID'WORKER ID',CONCAT(FIRST_NAME,' ', LAST_NAME) AS Name , salary AS '2nd Highest Salary'
from Worker W
ORDER BY SALARY desc limit 1,1;


-- Task 3:
-- Write an SQL query to print the name of employees having the highest salary in each department.
select DEPARTMENT AS 'Dept' , CONCAT( FIRST_NAME, LAST_NAME ) AS NAME, salary AS 'Highest Salary'
from Worker W
Where SALARY IN (select max(SALARY)
			from worker
			Group by DEPARTMENT);
            

-- Task 4:
-- Write an SQL query to fetch the list of employees with the same salary.
Select CONCAT(W1.FIRST_NAME ,' ',W1.LAST_NAME) AS NAME , W1.salary As Salary
from worker W1
INNER join worker W2 
ON W1.salary = W2.salary and W1.FIRST_NAME != W2.FIRST_NAME;

-- Task 5:
-- Write an SQL query to find the worker names with the highest salaries + bonus in 2021
Select CONCAT(W1.FIRST_NAME,' ',W1.LAST_NAME) AS NAME, max(W1.SALARY) + MAX(B.BONUS_AMOUNT) AS sumSalary
 FROM WORKER AS W1 
 INNER JOIN BONUS AS B
 On W1.worker_ID = B.WORKER_REF_ID
 where ( Year(W1.joining_date) = '2021' AND Year(B.BONUS_Date) = '2021')
 group by NAME
 order by sumsalary desc limit 1;


-- Task 6 (Please complete Task 1-5 first):
-- Try to delete all the records in table WORKER
truncate table worker;
-- Study the reason why the data cannot be deleted

-- Because there is a foreign key is constraint

-- Try to delete all the records in table BONUS
truncate table BONUS;
-- Try to delete all the records in table WORKER
truncate table worker;

-- Task 7 (Please complete Task 6 first):
-- Try to drop table WORKER
drop table worker;
-- Study the reason why the table cannot be deleted

-- Try to drop table BONUS
drop table BONUS;
-- Try to drop table WORKER
drop table worker;
