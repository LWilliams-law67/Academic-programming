const express = require('express');
const morgan = require('morgan');
const bodyParser = require('body-parser');
const auth = require('./auth');

let app = express();
let apiRoutes = require('./routes/apiRoutes');

// database setup
require("./models/db");

app.set('port', process.env.PORT || 3000);

// Need Auth here!
app.use(require('apikey')(auth));

// Using morgan to log stuff
app.use(morgan('dev'));

// Handle form submissions
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.use("/", apiRoutes);

// 404 catch-all handler (middleware)
app.use(function(req, res, next){
  res.status(404);
  res.json({
      "status" : "error",
      "message" : "This page can not be found."
  });
});

// 500 error handler (middleware)
app.use(function(error, req, res, next){
  console.error(error.stack);
  res.status(500);
  res.json({
      "status" : "error",
      "message" : "An internal error has occurred."
  });
});

app.listen(app.get('port'), function(){
  console.log( 'Express started on http://localhost:' +
    app.get('port') + '; press Ctrl-C to terminate.' );
});
