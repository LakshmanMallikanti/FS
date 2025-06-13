import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="bg-gray-800 p-4 text-white flex gap-4">
      <Link to="/">Greetings</Link>
      <Link to="/counter">Counter</Link>
    </nav>
  );
};

const Greetings = () => {
  return <h2 className="p-4 text-xl">Hello there! 👋</h2>;
};

const Counter = () => {
  const [count, setCount] = React.useState(0);
  return (
    <div className="p-4">
      <h2 className="text-xl mb-2">Count: {count}</h2>
      <button
        onClick={() => setCount(count + 1)}
        className="bg-blue-500 text-white px-4 py-2 rounded"
      >
        Increment
      </button>
    </div>
  );
};

const App = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Greetings />} />
        <Route path="/counter" element={<Counter />} />
      </Routes>
    </Router>
  );
};

export default App;
