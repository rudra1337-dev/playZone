const mongoose = require(`mongoose`);

const userSchema = new mongoose.Schema({
	name:{
		type: String,
		minlength: 2,
		maxlength: 10,
		required: true
	},
	email:{
		type: String,
		minlength: 12,
		maxlength: 25,
		required: true,
		unique: true,
		match: /@.+/
	}
});


module.exports = mongoose.model(`User`, userSchema);
