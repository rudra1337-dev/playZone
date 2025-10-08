const express = require(`express`);
7
const app = express();

app.get(`/hed`,(req,res)=>{
	console.log(req.headers);
	res.send(req.headers);
});

app.get(`/hed1`,(req,res)=>{
	console.log(req.get(`User-Agent`));
	res.send(req.headers[`user-agent`]);
});

app.listen(3000,()=> console.log(`Server runing on port 3000`));
