const mongoose = require("mongoose");
const Item = mongoose.model("Item");

// Contains all inventory items.
// This variable is not exported, so it cannot be accessed from the outside.
// let inventory = [
//   {
//     id: "101",
//     category: "clothing",
//     title: "Baby Outfit",
//     description: "Baby outfit along with a little bow tie.",
//     cost: 29.99,
//     commission: .50,
//     image_url: "https://www.dhresource.com/0x0s/f2-albu-g9-M00-25-94-rBVaWFwhovGAeqmPAAL-d1zrT28245.jpg/newborn-baby-boys-suits-formal-outfits-clothing.jpg",
//   }
// ];

module.exports = {

  // Returns the inventory items that are of the desired type
  getItemByCategory: function(category) {
    
    return Item.find( {category: category} ).exec()
			.catch(err => {
        console.error(err);
        return [];
      });
  },

  // Returns the inventory item with the matching ID
  getItemById: function(id) {

    return Item.findOne( {id: id} )
    .catch(err => {
      console.error(err);
      return [];
    });
  },

  // Adds a new item to the shopping cart
  addItemToCart: function(id) {
      return Item.findOne({id:id})
      .catch(err => {
				console.error(err);
				return [];
			});
  },

  // Creates a new inventory item based on the values provided.
  // If no commission is specified, a value of .50 is set.
  createItem: function(id, category, title, description, cost, image_url, commission) {
      // Build a new inventory item from the values provided
      return Item.create({
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

  // Returns the appropriate title cased category
  titleCaseCategory: function(category) {

    // Kind of a hack to get baby gear to work right
    if(category === "babygear"){
      return "Baby Gear";
    } else {
      // Uppercases the first letter of the string
      return category.charAt(0).toUpperCase() + category.slice(1);
    }
  }


};
