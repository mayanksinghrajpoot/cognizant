import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';
function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);
  const btnClass = theme === 'dark' ? 'btn-dark' : 'btn-light';
  return (
    <div style={{ border: '1px solid gray', padding: 10, margin: 10, borderRadius: 5 }}>
      <h4>{employee.name}</h4>
      <p>Position: {employee.position}</p>
      <button className={btnClass}>View Details</button>
    </div>
  );
}
export default EmployeeCard;
