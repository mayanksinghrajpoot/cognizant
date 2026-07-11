import React from 'react';
function IndianPlayers({ players }) {
  const [first, second, third, fourth, ...rest] = players;
  const oddPlayers = [first, third];
  const evenPlayers = [second, fourth];
  
  const t20 = ['Virat Kohli', 'Rohit Sharma'];
  const ranji = ['Pujara', 'Rahane'];
  const merged = [...t20, ...ranji];

  return (
    <div>
      <h3>Destructured Odd Team Players</h3>
      <ul>{oddPlayers.map((p, i) => <li key={i}>{p?.name}</li>)}</ul>
      <h3>Destructured Even Team Players</h3>
      <ul>{evenPlayers.map((p, i) => <li key={i}>{p?.name}</li>)}</ul>
      <h3>Merged Team Players</h3>
      <ul>{merged.map((p, i) => <li key={i}>{p}</li>)}</ul>
    </div>
  );
}
export default IndianPlayers;
