import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetails from './TrainerDetails';
import { trainers } from './TrainersMock';
function App() {
  return (
    <Router>
      <nav style={{ margin: 10 }}>
        <Link to="/" style={{ marginRight: 15 }}>Home</Link>
        <Link to="/trainers">Trainers</Link>
      </nav>
      <hr />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainersList data={trainers} />} />
        <Route path="/trainers/:id" element={<TrainerDetails data={trainers} />} />
      </Routes>
    </Router>
  );
}
export default App;
