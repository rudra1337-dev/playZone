fetch('http://localhost:3000/json', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'  // Telling the server it's JSON
    },
    body: JSON.stringify({ name: "Rudra", age: 22 })  // Sending data
})
.then(response => response.text())
.then(data => console.log(data));