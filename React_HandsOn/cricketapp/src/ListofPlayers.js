import React from 'react';
function ListofPlayers({ players }) {
  const filtered = players.filter(p => p.score >= 70);
  return (
    <div>
      <h3>Players scoring 70 and above</h3>
      <ul>
        {filtered.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
}
export default ListofPlayers;
