--CREATE THE TWO TABLES. 

CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID INTEGER PRIMARY KEY, 
    EMP_FIRSTNAME VARCHAR2(20),
    EMP_LASTNAME VARCHAR2(20),
    DEPARTMENT_ID INTEGER, 
    SALARY INTEGER, 
    EMP_EMAIL VARCHAR2(50)
);
/
CREATE TABLE DEPARTMENT (
    DEPARTMENT_ID INTEGER PRIMARY KEY,
    DEPARTMENT_NAME VARCHAR2(50)
);
/
--Foreign Key Constraint

ALTER TABLE Employee
ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT
FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID);
/

ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_CAVE
FOREIGN KEY (CAVE_ID) REFERENCES CAVE(CAVE_ID);
/
--CREATE THE SEQUENCES FOR PRIMARY KEYS.
CREATE SEQUENCE SQ_EMPLOYEE_PK
START WITH 1
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_DEPARTMENT_PK
START WITH 1
INCREMENT BY 1;
/

--Now create trigger to make use of this sequence. 
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
BEFORE INSERT ON EMPLOYEE 
FOR EACH ROW
BEGIN
    SELECT SQ_EMPLOYEE_PK.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TR_INSERT_DEPARTMENT
BEFORE INSERT ON DEPARTMENT  
FOR EACH ROW
BEGIN
    SELECT SQ_DEPARTMENT_PK.NEXTVAL INTO :NEW.DEPARTMENT_ID FROM DUAL;
END;
/

INSERT ALL
INTO DEPARTMENT (DEPARTMENT_NAME)
VALUES('Chemistry')
INTO DEPARTMENT (DEPARTMENT_NAME)
VALUES('Computer Science')
INTO DEPARTMENT (DEPARTMENT_NAME)
VALUES('Biology')
SELECT * FROM DUAL;

INSERT ALL
INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Gurvir', 'Singh', 2, 100000, 'gurvir@gmail.com')
INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Rebecca', 'Singh', 1, 80000, 'rebecca@gmail.com')
INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Rehana', 'Rohman', 3, 60000, 'rehana@gmail.com')
INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Johnathan', 'Thompson', 3, 95000, 'johnathan@gmail.com')
INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Shahzeb', 'Leghari', 3, 100000, 'shahzeb@gmail.com')
INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Shiamoon', 'Islam', 1, 110000, 'shiamoon@gmail.com')
SELECT * FROM DUAL;

--Create the stored procedure to increase salary.
CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE(D_ID IN NUMBER, N_AVG OUT NUMBER, VALID_ID OUT BOOLEAN)
IS
D_Count INTEGER;
S SYS_REFCURSOR;
NEW_SAL INTEGER;
BEGIN
  SELECT COUNT(DEPARTMENT_ID) INTO D_COUNT FROM DEPARTMENT;
  IF D_ID > 0 AND D_ID <= D_COUNT THEN
    VALID_ID := TRUE;
  ELSE 
    VALID_ID := FALSE; 
  END IF;
  
  OPEN S FOR SELECT SALARY FROM EMPLOYEE WHERE DEPARTMENT_ID = D_ID;
  IF VALID_ID THEN
    LOOP
        FETCH S INTO NEW_SAL;
        EXIT WHEN S%NOTFOUND;
        UPDATE EMPLOYEE SET SALARY = NEW_SAL * 1.1;
    END LOOP;
  END IF;
  CLOSE S;
  SELECT AVG(SALARY) INTO N_AVG FROM EMPLOYEE WHERE DEPARTMENT_ID = D_ID;
END; 
/

