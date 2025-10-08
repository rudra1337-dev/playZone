const express = require(`express`);
const jwt = require(`jsonwebtoken`);

const app = express();
app.use(express.json());


app.use((req,res,next)=>{
	console.log("Entered in middleware");
	next();
});



const USER  = {
		name: "Rudra",
		age: 18,
		password: 1337
	};

const key = "1234567890";



app.post(`/login`, (req,res)=>{

	const {userName, Password} = req.body;

	if(USER.name == userName && USER.password == Password){

		const token = jwt.sign(USER , key, {subject: "testing"});

		res.json({Message: `Welcome ${userName}!`, token});
	}else{
		res.status(404).json({Error: "User not found"});
	}
});




const tokenVerification = (req,res,next)=>{

	const authHeader = req.headers[`authorization`];
	const token = authHeader && authHeader.split(" ")[1];

	jwt.verify(token, key, (err, decoded)=>{
		if(err){
			res.status(404).json({Error: err});
		}else{
			req.user = decoded;
		}
	});
	next();
};



app.get(`/profile`, tokenVerification, (req,res)=>{

	res.json({
		Message: `Welcome ${req.user.name}`,
		UserDetails: req.user
		});
});

app.get(`/token`, (req,res)=>{

	const authHeader = req.headers[`authorization`];
	const token = authHeader && authHeader.split(" ")[1];

	if(token){
		const user = jwt.decode(token);
		res.json({User: user});
	}else{
		res.status(404).json({Error: "Invalid token"});
	}
});



app.listen(3000, ()=>console.log("Listening on port no 3000"));
