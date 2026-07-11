import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';
import './App.css';

function App() {
  const [theme, setTheme] = useState('light');
  const employees = [
    { id: 1, name: 'Alice Smith', position: 'Software Engineer' },
    { id: 2, name: 'Bob Johnson', position: 'UI Designer' }
  ];
  return (
    <ThemeContext.Provider value={theme}>
      <div style={{ padding: 20, background: theme === 'dark' ? '#333' : '#fff', color: theme === 'dark' ? '#fff' : '#000' }}>
        <h2>Employee Management App</h2>
        <button onClick={() => setTheme(prev => prev === 'light' ? 'dark' : 'light')}>
          Toggle Theme (Current: {theme})
        </button>
        <EmployeesList employees={employees} />
      </div>
    </ThemeContext.Provider>
  );
}
export default App;
