const postService = require('../services/postService');

let posts = [];

const home = async function (req, res) {
  res.render('home',  {
    posts: posts
  });

}

const load = async function (req, res) {
  let loadResult = await postService.loadPosts();
  res.send(loadResult);
};

module.exports = {
  home,
  load
};