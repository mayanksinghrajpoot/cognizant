import React, { useState } from 'react';

function BookDetails() {
  return <div><h3>Book Details</h3><p>Title: Learning React v18</p><p>Author: Robin Wieruch</p></div>;
}
function BlogDetails() {
  return <div><h3>Blog Details</h3><p>Title: Why React is great</p><p>Reads: 1,200</p></div>;
}
function CourseDetails() {
  return <div><h3>Course Details</h3><p>Title: Full Stack Developer Guide</p><p>Duration: 6 Months</p></div>;
}

function App() {
  const [selectedTab, setSelectedTab] = useState('book');
  let componentToRender;
  if (selectedTab === 'book') componentToRender = <BookDetails />;
  else if (selectedTab === 'blog') componentToRender = <BlogDetails />;
  else componentToRender = <CourseDetails />;

  return (
    <div style={{ padding: 20 }}>
      <h2>Blogger App</h2>
      <div>
        <button onClick={() => setSelectedTab('book')}>Show Book Details</button>
        <button onClick={() => setSelectedTab('blog')} style={{ marginLeft: 10 }}>Show Blog Details</button>
        <button onClick={() => setSelectedTab('course')} style={{ marginLeft: 10 }}>Show Course Details</button>
      </div>
      <hr />
      {componentToRender}
      <hr />
      {selectedTab === 'book' && <p><em>Quick View: Book Tab Active</em></p>}
      {selectedTab === 'blog' && <p><em>Quick View: Blog Tab Active</em></p>}
      {selectedTab === 'course' && <p><em>Quick View: Course Tab Active</em></p>}
    </div>
  );
}
export default App;
