const mongoose = require("mongoose");
const Sale = mongoose.model("Sale");

module.exports = {
    createSale: function(id, category, title, description, cost, image_url, commission) {
        // Build a new inventory item from the values provided
        return Sale.create({
          id: id,
          category: category,
          title: title,
          description: description,
          cost: cost,
          image_url: image_url,
          commission: commission
        })
        .catch(err => {
                  console.error(err);
                  return [];
              });
    },
}