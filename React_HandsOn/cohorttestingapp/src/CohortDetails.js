import React from 'react';
function CohortDetails({ cohort }) {
  if (!cohort) return null;
  return (
    <div className="box">
      <h3>{cohort.code}</h3>
      <dl>
        <dt>Name</dt>
        <dd>{cohort.name}</dd>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
      </dl>
    </div>
  );
}
export default CohortDetails;
