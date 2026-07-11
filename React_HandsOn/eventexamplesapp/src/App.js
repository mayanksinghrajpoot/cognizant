import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';
function App() {
  const [counter, setCounter] = useState(0);

  const handleIncrement = () => {
    setCounter(prev => prev + 1);
    alert('Hello! The counter value is increased.');
  };

  const handleDecrement = () => {
    setCounter(prev => prev - 1);
  };

  const sayWelcome = (msg) => {
    alert('Welcome Message: ' + msg);
  };

  const handleSynthetic = (e) => {
    alert('I was clicked! Synthetic Event Type: ' + e.type);
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>Event Examples App</h2>
      <div>
        <button onClick={handleIncrement}>Increment</button>
        <button onClick={handleDecrement} style={{ marginLeft: 10 }}>Decrement</button>
        <p>Counter: {counter}</p>
      </div>
      <hr />
      <button onClick={() => sayWelcome('welcome')}>Say Welcome</button>
      <button onClick={handleSynthetic} style={{ marginLeft: 10 }}>Synthetic Press</button>
      <hr />
      <CurrencyConvertor />
    </div>
  );
}
export default App;
