import React from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';
function App() {
  const players = [
    { name: 'Sachin', score: 95 },
    { name: 'Dhoni', score: 80 },
    { name: 'Rahul', score: 65 },
    { name: 'Sehwag', score: 110 }
  ];
  const flag = true;
  return (
    <div>
      <h2>Cricket Portal</h2>
      {flag ? <ListofPlayers players={players} /> : <IndianPlayers players={players} />}
    </div>
  );
}
export default App;
