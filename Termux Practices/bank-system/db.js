const mongoose = require(`mongoose`);
//require(`dotenv`).config();



const MongoDB = async ()=>{

	try{
		//await mongoose.connect(process.env.MONGODB_URL);
		await mongoose.connect(`mongodb://Rudra:9937@ac-apuyeeg-shard-00-00.qyr9xbv.mongodb.net:27017,ac-apuyeeg-shard-00-01.qyr9xbv.mongodb.net:27017,ac-apuyeeg-shard-00-02.qyr9xbv.mongodb.net:27017/?replicaSet=atlas-9d0e4p-shard-0&ssl=true&authSource=admin&retryWrites=true&w=majority&appName=learning`);
console.log("MongoDB connected");

	}catch(err){
		console.log("MongooDB connection faild");
		process.exit(1);
	}

}

MongoDB();

module.export = MongoDB;
