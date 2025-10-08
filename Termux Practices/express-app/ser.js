const express = require(`express`);

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true}));


app.post(`/data`,(req,res)=>{
	res.json(req.body);
});

app.post(`/submit`,(req,res)=>{
	res.json(req.body);
});

app.listen(3000);
