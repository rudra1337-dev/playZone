const mongoose = require(`mongoose`);

const postSchema = new mongoose.Schema({
	title:{
		type: String,
		minlength: 2,
		maxlength: 10,
		required: true
	},
	content:{
		type: String,
		minlength: 2,
		maxlength: 100,
		required: true
	},
	user:{
		type: mongoose.Schema.Types.ObjectId,
		ref: "User"
	}
});


module.exports = mongoose.model("Post",postSchema);

