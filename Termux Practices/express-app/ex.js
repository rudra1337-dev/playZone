  const cors = require('cors'); 

const express = require('express');
const app = express();

app.use(express.json());
app.use(cors());  // ✅ Allow cross-origin requests

app.listen(3000,()=>{
console.log('server started at 3000 port');
});

app.post('/post',(req,res)=>{
//	res.send(`New user created`);
	let obj={
		Name:"Rudra",
		}
	res.send(JSON.strigify(obj));
});

app.post('/',(req,res)=>{
	let code = `<I>hiiiii</I>`;
	res.send(req.body);
	console.log(req);
});
