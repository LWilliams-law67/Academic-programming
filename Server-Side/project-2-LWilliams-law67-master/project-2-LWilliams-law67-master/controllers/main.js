let itemService = require("../lib/itemService");

/** Displays the home page to the user */
exports.home = function(req, res) {
	res.render('home');
};

/** Displays a category page to the user */
exports.category = async function(req, res) {
	let category = req.params.category;

	// Get the items
	let items =  await itemService.getItemsByCategory(category)

	// Render the template with the items we've found
	.then(
		render('category', {
		cart: [],	// TODO: The contents of the shopping cart need to be passed in there
		items: items,
		category: itemService.titleCaseCategory(category)
		})
	);
};

/** Displays the admin interface to the user */
exports.admin = function(req, res) {
	res.render('admin');
};

/** Processes an admin form submission */
exports.process = async function(req, res){
	// Create a new inventory item based on the values submitted
	await itemService.createItem(
		req.body.id,
		req.body.category,
		req.body.title,
		req.body.description,
		req.body.cost,
		req.body.image_url,
		req.body.commission	// If this is undefined we'll handle it elsewhere
	)

	// Redirect the user to the correct category page
	.then( 
		redirect(303,'/category/' + req.body.category)
	);
};
