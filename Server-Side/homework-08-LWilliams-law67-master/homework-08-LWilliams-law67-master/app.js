const express = require('express');
const path = require('path');

var app = express();

// database setup
require("./models/database");

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

// Set port app will run on
app.set('port', process.env.PORT || 3000);

// Require the controllers
const postController = require('./controllers/postController');

var bodyParser = require('body-parser');
app.use(express.json());       // to support JSON-encoded bodies
app.use(express.urlencoded({ extended: true })); // to support URL-encoded bodies

app.use(express.static(path.join(__dirname, 'public')));

/* App pages */
app.get('/', postController.home);

// Used for loading data into our database
app.get('/load', postController.load);

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
