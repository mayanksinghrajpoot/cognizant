-- Exercise 6: Cursors

-- Scenario 1: Explicit cursor GenerateMonthlyStatements.
DECLARE
    CURSOR c_monthly_statements IS
        SELECT c.CustomerID, c.Name, t.TransactionID, t.Amount, t.TransactionDate, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
    
    v_cust_id Customers.CustomerID%TYPE;
    v_name Customers.Name%TYPE;
    v_trans_id Transactions.TransactionID%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_date Transactions.TransactionDate%TYPE;
    v_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN c_monthly_statements;
    LOOP
        FETCH c_monthly_statements INTO v_cust_id, v_name, v_trans_id, v_amount, v_date, v_type;
        EXIT WHEN c_monthly_statements%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ' (ID: ' || v_cust_id || ') | ' ||
                             'Trans ID: ' || v_trans_id || ' | ' ||
                             'Type: ' || v_type || ' | ' ||
                             'Amount: ' || v_amount || ' | ' ||
                             'Date: ' || TO_CHAR(v_date, 'YYYY-MM-DD'));
    END LOOP;
    CLOSE c_monthly_statements;
END;
/

-- Scenario 2: Explicit cursor ApplyAnnualFee.
DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance 
        FROM Accounts;
        
    v_fee CONSTANT NUMBER := 50; -- Annual Maintenance Fee
BEGIN
    FOR rec IN c_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee, LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;
        
        DBMS_OUTPUT.PUT_LINE('Deducted maintenance fee from Account ID: ' || rec.AccountID);
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Explicit cursor UpdateLoanInterestRates.
DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate 
        FROM Loans
        FOR UPDATE;
        
    v_new_rate NUMBER;
BEGIN
    FOR rec IN c_loans LOOP
        -- Simple policy: reduce interest rate by 0.5% for all loans
        v_new_rate := rec.InterestRate - 0.5;
        
        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF c_loans;
        
        DBMS_OUTPUT.PUT_LINE('Updated Loan ID ' || rec.LoanID || ' Interest Rate to ' || v_new_rate || '%');
    END LOOP;
    COMMIT;
END;
/
