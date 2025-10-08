const express = require(`express`);

const app = express();

app.get(`/req/url`,(req,res)=>{
	res.send(`URL: ${req.url} \n METHOD: ${req.method}`);
});

app.listen(3000,()=> console.log(`Server is listening at port 3000`));
