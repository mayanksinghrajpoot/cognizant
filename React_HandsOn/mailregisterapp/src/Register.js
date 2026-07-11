import React, { useState } from 'react';
function Register() {
  const [fields, setFields] = useState({ name: '', email: '', password: '' });
  const [errors, setErrors] = useState({});
  
  const handleChange = (e) => {
    setFields({ ...fields, [e.target.name]: e.target.value });
  };

  const validate = () => {
    const errs = {};
    if (fields.name.length < 5) {
      errs.name = "Name must have at least 5 characters.";
    }
    if (!fields.email.includes('@') || !fields.email.includes('.')) {
      errs.email = "Email must contain '@' and '.' characters.";
    }
    if (fields.password.length < 8) {
      errs.password = "Password must have at least 8 characters.";
    }
    return errs;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const validationErrors = validate();
    setErrors(validationErrors);
    if (Object.keys(validationErrors).length === 0) {
      alert("Registration Successful!");
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ padding: 20 }}>
      <h2>User Registration Form</h2>
      <div>
        <label>Name: </label>
        <input type="text" name="name" value={fields.name} onChange={handleChange} />
        {errors.name && <p style={{ color: 'red' }}>{errors.name}</p>}
      </div>
      <div style={{ marginTop: 10 }}>
        <label>Email: </label>
        <input type="text" name="email" value={fields.email} onChange={handleChange} />
        {errors.email && <p style={{ color: 'red' }}>{errors.email}</p>}
      </div>
      <div style={{ marginTop: 10 }}>
        <label>Password: </label>
        <input type="password" name="password" value={fields.password} onChange={handleChange} />
        {errors.password && <p style={{ color: 'red' }}>{errors.password}</p>}
      </div>
      <button type="submit" style={{ marginTop: 15 }}>Register</button>
    </form>
  );
}
export default Register;
