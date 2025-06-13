import React, { useState } from 'react';

const Greeting = () => {
  const [name, setName] = useState('');
  const [greetName, setGreetName] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    setGreetName(name);
    setName('');
  };

  return (
    <div style={{ padding: '20px', maxWidth: '400px', margin: '0 auto' }}>
      <form onSubmit={handleSubmit}>
        <label>
          Enter your name:
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
            style={{ marginLeft: '10px' }}
          />
        </label>
        <button type="submit" style={{ marginLeft: '10px' }}>
          Greet
        </button>
      </form>

      <div
        style={{
          marginTop: '30px',
          padding: '20px',
          border: '2px dashed #aaa',
          borderRadius: '10px',
          minHeight: '60px',
          textAlign: 'center',
          fontSize: '1.2rem',
        }}
      >
        {greetName && <p>Hello! {greetName}, how are you?</p>}
      </div>
    </div>
  );
};

export default Greeting;
