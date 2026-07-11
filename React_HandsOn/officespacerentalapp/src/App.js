import React from 'react';
function App() {
  const officeHeader = "Office Space Rentals";
  const officeImage = "https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=400&h=250";
  const mainOffice = { Name: "Central Headquarters", Rent: 75000, Address: "123 Main St, Tech City" };
  const officeList = [
    { Name: "Co-Working Station", Rent: 45000, Address: "456 Innovation Ave" },
    { Name: "Executive Suite", Rent: 85000, Address: "789 Corporate Blvd" },
    { Name: "StartUp Lab", Rent: 55000, Address: "321 Hatchery Ln" }
  ];

  return (
    <div style={{ padding: 20 }}>
      <h2>{officeHeader}</h2>
      <img src={officeImage} alt="Office Space" style={{ borderRadius: 8, maxWidth: '100%' }} />
      <div style={{ marginTop: 20 }}>
        <h3>Featured Space: {mainOffice.Name}</h3>
        <p><strong>Address:</strong> {mainOffice.Address}</p>
        <p><strong>Rent: </strong>
          <span style={{ color: mainOffice.Rent > 60000 ? 'green' : 'red', fontWeight: 'bold' }}>
            INR {mainOffice.Rent}
          </span>
        </p>
      </div>
      <hr />
      <h3>Other Spaces Available</h3>
      {officeList.map((off, idx) => (
        <div key={idx} style={{ marginBottom: 15 }}>
          <h4>{off.Name}</h4>
          <p>{off.Address}</p>
          <p>Rent: 
            <span style={{ color: off.Rent > 60000 ? 'green' : 'red', fontWeight: 'bold' }}>
              &nbsp;INR {off.Rent}
            </span>
          </p>
        </div>
      ))}
    </div>
  );
}
export default App;
