let mongoose = require("mongoose");

let orderSchema = mongoose.Schema({
    name: String,
    address:String,
    cardNumber: String,
    total: Number,
    cart: [],
    orderDate: { type : Date, default: Date.now }
   
});

module.exports = mongoose.model('Order', orderSchema);