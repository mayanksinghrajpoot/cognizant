import React from 'react';
import '../stylesheets/mystyle.css';
function CalculateScore({ Name, School, Total, goal }) {
  const average = Total / 5;
  return (
    <div className="score-box">
      <h2>Student Score</h2>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total:</strong> {Total}</p>
      <p><strong>Average:</strong> {average}</p>
      <p><strong>Goal:</strong> {goal}</p>
    </div>
  );
}
export default CalculateScore;
