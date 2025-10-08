const express = require(`express`);
const app = express();
/*

//1 APPLICATION LAVEL

app.use((req,res, next)=>{
	console.log(`Hello from middleware`);
	//next();
	});

app.get(`/`,(req,res)=>{
	res.send(`Hell from rout`);
	});

app.post(`/`,(req,res)=>{
	res,send(`hello from post`);
	});

*/




/*

//2 ROUT LAVEL

const checkApiKey = (req,res,next)=>{
	
	if(req.query.apiKey != 9937){
		return res.status(404).json({error:"Invalid API key"});
	}else{
		return next();
	}

}

app.put(`/protected`,checkApiKey,(req,res)=>{
	res.json({mssage : "Acces granted"});
});



*/



/*


//3 INBUILT MIDDLEWARES

app.use(express.static(`public`));
app.use(express.json());
app.use(express.urlencoded({extended : true}));


app.post(`/submit`,(req,res)=>{
	console.log(req.body);
	res.send(`Data eceived`);
});

*/


app.get(`/test`,(req,res,next)=>{
	let err = new Error(`Somethong went wrong`);
	err.status = 404;
	next(err);
});


app.use((err,req,res,next)=>{
	res.status(err.status || 400).json({Error : err.message});
});



app.listen(3000);


