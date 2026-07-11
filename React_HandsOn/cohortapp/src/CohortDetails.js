import React from 'react';
import styles from './CohortDetails.module.css';
function CohortDetails({ cohort }) {
  const isOngoing = cohort.status === 'ongoing';
  const headingStyle = {
    color: isOngoing ? 'green' : 'blue'
  };
  return (
    <div className={styles.box}>
      <h3 style={headingStyle}>{cohort.name}</h3>
      <dl>
        <dt>Code</dt>
        <dd>{cohort.code}</dd>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>
      </dl>
    </div>
  );
}
export default CohortDetails;
