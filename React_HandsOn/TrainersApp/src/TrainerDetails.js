import React from 'react';
import { useParams, Link } from 'react-router-dom';
function TrainerDetails({ data }) {
  const { id } = useParams();
  const trainer = data.find(t => t.TrainerId === Number(id));
  if (!trainer) return <h3>Trainer Not Found</h3>;
  return (
    <div>
      <h2>Trainer Details</h2>
      <p><strong>Name:</strong> {trainer.Name}</p>
      <p><strong>Email:</strong> {trainer.Email}</p>
      <p><strong>Phone:</strong> {trainer.Phone}</p>
      <p><strong>Stream:</strong> {trainer.Technology}</p>
      <p><strong>Skills:</strong> {trainer.Skills}</p>
      <Link to="/trainers">Back to List</Link>
    </div>
  );
}
export default TrainerDetails;
