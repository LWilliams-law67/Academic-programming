let mongoose = require("mongoose");

let userSchema = mongoose.Schema({
    name: String,
    password: String,
    loginDate: {type : Date, default: Date.now}
});

module.exports = mongoose.model('User', userSchema);