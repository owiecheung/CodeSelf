
-- DDL Data Defintion Language
 
SELECT * FROM sys.sys_config;

 CREATE TABLE sys.ORDERS ( 
  ORDER_DATE TIMESTAMP, -- Datetime
  CUSTOMER_ID NUMERIC(3, 0),
  AMOUNT NUMERIC(13,2)
  );

-- DML -- Data Manipulation Language

select * from sys.ORDERS;
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES ("2022-11-02 20:10:23", 101 , 10000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES (NOW(), 102 , 15000);
INSERT INTO SYS.ORDERS VALUES (NOW(),103,17000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID) VALUES (NOW(),104);

-- SELECT STATEMENTS

SELECT * FROM  sys.orders where customer_id = 103;
SELECT AMOUNT FROM SYS.ORDERS WHERE CUSTOMER_ID =101; -- 10000.00
SELECT CUSTOMER_ID FROM SYS.ORDERS WHERE AMOUNT >= 13000; -- 102 | 103

select * from sys.orders where customer_id = 102; -- After excute Line 23 102 changed into 30000;

-- UPDATE STATEMENTS

UPDATE sys.ORDERS SET AMOUNT = 30000 WHERE CUSTOMER_ID = 102;
select * from sys.orders;
UPDATE sys.ORDERS SET AMOUNT = 20000 WHERE CUSTOMER_ID IN (101,103) AND ORDER_DATE >= "2022-11-02" ; -- 2 ROWS UPDATED
UPDATE sys.ORDERS SET AMOUNT = 20000 WHERE CUSTOMER_ID IN (101,103) AND ORDER_DATE >= "2022-11-04" ; -- 1 ROWS UPDATED
select count(*) from sys.orders;
select count(*) from sys.orders where order_date >= "2022-11-04"; -- 4
select 1 from sys.orders where order_date >= "2022-11-04";  -- TIME '1'  are returned
select count(1) from sys.orders where order_date >= "2022-11-04"; -- 4

-- DELETE STATEMENTS
delete from sys.orders where customer_id in (102,104); -- 2 rows are delete
select * from sys.orders;
delete from sys.orders;
select * from sys.orders;

INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES ("2022-11-02 20:10:23", 102 , 20000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES ("2022-11-04 20:10:23", 102 , 30000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES (NOW(), 102 , 40000);

delete from sys.orders where customer_id = 102 limit 1;
select * from sys.orders;
delete from sys.orders where customer_id = 102 order by order_date desc limit 1; -- delete the record with the lastest order_date   // desc = descending and delete the first one
select * from sys.orders;

ALTER TABLE SYS.ORDERS ADD MEMBERSHIP VARCHAR(1);
delete from sys.orders;
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES ("2022-11-02 20:10:23", 101 , 20000 ,'G');
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES ("2022-11-04 20:10:23", 102 , 30000, 'S');
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES (NOW(), 103 , 40000, 'S');
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES (NOW(), 104 , 40000,NULL);
SELECT MEMBERSHIP , COUNT(1) FROM sys.orders group by MEMBERSHIP; -- G, 1 | S, 2
SELECT MEMBERSHIP , AVG(AMOUNT) FROM sys.orders group by MEMBERSHIP; -- G, 20000 | S, 35000
SELECT MEMBERSHIP , SUM(AMOUNT) FROM sys.orders group by MEMBERSHIP; -- G, 20000 | S, 70000
SELECT MEMBERSHIP , COUNT(MEMBERSHIP) FROM sys.orders group by MEMBERSHIP HAVING COUNT(MEMBERSHIP) > 1 ; -- S, 2

SELECT MEMBERSHIP , COUNT(MEMBERSHIP) FROM sys.orders 
WHERE ORDER_DATE > "2022-11-05" GROUP BY MEMBERSHIP HAVING COUNT(MEMBERSHIP) > 1; -- NO ROWS RETURNED there is only 1 and not >1 ;

SELECT DISTINCT MEMBERSHIP FROM SYS.ORDERS; -- G, S, NULL    showed this colum what can be shown