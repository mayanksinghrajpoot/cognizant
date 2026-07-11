import React from 'react';
import Cart from './Cart';
class OnlineShopping extends React.Component {
  render() {
    const items = [
      { Itemname: 'Laptop', Price: 65000 },
      { Itemname: 'Mobile Phone', Price: 25000 },
      { Itemname: 'Headphones', Price: 3000 },
      { Itemname: 'Smart Watch', Price: 5000 },
      { Itemname: 'Keyboard', Price: 1500 }
    ];
    return (
      <div>
        <h2>Online Shopping Cart</h2>
        <Cart items={items} />
      </div>
    );
  }
}
export default OnlineShopping;
