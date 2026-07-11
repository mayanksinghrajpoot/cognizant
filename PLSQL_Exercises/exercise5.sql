-- Exercise 5: Triggers

-- Scenario 1: Trigger UpdateCustomerLastModified.
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :new.LastModified := SYSDATE;
END;
/

-- Scenario 2: Trigger LogTransaction.
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, LogDate, Message)
    VALUES (:new.TransactionID, SYSDATE, 'Transaction of ' || :new.Amount || ' executed on Account ' || :new.AccountID);
END;
/

-- Scenario 3: Trigger CheckTransactionRules.
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :new.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :new.AccountID;
        IF :new.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20002, 'Withdrawal amount exceeds account balance.');
        END IF;
    ELSIF :new.TransactionType = 'Deposit' THEN
        IF :new.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20003, 'Deposit amount must be positive.');
        END IF;
    END IF;
END;
/
