--SQL Lab Assignment

--2 SQL Queries
--2.1 SELECT
--Select all records from the Employee table
SELECT * FROM EMPLOYEE;

--Select all records from the Employee table where last name is King
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT * FROM EMPLOYEE 
WHERE FIRSTNAME = 'Andrew' and REPORTSTO is NULL;

--2.2 ORDER BY
--Select all albums in Album table and sort result set in descending order by title
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

--Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER 
ORDER BY CITY;

--2.3 INSERT INTO
--Insert two new records into Genre table 
INSERT INTO GENRE 
VALUES(26, 'INSTRUMENTAL');
/
INSERT INTO GENRE
VALUES(27,'COVER');
/
--Insert two new records into Employee table
INSERT INTO EMPLOYEE
VALUES(9, 'Singh', 'Gurvir', 'IT Staff', 6, TO_DATE('1993-09-28', 'YYYY-MM-DD'), TO_DATE('2012-12-12', 'YYYY-MM-DD'), '183-15 89TH AVE', 'Hollis', 'NY', 'USA', '11423', '+1 (777) 777-7777', '+1 (777) 777-7777', 'gurvir@chinook.com');
/
INSERT INTO EMPLOYEE
VALUES(10, 'Singh', 'Tandeep', 'IT Staff', 6, TO_DATE('1997-02-20', 'YYYY-MM-DD'), TO_DATE('2015-08-15', 'YYYY-MM-DD'), '120-20 1st AVE', 'New York', 'NY', 'USA', '10009', '+1 (999) 888-7777', '+1 (999) 888-7777', 'tandeep@chinook.com');
/
--Insert two new records into Customer table
INSERT INTO CUSTOMER
VALUES(60, 'Rebecca', 'Mathon', 'Zara', '123 2nd ave', 'New York', 'NY', 'USA', '10002', '+1 (888) 888-8888', '+1 (555) 666-7777', 'rebecca@aol.com', 5);
/
INSERT INTO Customer
VALUES(61, 'Janet', 'Smith', 'Dunder-Miflan', '555 2nd ave', 'New York', 'NY', 'USA', '10002', '+1 (288) 838-8588', '+1 (155) 626-4777', 'janet@aol.com', 5);
/

--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR' 
WHERE ARTISTID = 76;

--2.5 LIKE
--Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE 
WHERE TOTAL BETWEEN 15 AND 50;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' and '01-MAR-04';

--2.7 DELETE
--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)
DELETE FROM CUSTOMER
WHERE CUSTOMERID = 32;
/
DELETE FROM INVOICE
WHERE CUSTOMERID = 32;
/
DELETE FROM INVOICELINE 
WHERE INVOICEID = 116;
/
--Had to delete all records of it in the other tables as well via foreign keys. 

-- 3 SQL Functions
--3.1 System Defined Functions
--Create a function that returns the current time.
CREATE OR REPLACE FUNCTION TIME_NOW
RETURN TIMESTAMP IS 
M TIMESTAMP;
BEGIN
    M := SYSDATE;
    RETURN(M);
END;
/
SELECT TIME_NOW() FROM DUAL;

--create a function that returns the length of name in MEDIATYPE table 
CREATE OR REPLACE FUNCTION GET_LENGTH(M_ID IN NUMBER)
RETURN NUMBER IS
M_LENGTH NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO M_LENGTH FROM MEDIATYPE WHERE MEDIATYPEID = M_ID;
    RETURN(M_LENGTH);
END;
/
SELECT GET_LENGTH(4) FROM DUAL;

--3.2 System Defined Aggregate Functions
--Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MAX_PRICE
RETURN NUMBER IS
H_PRICE NUMBER;
BEGIN
    SELECT MAX(UNITPRICE) INTO H_PRICE FROM TRACK;
    RETURN(H_PRICE);
END;
/
SELECT MAX_PRICE() FROM DUAL;

--3.3 User Defined Scalar Functions
--Create a function that returns the average price of invoice line items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICE
RETURN NUMBER IS
AVG_ITEM NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AVG_ITEM FROM INVOICELINE;
    RETURN(AVG_ITEM);
END;
/
SELECT AVG_INVOICE() FROM DUAL;

--3.4 User Defined Table Valued Functions
--Create a function that returns all employees who were born after 1968.
CREATE OR REPLACE FUNCTION BORN_AFTER
RETURN SYS_REFCURSOR IS
CUR_VAL SYS_REFCURSOR;
BEGIN
    OPEN CUR_VAL FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE
    WHERE BIRTHDATE > '12-DEC-1967';
    RETURN CUR_VAL;
END;
/
DECLARE --To test the function. 
CUR_VAL SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE; 
LAST_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    CUR_VAL := BORN_AFTER;
    LOOP
    FETCH CUR_VAL INTO FIRST_NAME, LAST_NAME; 
    EXIT WHEN CUR_VAL%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('First Name : '||FIRST_NAME||', Last Name: '||LAST_NAME);
    END LOOP;
    CLOSE CUR_VAL;
END;  

--4.0 Stored Procedures
--4.1 Basic Stored Procedure
--Create a stored procedure that selects the first and last names of all the employees
CREATE OR REPLACE PROCEDURE GET_NAME(CUR_VAL OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN CUR_VAL FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE --To test the procedure. 
CUR_VAL SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE; 
LAST_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    GET_NAME(CUR_VAL);
    LOOP
    FETCH CUR_VAL INTO FIRST_NAME, LAST_NAME; 
    EXIT WHEN CUR_VAL%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('First Name : '||FIRST_NAME||', Last Name: '||LAST_NAME);
    END LOOP;
    CLOSE CUR_VAL;
END;

--4.2 Stored Procedure Input Parameters
--Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPL(E_ID IN NUMBER, L_NAME IN VARCHAR2, F_NAME IN VARCHAR2, ADD_RESS IN VARCHAR2, CI_TY IN VARCHAR2, STA_TE IN VARCHAR2, COUN_TRY IN VARCHAR2, ZIP_CODE IN VARCHAR2, P_NUM IN VARCHAR2, F_NUM IN VARCHAR2, E_MAIL IN VARCHAR2)
IS
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = L_NAME, FIRSTNAME = F_NAME, 
    ADDRESS = ADD_RESS, CITY = CI_TY, STATE = STA_TE, COUNTRY = COUN_TRY, 
    POSTALCODE = ZIP_CODE, PHONE = P_NUM, FAX = F_NUM, EMAIL = E_MAIL
    WHERE EMPLOYEEID = E_ID;
    COMMIT;
END;
/
EXECUTE UPDATE_EMPL(10, 'SINGH', 'TANDI', '115-22 128TH ST', 'OZONE PARK', 'NY', 'USA', '11418', '+1 (111) 111-1111', '+1 (151) 151-151', 'tandi@chinookcorp.com');
SELECT ADDRESS FROM EMPLOYEE 
WHERE EMPLOYEEID = 10; --TO CHECK IF ADDRESS CHANGED RATHER THEN JUST LOOKNG AT TABLE. 

--Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE IS_MANAGER(E_ID IN NUMBER, M_ID OUT NUMBER)
IS
BEGIN
    SELECT REPORTSTO INTO M_ID FROM EMPLOYEE 
    WHERE EMPLOYEEID = E_ID;
END;
/
DECLARE
    E_ID EMPLOYEE.EMPLOYEEID%TYPE;
    M_ID EMPLOYEE.REPORTSTO%TYPE;
BEGIN
    IS_MANAGER(5, M_ID);
    DBMS_OUTPUT.PUT_LINE('The manager of this Employee is Manager '||M_ID); --To test it. 
END;

--4.3 Stored Procedure Output Parameters
--Create a stored procedure that returns the name and company of a customer
CREATE OR REPLACE PROCEDURE CUST_INFO(CUST_ID IN NUMBER, F_NAME OUT VARCHAR2, L_NAME OUT VARCHAR2, COM_P OUT VARCHAR2)
IS
BEGIN
    SELECT FIRSTNAME INTO F_NAME FROM CUSTOMER
    WHERE CUSTOMERID = CUST_ID;
    SELECT LASTNAME INTO L_NAME FROM CUSTOMER
    WHERE CUSTOMERID = CUST_ID;
    SELECT COMPANY INTO COM_P FROM CUSTOMER
    WHERE CUSTOMERID = CUST_ID;
END;
/
DECLARE
    F_NAME CUSTOMER.FIRSTNAME%TYPE;
    L_NAME CUSTOMER.LASTNAME%TYPE;
    COM_P CUSTOMER.COMPANY%TYPE;
    CUST_ID CUSTOMER.CUSTOMERID%TYPE;
BEGIN
    CUST_INFO(60, F_NAME, L_NAME, COM_P);
    DBMS_OUTPUT.PUT_LINE('First Name: '||F_NAME||' ,Last Name: '||L_NAME||' ,Company: '||COM_P); --To test it. 
END;

--5.0 Transactions
--Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE INV_DEL(I_ID IN NUMBER)
IS
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = I_ID;

    DELETE FROM INVOICE WHERE INVOICEID = I_ID; --Have to delete it from everywhere to avoid the constraint. 
END;
/
EXECUTE INV_DEL(113);

--6.1 AFTER/FOR
--Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER NEW_EMPLOYEE
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Employee!!!');
END;
/

INSERT INTO EMPLOYEE
VALUES(11, 'Nemo', 'Fish', 'IT Staff', 6, TO_DATE('2000-09-28', 'YYYY-MM-DD'), TO_DATE('2016-12-12', 'YYYY-MM-DD'), '183-15 89TH AVE', 'Hollis', 'NY', 'USA', '11423', '+1 (777) 777-7477', '+1 (777) 777-7477', 'fish@chinook.com');

--Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER NEW_ALBUM
AFTER INSERT ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('New ALBUM!!!');
END;
/
INSERT INTO ALBUM
VALUES(348, 'Avenue', 88);
--Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER LOST_CUSTOMER
AFTER DELETE ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer is no longer with us');
END;
/
DELETE FROM CUSTOMER
WHERE CUSTOMERID = 61; --Works without having to delete from other tables because I created this customer and her id isn't in other tables. 

--7.0 JOINS
--7.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FIRSTNAME AS FIRSTNAME, LASTNAME AS LASTNAME, INVOICEID AS INVOICEID FROM CUSTOMER 
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
ORDER BY LASTNAME;

--7.2 OUTER
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID AS CUSTOMERID, FIRSTNAME AS FIRSTNAME, LASTNAME AS LASTNAME, INVOICEID AS INVOICEID, TOTAL AS TOTAL FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
ORDER BY LASTNAME;

--7.3 RIGHT
--Create a right join that joins album and artist specifying artist name and title.
SELECT NAME AS NAME, TITLE AS TITLE FROM ALBUM
RIGHT OUTER JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4 CROSS
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;
--7.5 SELF
--Perform a self-join on the employee table, joining on the reportsto column
SELECT
    (A.FIRSTNAME || ' ' || A.LASTNAME) EMPLOYEE,
    (B.FIRSTNAME || ' ' || B.LASTNAME) REPORTS_TO
FROM EMPLOYEE A
LEFT JOIN EMPLOYEE B ON A.REPORTSTO = B.EMPLOYEEID;



