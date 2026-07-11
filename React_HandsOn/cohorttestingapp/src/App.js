import React from 'react';
import CohortDetails from './CohortDetails';
function App() {
  const mockCohort = { code: 'COH001', name: 'FSE Java FullStack', status: 'ongoing' };
  return <CohortDetails cohort={mockCohort} />;
}
export default App;
