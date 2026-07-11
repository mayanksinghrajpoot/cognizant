import React from 'react';
class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: 0,
      euros: 0
    };
  }
  handleChange = (e) => {
    this.setState({ rupees: e.target.value });
  }
  handleSubmit = (e) => {
    e.preventDefault();
    const euroVal = Number(this.state.rupees) * 0.011;
    this.setState({ euros: euroVal });
  }
  render() {
    return (
      <form onSubmit={this.handleSubmit} style={{ marginTop: 20 }}>
        <h3>Currency Convertor (Rupees to Euro)</h3>
        <input type="number" placeholder="Enter Rupees" value={this.state.rupees} onChange={this.handleChange} />
        <button type="submit">Convert</button>
        {this.state.euros > 0 && <p>Euros: {this.state.euros.toFixed(2)}</p>}
      </form>
    );
  }
}
export default CurrencyConvertor;
