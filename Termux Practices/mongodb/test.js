const express = require(`express`);
const mongoose = require(`mongoose`);
const connectDB = require(`./db`);
const User = require(`./model/user`);
const Post = require(`./model/post`);



const app = express();


app.use((req,res,next)=>{
	console.log(`Entered in middlewares`);
	next();
});

connectDB();
app.use(express.json());

app.get(`/mongo`,(req,res)=>{
	res.json({ mongoDB : "connected"});
});




//POST (CREATE NEW USER)

app.post(`/user/add`,async (req,res)=>{
	try{
		const {name,email} = req.body;
		const newUser = new User({name,email});
		const savedUser = await newUser.save();
		
		res.status(500).json({messge: "User saved",
				user: savedUser
					});
	}catch(err){
		res.status(err.status || 404).json({error: err.message});
	}
});





//GET (GET USER DATA FROM DB USING DIFRENT METHODS)


app.get(`/user/get`, async (req,res)=>{
	try{
		const user = await User.find();
		res.json(user);
	}catch(err){
		res.status(err.status || 404).json({error: err.message});

	}

});




app.get(`/user/get/search`, async (req,res)=>{
        try{

                const {name,email} = req.query;
                const filter = {};

                if(name){
                        filter.name = name;
                }

                if(email){
                        filter.email = email;
                }

                const user = await User.find(filter);
                res.json(user);                                           
	}catch(err){
                res.status(err.status || 404).json({ Error: err.message});

        }
});





app.get(`/user/get/:id`, async (req,res)=>{
	try{
		const userId = req.params.id;
		const user = await User.findById(userId);
		res.json({User : user});
	}catch(err){
		res.status(err.status || 404).json({Error : err.message});
	}
});









//PATCH (UPDATE USER INFO BY ID AND USER INFO)


app.patch(`/user/update/search`, async (req,res)=>{
	try{
		const updatedUser = await User.findOneAndUpdate(
			{email: req.query.email},
			req.body,
			{new : true}
		);

		if(!updatedUser){
			res.status(404).json({Error : "User not found"});
		}

		res.json({message : "User updatd successfully" , User: updatedUser});
	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}

});




app.patch(`/user/update/:id`, async (req,res)=>{
        try{
                const updatedUser = await User.findByIdAndUpdate(
                        req.params.id,
                        req.body,
                        {new: true, runValidators: true}
                );

                if(!updatedUser){
                         return res.status(404).json({Error: "user not found"});
                }

                res.json({message: "User updated", User: updatedUser});

        }catch(err){
                res.status(err.status || 404).json({Error: err.message});
        }

});




app.put(`/user/replace/search`, async (req,res)=>{
	try{
		const updatedUser = await User.findOneAndReplace(
			{email: req.query.email},
			req.body,
			{new : true}
		);

		if(!updatedUser){
			return res.status(404).json({Error: "User ot found"});
		}

		res.json({message: "Update Successfuly", User: updatedUser});

	}catch(err){
		res.status(err.status || 404).json({ Error: err.message});
	}

});



app.put(`/user/replace/:id`, async (req,res)=>{
	try{
		const updatedUser = await User.findOneAndReplace(
			{_id:req.params.id},
			req.body,
			{new: true, overwrite: true, runValidators: true}
		);

		if(!updatedUser){
			return res.status(404).json({Error: "User not found"});
		}

		res.json({Message: "Updated Successfully", User: updatedUser});

	}catch(err){
		res.status(err.status || 404).json({Error: err.messagr});
	}


});







//DELETE (DELETE USER OR USER DATA IN DATABASE)


app.delete(`/user/delete/search`, async (req,res)=>{
	try{
		const deletedUser = await User.findOneAndDelete({email: req.query.email});
		if(!deletedUser){
			 return res,status(404).json({Error: "Useer not found"});
		}
		res.json({Message : "User deleted", User: deletedUser});
	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}

});

app.delete(`/user/delete/:id`, async (req,res)=>{
	try{
		const deletedUser = await User.findByIdAndDelete(req.params.id);
		if(!deletedUser){
			return res.status(404).json({Error: "User not found"});
		}
		res.json({Message: "User deleted", User: deletedUser});
	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}
});


app.patch(`/user/delete/email/:email`, async (req,res)=>{
	try{
		const updatedUser = await User.findOneAndUpdate(
			{email: req.params.email},
			{$unset : {name: ""}},
			{new: true}
		);

		if(!updatedUser){
			return res.status(404).json({Error: err.message});
		}
		res.json({Message: "User updated", User: updatedUser});
 	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}
});







//POPULATE (RELATION BETWEEN DIFFRENT DOCUMET)

app.post(`/content/post`, async (req,res)=>{
	try{
		const {sTitle,sContent,id} = req.body;

	if(!mongoose.Types.ObjectId.isValid(id)){
		res.status(404).json({Error: "Invalid ID"});
	}


		const objId = new mongoose.Types.ObjectId(id);
		const newPost = await Post.create({title: sTitle, content: sContent,user: objId});

		res.json({Post: newPost});
	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}
});


app.get(`/content/get/:id`, async (req,res)=>{
	try{
	const userPost = await Post.findById(req.params.id).populate("user");
	if(!userPost){
		res.status(404).json({Error: "User not found"});
	}

	const post = await Post.find({_id: req.params.id});

		if(!post){
			res.status(404).json({Error: "Post not found"});
		}

		res.json({Post: post, user: userPost});
	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}
});









app.use((err,req,res,next)=>{
	res.ststus(err.status || 404).json({ error : err.message });
});

app.listen(3000);


