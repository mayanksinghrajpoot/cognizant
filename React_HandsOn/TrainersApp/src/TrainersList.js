import React from 'react';
import { Link } from 'react-router-dom';
function TrainersList({ data }) {
  return (
    <div>
      <h2>Trainers List</h2>
      <ul>
        {data.map(t => (
          <li key={t.TrainerId}>
            <Link to={`/trainers/${t.TrainerId}`}>{t.Name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}
export default TrainersList;
