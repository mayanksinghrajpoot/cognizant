import React, { useState } from 'react';
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const flights = [
    { id: 1, number: 'AI101', route: 'Delhi to Mumbai', price: 'INR 5000' },
    { id: 2, number: '6E202', route: 'Bangalore to Chennai', price: 'INR 3500' }
  ];
  return (
    <div style={{ padding: 20 }}>
      <h2>Flight Ticket Booking Portal</h2>
      <div>
        {isLoggedIn ? (
          <button onClick={() => setIsLoggedIn(false)}>Logout</button>
        ) : (
          <button onClick={() => setIsLoggedIn(true)}>Login</button>
        )}
      </div>
      <hr />
      {isLoggedIn ? (
        <div>
          <h3>Welcome back, User! Book your flight tickets below.</h3>
          <ul>
            {flights.map(f => (
              <li key={f.id} style={{ margin: '10px 0' }}>
                <strong>{f.number}</strong> ({f.route}) - {f.price} &nbsp;
                <button onClick={() => alert(`Ticket for ${f.number} booked successfully!`)}>Book Now</button>
              </li>
            ))}
          </ul>
        </div>
      ) : (
        <div>
          <h3>Guest Mode: Available Flight Schedules</h3>
          <ul>
            {flights.map(f => (
              <li key={f.id}>{f.number} - {f.route} (Login to Book)</li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}
export default App;
