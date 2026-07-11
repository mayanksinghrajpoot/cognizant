import React from 'react';
import CohortDetails from './CohortDetails';
function App() {
  const cohort1 = { name: 'FSE Java FullStack', code: 'COH001', status: 'ongoing', startDate: '2026-07-01' };
  const cohort2 = { name: 'DotNet FullStack', code: 'COH002', status: 'completed', startDate: '2026-04-01' };
  return (
    <div>
      <CohortDetails cohort={cohort1} />
      <CohortDetails cohort={cohort2} />
    </div>
  );
}
export default App;
