import React, { useState } from 'react';
function ComplaintRegister() {
  const [name, setName] = useState('');
  const [complaint, setComplaint] = useState('');
  const handleSubmit = (e) => {
    e.preventDefault();
    const referenceNumber = Math.floor(Math.random() * 900000) + 100000;
    alert(`Complaint submitted successfully!\nEmployee: ${name}\nReference ID: REF-${referenceNumber}`);
    setName('');
    setComplaint('');
  };
  return (
    <form onSubmit={handleSubmit} style={{ padding: 20 }}>
      <h2>Raise a Complaint</h2>
      <div>
        <label>Employee Name: </label>
        <br />
        <input type="text" value={name} onChange={e => setName(e.target.value)} required />
      </div>
      <div style={{ marginTop: 10 }}>
        <label>Complaint Details: </label>
        <br />
        <textarea value={complaint} onChange={e => setComplaint(e.target.value)} required />
      </div>
      <button type="submit" style={{ marginTop: 10 }}>Submit Complaint</button>
    </form>
  );
}
export default ComplaintRegister;
