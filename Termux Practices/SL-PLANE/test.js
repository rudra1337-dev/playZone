// server.js
const express = require('express');
const jwt = require('jsonwebtoken');

const app = express();
app.use(express.json());

const SECRET_KEY = 'rudraSecret123';

// Fake user (replace with DB in real apps)
const user = {
  id: 1,
  username: 'rudra',
  password: '1234'
};

// Login Route - jwt.sign()
app.post('/login', (req, res) => {
  const { username, password } = req.body;

  if (username === user.username && password === user.password) {
    // Create JWT token with user data
    const token = jwt.sign(
      { id: user.id, username: user.username },
      SECRET_KEY,
      { expiresIn: '1h' }
    );
    res.json({ message: 'Login successful', token });
  } else {
    res.status(401).json({ message: 'Invalid credentials' });
  }
});

// Middleware to verify token - jwt.verify()
function verifyToken(req, res, next) {
  const authHeader = req.headers['authorization'];
  const token = authHeader && authHeader.split(' ')[1];

  if (!token) return res.status(403).json({ message: 'No token provided' });

  jwt.verify(token, SECRET_KEY, (err, decoded) => {
    if (err) return res.status(403).json({ message: 'Invalid token' });

    req.user = decoded; // Put user data into req.user
    next();
  });
}

// Protected Route - uses jwt.verify()
app.get('/dashboard', verifyToken, (req, res) => {
  res.json({
    message: `Welcome, ${req.user.username}!`,
    id: req.user.id
  });
});

// Route that decodes token without verifying - jwt.decode()
app.get('/read-token', (req, res) => {
  const token = req.headers['authorization']?.split(' ')[1];
  if (!token) return res.status(400).json({ message: 'Token required' });

  const data = jwt.decode(token);
  res.json({ decodedPayload: data });
});

app.listen(3000, () => {
  console.log('Server running on port 3000');
});
