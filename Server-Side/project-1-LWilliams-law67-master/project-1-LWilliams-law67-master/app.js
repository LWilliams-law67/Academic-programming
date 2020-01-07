const express = require('express');
const path = require('path');
const tvService = require('./tvService.js');

var app = express();

// view engine setup
app.engine('pug', require('pug').__express);
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

// Set port app will run on
app.set('port', process.env.PORT || 3000);

app.use(express.static(path.join(__dirname, 'public')));

app.get('/', function(req, res) {
	res.render('home');

});

app.get('/results', async function(req, res) {
	if( req.query.input ) {
		let shows = await tvService.getShows( req.query.input );

		res.render('results', {
			title: "Shows for " + req.query.input,
			shows: shows
		});
	} else {
		res.render('home', {
			title: "Error: no results found for " + req.query.input,
			shows: []
		});
	}
});

app.get('/details', async function(req, res) {
	if( req.query.id ) {
		let show = await tvService.getShow( req.query.id );

		res.render('details', {
			title: "Details: ",
			show: show
		});
	} else {
		res.render('home', {
			title: "Error: no details found for " + req.query.id,
			show: {}
		});
	}
});

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
