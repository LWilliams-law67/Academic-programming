const express = require('express');
const path = require('path');
const creds = require('./credentials');

let app = express();

// Set up sessions
const session = require('express-session');

// Import our modules
const main = require('./controllers/main.js');
const cart = require('./controllers/cart.js');

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

app.set('port', process.env.PORT || 3000);

app.use(express.static(__dirname + '/public'));

// Handle form submissions
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));

/*************** Middleware *******************/

app.use(session({
    store: sessionStore,
    saveUninitialized: true,
    resave: 'true',
    secret: 'secret'
}));

app.use( flash() );
// Route that creates a flash message using custom middleware
app.all('/session-flash', function( req, res ) {
    req.session.sessionFlash = {
        type: 'success',
        message: 'This is a flash message using custom middleware and express-session.'
    }
    res.redirect(301, '/');
});

/*************** Routes *******************/
// Note: the route handlers have been separated into their own files
// (See the handlers directory)
app.get('/', main.home);

// Displays the desired category to the user
app.get('/category/:category', main.category);

// admin form to add items to the database/list
app.get('/admin', main.admin);

//route for POST to handle admin form submission
app.post('/admin/process', main.process);

// Shopping cart routes
app.get('/cart/view', cart.view);
app.get('/cart/add/:id', cart.add);
app.get('/cart/remove/:id', cart.remove);
app.get('/cart/checkout', cart.checkout);

//route for POST to handle CART CHECKOUT ACTIONS
app.post('/cart/process', cart.process);

/*************** Error Handlers *******************/

// 404 catch-all handler (middleware)
app.use(function(req, res, next){
	res.status(404);
	res.render('404');
});

// 500 error handler (middleware)
app.use(function(err, req, res, next){
	console.error(err.stack);
	res.status(500);
	res.render('500');
});

app.listen(app.get('port'), function(){
  console.log( 'Express started on http://localhost:' +
    app.get('port') + '; press Ctrl-C to terminate.' );
});
