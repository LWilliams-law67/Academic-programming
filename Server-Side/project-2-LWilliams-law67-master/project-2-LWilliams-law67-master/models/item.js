let mongoose = require("mongoose");

const itemSchema = mongoose.Schema ({
    id: String,
    category: String,
    title: String,
    description: String,
    cost: Number,
    commission: Number,
    image_url: String
});

mongoose.model('Item', itemSchema);