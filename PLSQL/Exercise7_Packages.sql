--Scenario 1: CustomerManagement Package
CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_id NUMBER,
        p_balance NUMBER
    );

    FUNCTION GetCustomerBalance(
        p_id NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Customers
        VALUES(
            p_id,
            p_name,
            p_dob,
            p_balance,
            SYSDATE,
            'FALSE'
        );
    END;

    PROCEDURE UpdateCustomer(
        p_id NUMBER,
        p_balance NUMBER
    )
    IS
    BEGIN
        UPDATE Customers
        SET Balance = p_balance
        WHERE CustomerID = p_id;
    END;

    FUNCTION GetCustomerBalance(
        p_id NUMBER
    )
    RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_id;

        RETURN v_balance;
    END;

END CustomerManagement;
/
SELECT CustomerManagement.GetCustomerBalance(1)
FROM dual;

--Scenario 2: EmployeeManagement Package
CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    );

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    )
    IS
    BEGIN
        INSERT INTO Employees
        VALUES(
            p_id,
            p_name,
            p_position,
            p_salary,
            p_department,
            SYSDATE
        );
    END;

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    )
    RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_id;

        RETURN v_salary * 12;
    END;

END EmployeeManagement;
/
SELECT EmployeeManagement.CalculateAnnualSalary(1)
FROM dual;

--Scenario 3: AccountOperations Package
CREATE OR REPLACE PACKAGE AccountOperations AS

    FUNCTION GetTotalBalance(
        p_customerid NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    FUNCTION GetTotalBalance(
        p_customerid NUMBER
    )
    RETURN NUMBER
    IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customerid;

        RETURN NVL(v_total,0);
    END;

END AccountOperations;
/
SELECT AccountOperations.GetTotalBalance(1)
FROM dual;