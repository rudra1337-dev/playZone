const mongoose = require(`mongoose`);
require(`dotenv`).config();



const mongodb = async ()=>{
	try{
		await mongoose.connect(process.env.MONGOURL);

	        console.log(`MongoDB Connected`);
	}catch(err){
		console.log(`MongoDB connection faild`);
		process.exit();
	}
}



module.exports = mongodb;
