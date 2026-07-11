-- Exercise 2: Error Handling

-- Scenario 1: Stored procedure SafeTransferFunds with exception handling and rollbacks.
CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_src_acc_id IN NUMBER,
    p_dest_acc_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_src_bal NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    -- Check source balance
    SELECT Balance INTO v_src_bal FROM Accounts WHERE AccountID = p_src_acc_id FOR UPDATE;
    
    IF v_src_bal < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    
    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_src_acc_id;
    
    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_dest_acc_id;
    
    -- Log Transaction
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_Seq.NEXTVAL, p_src_acc_id, SYSDATE, -p_amount, 'Transfer');
    
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_Seq.NEXTVAL, p_dest_acc_id, SYSDATE, p_amount, 'Transfer');

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred ' || p_amount || ' from Account ' || p_src_acc_id || ' to Account ' || p_dest_acc_id);

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in Account ' || p_src_acc_id);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both Account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('System Error: ' || SQLERRM);
END SafeTransferFunds;
/

-- Scenario 2: Stored procedure UpdateSalary handling employee ID not found exception.
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_emp_id IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_current_salary NUMBER;
    emp_not_found EXCEPTION;
BEGIN
    -- Try to fetch employee salary
    SELECT Salary INTO v_current_salary FROM Employees WHERE EmployeeID = p_emp_id FOR UPDATE;
    
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_percentage / 100))
    WHERE EmployeeID = p_emp_id;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully updated salary of Employee ' || p_emp_id || ' by ' || p_percentage || '%.');
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_emp_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('System Error: ' || SQLERRM);
END UpdateSalary;
/

-- Scenario 3: Stored procedure AddNewCustomer handling duplicate ID.
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_cust_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
    VALUES (p_cust_id, p_name, p_dob, p_balance, SYSDATE, 'FALSE');
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully added new customer: ' || p_name || ' with ID ' || p_cust_id);
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_cust_id || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('System Error: ' || SQLERRM);
END AddNewCustomer;
/
