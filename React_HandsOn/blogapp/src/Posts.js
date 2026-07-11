import React from 'react';
class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }
  componentDidMount() {
    this.loadPosts();
  }
  componentDidCatch(error, info) {
    this.setState({ error: error.message });
    alert('An error occurred in Posts component: ' + error.message);
  }
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) throw new Error('Http error: ' + response.status);
        return response.json();
      })
      .then(data => this.setState({ posts: data }))
      .catch(err => {
        this.setState({ error: err.message });
      });
  }
  render() {
    if (this.state.error) {
      return <div>Error: {this.state.error}</div>;
    }
    return (
      <div>
        <h2>Posts List</h2>
        <ul>
          {this.state.posts.slice(0, 10).map(post => (
            <li key={post.id}>
              <h3>{post.title}</h3>
              <p>{post.body}</p>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}
export default Posts;
