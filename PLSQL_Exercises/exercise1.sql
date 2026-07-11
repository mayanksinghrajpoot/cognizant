-- Exercise 1: Control Structures

-- Scenario 1: Loop through all customers, check their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
DECLARE
    v_age NUMBER;
BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.CustomerID, c.DOB, l.InterestRate 
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
    ) LOOP
        v_age := MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12;
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || rec.LoanID || ' for Customer ID: ' || rec.CustomerID);
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Iterate through all customers and set IsVIP flag to 'TRUE' (originally VARCHAR2/Boolean representation) for those with balance over $10,000.
DECLARE
BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance 
        FROM Customers
    ) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Promoted Customer ID: ' || rec.CustomerID || ' to VIP status.');
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Fetch all loans due in the next 30 days and print a reminder message for each customer.
DECLARE
BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ', your Loan ID ' || rec.LoanID || ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
