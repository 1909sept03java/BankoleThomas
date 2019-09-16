CREATE DATABASE Infiknight;

CREATE TABLE Employee (
    Employee_ID INTEGER,
    Emp_FIRSTNAME VARCHAR2(20),
    Emp_LASTNAME VARCHAR2(20),
    Department_ID Integer Primary Key,
    Salary integer,
    Emp_Email varchar(20)
    
);

CREATE TABLE Department ( 
    Department_ID Integer ,
    Department_Name varchar(20)
);

CREATE SEQUENCE climber
MINVALUE 1
START WITH 50
INCREMENT BY 1
CACHE 10;

CREATE SEQUENCE money
MINVALUE 1
START WITH 100
INCREMENT BY 1
CACHE 10;

CREATE OR REPLACE TRIGGER NEW_EMP
AFTER INSERT ON EMPLOYEE
BEGIN
INSERT INTO Employee (Emp_FIRSTNAME,Emp_LASTNAME, Department_ID,Salary,Emp_Email) VALUES (climber.nextVal,'Phoenix','Thomas',money.nextVal,'@gmail');
INSERT INTO Employee (Emp_FIRSTNAME,Emp_LASTNAME, Department_ID,Salary,Emp_Email) VALUES (climber.nextVal,'Tsukasa','Thomas',money.nextVal,'@gmail');
INSERT INTO Employee (Emp_FIRSTNAME,Emp_LASTNAME, Department_ID,Salary,Emp_Email) VALUES (climber.nextVal,'Valdiso','Thomas',money.nextVal,'@gmail');
INSERT INTO Employee (Emp_FIRSTNAME,Emp_LASTNAME, Department_ID,Salary,Emp_Email) VALUES (climber.nextVal,'Wanderlei','Thomas',money.nextVal,'@gmail');
INSERT INTO Employee (Emp_FIRSTNAME,Emp_LASTNAME, Department_ID,Salary,Emp_Email) VALUES (climber.nextVal,'Angenai','Thomas',money.nextVal,'@gmail');
INSERT INTO Employee (Emp_FIRSTNAME,Emp_LASTNAME, Department_ID,Salary,Emp_Email) VALUES (climber.nextVal,'Angelay','Thomas',money.nextVal,'@gmail');
END;

--Create a stored procedure SP_GIVE_RAISE which takes in a DEPARTMENT_ID and increases each employee's salary within 
--the department by 10%, and returns the new average salary for the department, as well as a 
--boolean value indicating whether the ID entered corresponds to a valid department. 

CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE(DEPT_ID IN INTEGER, AVG_SAL OUT NUMBER, IS_ID_VALID OUT NUMBER)
IS
DEPT_EXISTS NUMBER;
BEGIN
    SELECT COUNT(DEPT_ID)
    INTO DEPT_EXISTS
    FROM DEPARTMENT
    WHERE DEPARTMENT_ID = DEPT_ID;
    IF DEPT_EXISTS > 0 THEN
        UPDATE EMPLOYEE 
        SET SALARY = SALARY + (SALARY*0.1)
        WHERE DEPARTMENT_ID = DEPT_ID;
        SELECT AVG(SALARY)
        INTO AVG_SAL
        FROM EMPLOYEE
        WHERE DEPARTMENT_ID = DEPT_ID;
    ELSE 
    AVG_SAL := 0;
    IS_ID_VALID := 0;
    END IF;
    COMMIT;
    
END;

