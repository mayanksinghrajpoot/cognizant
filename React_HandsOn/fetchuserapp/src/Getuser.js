import React from 'react';
class Getuser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true
    };
  }
  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      if (data.results && data.results.length > 0) {
        this.setState({ user: data.results[0], loading: false });
      }
    } catch (err) {
      console.error(err);
      this.setState({ loading: false });
    }
  }
  render() {
    if (this.state.loading) return <p>Loading user details...</p>;
    if (!this.state.user) return <p>Failed to load user details.</p>;
    
    const { name, picture } = this.state.user;
    return (
      <div style={{ border: '1px solid #ccc', padding: 20, maxWidth: 300, margin: '20px auto', textAlign: 'center' }}>
        <img src={picture.large} alt="User Avatar" style={{ borderRadius: '50%' }} />
        <h3>{name.title} {name.first} {name.last}</h3>
      </div>
    );
  }
}
export default Getuser;
