const mongoose = require(`mongoose`);

const userSchema = new mongoose.Schema({
	name:{
		type: String,
		required: true,
		minlength: 3
	},

	email:{
		type: String,
		required: true,
		uniqur: true
	},

	createdAt:{
		type: Date,
		default: Date.now
	}
});


const User = mongoose.model(`User`,userSchema);

module.exports = User;
