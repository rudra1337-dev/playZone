const mongoose = require(`mongoose`);


const historySchema = new mongoose.Schema({

	State: {
		type: String,
		required: true,
		enum: ["Debit","Credit"],
	},

	Current: {
		type: Number,
                min: 1000,
                required: true
	},

	Credited: {
                type: Number,
		required: true
	},

	Debited: {
                type: Number,
		required: true
	},

	User: {
		type: mongoose.Schema.Types.ObjectId,
		ref: "BankUser",
		equired: true
	}

});



module.export = mongoose.model("BankHistory", historySchema);
