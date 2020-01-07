const express = require('express');
const path = require('path');
const passport = require('passport');
const bodyParser = require('body-parser');
const morgan = require('morgan');

require('./models/db');
const mongoose = require('mongoose');
const User = mongoose.model('User');
const Order = mongoose.model('Order');

let containers = require('./containers');
var app = express();

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');
app.set('port', process.env.PORT || 3000);
app.use(express.static(path.join(__dirname, 'public')));


app.get('/', function(req, res) {
	res.render('login');
});

app.get('/user', function(req, res) {
	
	//adding user to database when they log into the site
	User.create({
		name: req.query.username,
    	password: req.query.password
	});
	
	if(req.query.username == 'admin')
	{
		res.redirect('/admin');
	}
	else
	{
		res.redirect('/store');
	}
});

app.get('/admin', async function(req, res){

	//finding all orders made through the website to calc total sales
	let orders = await Order.find().exec()
						.catch(err => {
							console.error(err);
							return [];
						});

	let totalSales = 0;
	for(let i = 0; i < orders.length; i++)
	{
		totalSales += orders[i].total;
	}

	//finding all visitors of the website 
	let users = await User.find().exec()
						.catch(err => {
							console.error(err);
							return [];
						});

	let usernames = [];
	for(let i = 0; i < users.length; i++)
	{
		usernames.push(users[i].name);
	}

	//console.log(containers.inventory);
	res.render('admin', {
		inventory: containers.inventory,
		total: totalSales,
		users: usernames
	});
});

app.get('/admin/add', function(req, res) {

	containers.inventory.push({name: req.query.itemName, price: req.query.price});
	res.redirect('/admin');
});

app.get('/admin/remove/:name/:price', function(req, res){
	let itemName = req.params.name;
	let itemPrice = req.params.price;

	let spliceIndex = containers.inventory.findIndex(function(obj){
		return obj.name == itemName;
	});

	containers.inventory.splice(spliceIndex, 1);

	res.redirect('/admin');
});



app.get('/store', function(req, res) {

	res.render('store', {
		inventory: containers.inventory,
		cart: containers.cart,
		total: containers.total
	});
});

app.get('/cart/add/:name/:price', function(req, res) {

	let itemName = req.params.name;
	let itemPrice = req.params.price;
	containers.cart.push({itemName, itemPrice});

	containers.total += Number(itemPrice);

	res.redirect('/store');
});

app.get('/cart/remove/:name/:price', function(req, res){

	let itemName = req.params.name;
	let itemPrice = req.params.price;
	containers.total -= Number(itemPrice);
	
	let spliceIndex = containers.cart.findIndex(function(obj){
		return obj.itemName == itemName;
	});

	containers.cart.splice(spliceIndex, 1);

	res.redirect('/store');
});

app.get('/checkout', function(req,res){

	//adding order to database
	Order.create({
		name: req.query.name,
		address: req.query.address,
		cardNumber: req.query.creditCardNumber,
		total: containers.total,
		cart: containers.cart
	});

	containers.cart = [];
	containers.total = 0;

	res.redirect('/'); //TODO: add a flash message 'order successfully placed'
});

app.use(function(req, res, next){
	res.status(404);
	res.render('404');
});

app.use(function(err, req, res, next){
	console.error(err.stack);
	res.status(500);
	res.render('500');
});

app.listen(app.get('port'), function(){
  console.log( 'Express started on http://localhost:' +
    app.get('port') + '; press Ctrl-C to terminate.' );
});
