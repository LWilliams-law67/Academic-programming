const mongoose = require('mongoose');
const Post = mongoose.model('Post');

module.exports = {

	// Returns all posts in the db
	getAllPosts: function () {
		return Post.find().exec()
			.catch(err => {
				console.error(err);
				return [];
			});
	},

	// Adds a post to the db
	addPost: function (username, message) {
		return Post.create({
			username: username,
			message: message
		})
			.catch(err => {
				console.error(err);
				return [];
			});
	}

};