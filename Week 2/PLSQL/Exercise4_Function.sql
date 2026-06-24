--Scenario 1: CalculateAge
CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob DATE
)
RETURN NUMBER
IS
BEGIN
    RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob)/12);
END;
/
SELECT CalculateAge(
       TO_DATE('1985-05-15','YYYY-MM-DD'))
FROM dual;

--Scenario 2: CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount NUMBER,
    p_interest_rate NUMBER,
    p_years NUMBER
)
RETURN NUMBER
IS
    v_monthly_rate NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate/(12*100);
    v_months := p_years*12;

    v_emi :=
    (p_loan_amount*v_monthly_rate*
    POWER(1+v_monthly_rate,v_months))
    /(POWER(1+v_monthly_rate,v_months)-1);

    RETURN ROUND(v_emi,2);
END;
/
SELECT CalculateMonthlyInstallment(
       5000,5,5)
FROM dual;

--Scenario 3: HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_accountid NUMBER,
    p_amount NUMBER
)
RETURN VARCHAR2
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_accountid;

    IF v_balance >= p_amount THEN
        RETURN 'TRUE';
    ELSE
        RETURN 'FALSE';
    END IF;
END;
/
SELECT HasSufficientBalance(
       1,500)
FROM dual;