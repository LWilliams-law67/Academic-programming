const mongoose = require("mongoose");

// Define the item schema
let itemSchema = mongoose.Schema({
    name: String,
    description: String,
    quantity: Number,
    reportDate: { type : Date, default: Date.now }
});

// Define the store schema
let storeSchema = mongoose.Schema({
    name: String,
    address: String,
    zipcode: Number,
    items: [itemSchema]
});

// Register each model with Mongoose.
// There's no need to export here because mongoose is a singleton
module.exports = mongoose.model('Store', storeSchema);