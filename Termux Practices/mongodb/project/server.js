const express = require(`express`);
const mongoose = require(`mongoose`);
const MongoDB = require(`./db.js`);
const User = require(`./model/user.js`);
const Post = require(`./model/post.js`);

const app = express();


MongoDB();
app.use(express.json());


app.use((req,res,next)=>{
	console.log(`Entered in Middleware`);
	next();
});

app.post(`/user/create`, async (req,res)=>{
	try{
		const {newName , newEmail} = req.body;
		const newUser = await User.create({name: newName, email: newEmail});
		if(!newUser){
			res.statue(404).json({Error: `Invalid user details`});
		}
		res.json({Message: "User created", User: newUser});

	}catch(err){
		res.status(err.status || 404).json({Error: err.mrssage});
	}
});

app.post(`/post/create`, async (req,res)=>{
	try{
		const {newTitle, newContent} = req.body;

		if(!mongoose.Types.ObjectId.isValid(req.body.userId)){
			res.status(404).json({Error: `Invalid userid`});
		}

		const newID = mongoose.Types.ObjectId(userId);

		const newPost = await Post.create({title: newTitle, content: newContent, user: newID});

		if(!newPost){
			res.status(404).json({Error: `Invalid details`});
		}

		res.json({Message: `Post creatrd`, Post: newPost});
	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}

});




app.get(`/user/getAll`, async (req,res)=>{
	try{
		const allUsers = await User.find();
		if(!allUsers){
			res.status(404).json({Error: "User not found"});
		}
		res.json({Message: "User found", Users: allUsers});
	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}
});


app.get(`/post/getAll`, async (req,res)=>{
	try{
		const allPosts = await Post.find();
		if(!allPosts){
			res.status(404).json({Error: "Post not found"});
		}
		res.json({Message: "Post found", Posts: allPosts});
	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}
});




app.delete(`/post/deleteById:id`, async (req,res)=>{                                                                                     
	 try{
		 if(!req.params.id){
                        res.status(404).json({Error: "Undefined ID"});
                }

                const deletedPost = await findByIdAndDelete(req.params.id);
                if(!deletedPost){
                        res.status(404).json({Error: "Post not found"});
                }
                res.json({Message: "Post deleted", Post: deletedPost});
        }catch(err){
                res.status(err.status || 404).json({Error: err.message});
        }
});





app.get(`/post/getbyId/:id`, async (req,res)=>{
	try{
		if(!req.params.id){
			res.status(404).json({Error: "Undefined ID"});
		}

		const user = await Post.findById(req.params.id).populate("user");
		if(!user){
			res.status(404).json({Error: "User not found"});
		}
		res.json({Message: "User found", User: user});
	}catch(err){
		res.status(err.status || 404).json({Error: err.message});
	}
});





app.listen(3000);
