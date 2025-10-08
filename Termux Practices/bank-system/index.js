const express = require(`express`);
const MongoDB = require(`./db.js`);
const User = require(`./model/user.js`);
const History = require(`./model/history.js`);
const helmet = require(`helmet`);
const bcrypt = require(`bcryptjs`);
const jwt = require(`jsonwebtoken`);
const mongoose = require(`mongoose`);
require(`dotenv`);


const app = express();
app.use(express.json());
app.use(helmet());


app.use((req,res,next)=>{
	console.log("Entered in middleware");
	next();
});



//USER REGISTATION

app.post(`/register`, async (req,res)=>{


	const {name, email, phone, balance, role} = req.body;
	const passwd = await bcrypt.hash(req.body.password,10);

	const user = await User.findOne({Phone: phone});

	if(user){
		res.status(404).json({Error: "User already exist"});
	}

	try{

		const newUser = await User.create({
			Name: name,
			Email: email,
			Phone: phone,
			Balance: balance,
			Role: role,
			Password: passwd
		});

		if(!newUser){
			res.status(405).json({Error: "Invallid details"});
		}

		res.json({Message: "User cteates successful" , User: newUser});

	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}

});



//ACCOUNT LOGIN

app.post(`/login`, async (req,res)=>{
try{
	const {phone, password} = req.body;
	const user = await User.findOne({Phone: phone});

	if(!user){
		res.status(404).json({Error: "User not found"});
	}

	if((user.Phone == phone) && (await bcrypt.compare(password,user.Password))){

		token = await jwt.sign(user, process.env.KEY, {subject: "login-token"});
		res.json({Message: "Login successful"});
	}else{
		res.status(404).json({Error: "Password mismatch"});
	}

}catch(err){
	res.status(err.status || 404).json({Error: err.message});
}



});






//TOKEN MIDDLE

const verifyTokenAndRole = (role)=>{

	 return async (req,res,next)=>{
		try{
			const authHeaders = req.headers["authorization"];
			const token = authHeaders && authHeaders.split(" ")[1];
	
			if(!token){
				res.status(404).json({Error: "Token needed"});
			}
	
			await jwt.verify(token, process.env.KEY, (error, decoded)=>{

				if(error){
					res.status(error.status || 404).json({
						Error: error
					});
				}
	
				if(decoded){
					req.user = decoded;
					if(user.Role == role){
						next();
					}
					res.status(404).json({Error: "Role not supported"});

				}

			});
		}catch(err){
			res.status(err.status || 404).json({Error: err.message});
		}
	}
}











//ACC DETAILS FATCHING

app.get(`/acc/fatch/:accNo`, verifyTokenAndRole("user"), async (req,res)=>{

	try{
		const user = await User.findById(req.params.accNo);

		if(!user){
			res.status(404).json({Error: "User not found"});
		}

		res.json({Message: "User fatch successgul",
			User: user});

	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}

});



//ACCOUNT HISTORY

app.get(`/acc/history/:accNo`, verifyTokenAndRole("user"), async (req,res)=>{

	try{
		const history = await History.find({User: req.params.accNo});

		if(!history){
			res.status(404).json({Error: "History not fond for the acc no"});
		}

		res.json({Message: "History found" ,
			History: history
			});

	}catch(err){
		res.status(err.status || 403).json({Error: err.message});
	}

});






//AMOUNT CREDIT

app.patch(`/acc/crrdit/:accNo`, verifyTokenAndRole("user"), async (req,res)=>{

	try{
		const {credit} = req.body;
		const user = await User.findById(req.params.accNo);
		if(!user){
                        res.status(404).json({Error: "User not found"});
                }

		let currentBalance = user.Balance+credit;

		const updatedUser = await User.findOneAndUpdate(
			{_Id: req.params.accNo},
			{Balance: currentBalance},
			{new: true, runValidators: true}
		);

		if(!updatedUser){
			res.status(404).json({Error: "User not found"});
		}


		if(!mongoose.Types.ObjectId.isValid(req.params.accNo)){
			return res.status(404).json({Error: "Invalid acc no."});
		}

		const accno = mongoose.Types.ObjectId(req.params.accNo);

		const recept = await History.create({
			State: "Credit",
			Current: currentBalance,
			Credited: credit,
			User: accno
		});

		res.json({Message: `Your account credited with ${credit} rupes.`,
			Recept: recept
		});


	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}

});







//AMOUNT DEBIT
app.patch(`/acc/debit/:accNo`, verifyTokenAndRole("user"), async (req,res)=>{

        try{
                const {debit} = req.body;
                const user = await User.findById(req.params.accNo);
                if(!user){
                        res.status(404).json({Error: "User not found"});
                }

                let currentBalance = user.Balance-debit;

                const updatedUser = await User.findOneAndUpdate(
                        {_Id: req.params.accNo},
                        {Balance: currentBalance},
                        {new: true, runValidators: true}
                );

                if(!updatedUser){
                        res.status(404).json({Error: "User not found"});
                }


                if(!mongoose.Types.ObjectId.isValid(req.params.accNo)){
                        return res.status(404).json({Error: "Invalid acc no."});
                }

                const accno = mongoose.Types.ObjectId(req.params.accNo);

                const recept = await History.create({
                        State: "Debit",
                        Current: currentBalance,
                        Debited: debit,
                        User: accno
                });

                res.json({Message: `Your account credited with ${credit} rupes.`,
                        Recept: recept
                });


        }catch(err){
                res.status(err.status || 404).json({Error: err.message});
        }

});





//ACCOUNT INACTIVE

app.delete(`/acc/delete/:accNo`, verifyTokenAndRole("user"), async (req,res)=>{

	try{

		const deletedAcc = await User.findByIdAndDelete(req.params.accNo);

		if(!deletedAcc){
			res.status(404).json({Error: "Account not found"});
		}

		res.json({Messagr: "Account deleted successfully",
			DeletedAccount: deletedAcc
		});

	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}

});





app.listen(3000);


