const mongoose = require(`mongoose`);


const userSchema = new mongoose.Schema({
	name: {
		type: String,
		maxlength: 30,
		minlength: 3,
		required: true
	},

	email: {
		type: String,
		maxlength: 30,
                minlength: 3,
                required: true
	},

	password: {
		type: String,
                minlength: 3,
                required: true
	},

	role: {
		type: String,
		enum:{
			values:["admin","user"],
			message: "Role is not matching"
		},
		default: "user"
	}
});
module.exports = mongoose.model(`User1`, userSchema);

