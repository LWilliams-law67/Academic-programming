let mongoose = require("mongoose");

// Define the message schema
let postSchema = mongoose.Schema({
    name: String,
    date: {type: Date, default: Date.now},
    message: String
});

// Register each model with Mongoose.
// There's no need to export here because mongoose is a singleton
mongoose.model('Post', postSchema);