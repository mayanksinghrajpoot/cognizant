import React from 'react';
import CalculateScore from './components/CalculateScore';
function App() {
  return (
    <div>
      <CalculateScore Name="John Doe" School="Greenwood High" Total={450} goal="Passing with distinction" />
    </div>
  );
}
export default App;
