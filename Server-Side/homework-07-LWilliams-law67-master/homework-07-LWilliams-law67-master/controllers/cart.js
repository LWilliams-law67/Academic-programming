let donations = []; // Will hold donations after processed from the cart

/** Adds the donation to the cart for a user, then returns them home */
const addDonation = function (req, res) {

  // If the user has specified a donation amount
  if (req.query.amount) {

    // Put the donation in the cart
    req.session.cart.push({
      amount: parseFloat(req.query.amount),
      message: req.query.message || "no message"
    });
  }

  // Otherwise tell them that they didn't specify an amount
  else {
    req.session.flash = {
      message: "You didn't specify an amount."
    };
  }

  // Transfer the user home
  res.redirect('/');
};

/** Processes the checkout action, clearing the cart and returning the user home */
const processDonations = function (req, res) {

  // If the user has a cart with donations.
  if(req.session.cart && req.session.cart.length) {

    // Thank the user for their gift
    req.session.flash = {
      message: "Thank you for your donation."
    };

    // Transfer the donations to the local array
    donations = donations.concat(req.session.cart);

    // Erase the shopping cart
    delete req.session.cart;
    
  }
  else {
    // Tell them the cart is empty.
    req.session.flash = {
      message: "Your cart is empty"
    };
  }

  // Transfer the user home
  res.redirect('/');
};

/** Lets an admin view all donations made on the platform */
const viewDonations = function (req, res ) {
  res.render('donations', {
    donations: donations
  });

};

module.exports = {
  addDonation,
  processDonations,
  viewDonations
};
