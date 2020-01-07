// This is your first express server! You will be creating the server
// and setting up routes for it in this homework.


// Require the express framework
const express = require('express');

// Create an instance of express in a variable called "app"
const app = express();

// Create a route for the home page "/" that returns text "Welcome Home!"
app.get('/', function(req, res) {
    res.send('Welcome Home');
});

// Create a route that accepts parameters in the URL path. The URL will be
// "area/:length/:width" and will return a text page that contains the area
// computed with the two numbers. For example, if you call the url "area/10/5"
// a page with "50 sq. ft." will be displayed.
// Note: bogus data can/should cause "NaN sq. ft." to render, but it shouldn't crash
app.get('/area/:length/:width', (req,res) => res.send(req.params.length * req.params.width + ' sq. ft.'));

// Create a route at "/fancypage" that will return this HTML content:
//
// <h1>Welcome to the fancy page!</h1>
// <p>It's ironic because it's not really 
//    <a href="https://www.merriam-webster.com/dictionary/fancy">fancy</a>
// </p>
app.get('/fancypage', function(req,res) {
    res.send(   `<h1>Welcome to the fancy page!</h1>
        <p>It's ironic because it's not really 
        <a href="https://www.merriam-webster.com/dictionary/fancy">fancy</a>
        </p>`   );
});


// Add a 404 middleware that will render this HTML: <h1>"Page not found"</h1> if we call a non-existing page
app.use('*', (req,res) => {
    res.status(404);
    res.send(`<h1>Page not found</h1>`);
})


// Export the app object using the module.exports variable
module.exports = app;