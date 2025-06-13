// src/components/Navbar.js
import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
  const style = {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    backgroundColor: '#282c34',
    padding: '10px 20px',
    color: 'white',
  };

  return (
    <nav style={style}>
      <h2>
        <Link to="/" style={{ color: 'white', textDecoration: 'none' }}>MyApp</Link>
      </h2>
      <Link to="/counter" style={{ color: 'white', textDecoration: 'none' }}>COUNTER</Link>
    </nav>
  );
}

export default Navbar;
