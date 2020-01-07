const Soda = require('../entities/soda');

// We start with pre-set inventory in the machine 
// (in later examples this will come from the database)
let inventory = [
  new Soda(1, 'Coke', 12, 1.50, true),
  new Soda(2, 'Dr. Pepper', 12, 1.50, true),
  new Soda(3, 'Sprite', 12, 1.50, false),
  new Soda(4, 'Iced Tea', 12, 2.00, true)
];

/**
 * Renders a page displaying the current sodas in the machine
 * @param {*} req 
 * @param {*} res 
 */
const sodaList = function (req, res) {
  res.render('soda-list', {
    title: 'Coke Machine',
    pageHeader: {
      title: 'Coke Machine Menu',
      strapline: 'Enjoy!'
    },
    sidebar: "Try a nice, refreshing coke!",
    
    // Inventory can change with each page load so it's not hard-coded
    inventory: inventory
  });
};

// TODO: implement this route, commented out so app will run
/** Vends a soda and displays a receipt to the user */
const vendSoda = function (req, res) {
  console.log( req.params.id );
  if ( req.params.id >= 1 && req.params.id <= inventory.length)
    if (inventory[ req.params.id - 1 ].vend() ) {
      res.render('receipt', {
        title: 'Coke Machine',
        pageHeader: {
          title: 'Receipt',
          strapline: 'Enjoy!'
        },
        sidebar: "Thankyou for purchasing a " + inventory[req.params.id - 1].name + "!",
        
        soda: inventory[req.params.id - 1]
      });
    }
    else {
      console.log( "Sold Out. Please try another option.");
    }
  else {
    console.log( "Invalid entry." );
  }

  // Renders home page if vending fails.
  res.render('soda-list', {
    title: 'Coke Machine',
    pageHeader: {
      title: 'Coke Machine Menu',
      strapline: 'Enjoy!'
    },
    sidebar: "Try a nice, refreshing coke!",
    
    // Inventory can change with each page load so it's not hard-coded
    inventory: inventory
  });

};

// TODO: implement this route, commented out so app will run
/** Stocks a soda by adding it to the inventory, then redirects home */
const stockSoda = function (req, res) {
  console.log( req.params.id );
  if ( req.params.id >= 1 && req.params.id <= inventory.length) {
    inventory[ req.params.id - 1 ].quantity += parseInt(req.params.amount);
    res.status(302).render('soda-list', {
      title: 'Coke Machine',
      pageHeader: {
         title: 'Coke Machine Menu',
         strapline: 'Inventory stocked.'
       },
       sidebar: "Try a nice, refreshing coke!",
       
      // Inventory can change with each page load so it's not hard-coded
      inventory: inventory
    });
  }
  else if ( req.params.amount === undefined ) {
    console.log( "Amount is not defined." );
    res.redirect('/');
  }
  else {
    console.log( "Invalid entry." );
    res.redirect('/');
  }

};

/** Returns the inventory to the user as json */
const report = function (req, res) {
  res.json(inventory);
};

// Remember to uncomment these as well to make available to the app
module.exports = {
  sodaList: sodaList,
  vendSoda: vendSoda,
  stockSoda: stockSoda,
  report: report
};