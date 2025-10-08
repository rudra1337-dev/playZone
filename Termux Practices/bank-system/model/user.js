const mongoose = require(`mongoose`);


const userSchema = new mongoose.Schema({
	Name:{
		type: String,
		required: true,
	},
	Phone:{
		type: Number,
		required: true,
		match: /^\d{10}$/
	},

	Email:{
		type: String,
		unque: true,
		match: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
		default: "Null"
	},

	Balance: {
		type: Number,
		min: 1000,
		required: true
	},

	Role: {
		type: String,
		enum: ["user","employ","owner"],
		default: "user"
	},

	Password: {
		type: String,
		required: true,
		minlength: 4
	}

});




module.export = mongoose.model("BankUser",userSchema);



