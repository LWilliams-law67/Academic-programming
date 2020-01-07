const express = require('express');
const path = require('path');;
const morgan = require('morgan');
const postsRoutes = require('./api/routes');

var app = express();


// database setup
require("./models/db");

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

// Set port app will run on
app.set('port', process.env.PORT || 3000);

app.use(express.static(path.join(__dirname, 'public')));

// Using morgan to log stuff
app.use(morgan('dev'));

// Handle form submissions
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// Allow access from other clients for the api
app.use((req, res, next) => {
	res.header('Access-Control-Allow-Origin', '*');
	res.header('Access-Control-Allow-Headers', '*');
	if (req.method === 'OPTIONS') {
		res.header('Access-Control-Allow-Methods', 'PUT, POST, PATCH, DELETE, GET');
		return res.status(200).json({});
	}
	next();
});

// Import the controller
let main = require('./controllers/main');

// API routes
app.use("/api", postsRoutes);

// Routes
// app.get('/', main.home);
// app.post('/', main.process);

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
