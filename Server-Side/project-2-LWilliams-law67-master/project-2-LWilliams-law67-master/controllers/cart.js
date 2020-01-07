let itemService = require("../lib/itemService");

/** Displays the cart to the user */
exports.view = function(req, res){
  res.render('cart');
}

/** Processes an add to cart request and then sends the user back to the cart */
exports.add = async function(req, res){
  let item = await itemService.getItemById(req.body.id)
    .then(
      res.redirect('/cart')
    );
}

/** Processes a remove from cart request and then sends the user back to the cart */
exports.remove = function(req, res){
  // Loop through the cart and only keep items without that id
  array.forEach(element => {
    if(element.id === req.body.id) {
      let i = array.indexOf(element);
      array.splice(i,1);
    }
  });
  // Redirect user to the cart
  res.redirect('/cart');
};

/** Begins the checkout process, shows the checkout form */
exports.checkout = function(req, res){
  res.render('checkout');
};

/** Processes a user's checkout request */
exports.process = function(req, res){
  // Check for a valid email and name first
  if(req.body.email && req.body.name) {
    //do checkout things whatever that is?
  }
  // If invalid data was entered, redirect user and don't continue
  else {
    res.redirect('/cart');
  }
  // Clear out the contents of the cart
  sessionStorage.clear();
  // Add a flash message

  // Redirect the user to the correct category page
  res.redirect('/category/' + req.body.category);
};
