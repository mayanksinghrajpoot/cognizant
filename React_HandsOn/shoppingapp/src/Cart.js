import React from 'react';
class Cart extends React.Component {
  render() {
    return (
      <table border="1" cellPadding="5">
        <thead>
          <tr>
            <th>Item Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {this.props.items.map((item, idx) => (
            <tr key={idx}>
              <td>{item.Itemname}</td>
              <td>{item.Price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}
export default Cart;
