--Scenario 1: GenerateMonthlyStatements
CREATE OR REPLACE PROCEDURE GenerateMonthlyStatements
IS
    CURSOR c_accounts IS
        SELECT AccountID, CustomerID, Balance
        FROM Accounts;
BEGIN
    FOR acc IN c_accounts LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Account ID: ' || acc.AccountID ||
            ' Customer ID: ' || acc.CustomerID ||
            ' Balance: ' || acc.Balance
        );
    END LOOP;
END;
/
BEGIN
    GenerateMonthlyStatements;
END;
/

--Scenario 2: ApplyAnnualFee
CREATE OR REPLACE PROCEDURE ApplyAnnualFee
IS
    CURSOR c_accounts IS
        SELECT AccountID
        FROM Accounts
        WHERE AccountType = 'Savings';
BEGIN
    FOR acc IN c_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - 100
        WHERE AccountID = acc.AccountID;
    END LOOP;

    COMMIT;
END;
/
BEGIN
    ApplyAnnualFee;
END;
/
SELECT * FROM Accounts;

--Scenario 3: UpdateLoanInterestRates
CREATE OR REPLACE PROCEDURE UpdateLoanInterestRates
IS
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;
BEGIN
    FOR loan_rec IN c_loans LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = loan_rec.LoanID;
    END LOOP;

    COMMIT;
END;
/
BEGIN
    UpdateLoanInterestRates;
END;
/
SELECT * FROM Loans;