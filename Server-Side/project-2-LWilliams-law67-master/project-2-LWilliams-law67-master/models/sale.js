let mongoose = require("mongoose");

const saleSchema = mongoose.Schema ({
    email: String,
    name: String,
    dateSold: { type: Date, default: Date.now },
    itemsSold: []
});

mongoose.model('Sale', saleSchema);