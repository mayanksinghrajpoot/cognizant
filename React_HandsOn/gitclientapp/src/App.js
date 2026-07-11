import React, { useState, useEffect } from 'react';
import { GitClient } from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);
  const [username, setUsername] = useState('techiesyed');

  useEffect(() => {
    GitClient.getRepositories(username)
      .then(names => setRepos(names))
      .catch(err => console.error(err));
  }, [username]);

  return (
    <div style={{ padding: 20 }}>
      <h2>Github Repositories for {username}</h2>
      <ul>
        {repos.map((name, idx) => <li key={idx}>{name}</li>)}
      </ul>
    </div>
  );
}
export default App;
