import React from 'react';
import EmployeeCard from './EmployeeCard';
function EmployeesList({ employees }) {
  return (
    <div>
      <h3>Employees Directory</h3>
      {employees.map(e => <EmployeeCard key={e.id} employee={e} />)}
    </div>
  );
}
export default EmployeesList;
