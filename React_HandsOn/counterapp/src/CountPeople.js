import React from 'react';
class CountPeople extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }
  UpdateEntry = () => {
    this.setState(prev => ({ entrycount: prev.entrycount + 1 }));
  }
  UpdateExit = () => {
    this.setState(prev => ({ exitcount: prev.exitcount + 1 }));
  }
  render() {
    return (
      <div style={{ margin: 20 }}>
        <button onClick={this.UpdateEntry}>Login (Enter)</button>
        <button onClick={this.UpdateExit} style={{ marginLeft: 10 }}>Exit</button>
        <p>People Entered: {this.state.entrycount}</p>
        <p>People Exited: {this.state.exitcount}</p>
      </div>
    );
  }
}
export default CountPeople;
