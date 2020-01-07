const express = require('express');
const router = express.Router();
const Post = require('../models/post');

router.get('/getPosts', (req, res, next) => {
    Post.find()
        .exec()
        .then(doc => {
            console.log(doc);
            res.status(200).json(doc);
        })
        .catch(err => {
            console.log(err);
            res.status(500).json({
                error: err
            });
        });
});

router.post('/create', (req, res, next) => {
    const post = new Post ({
        username: req.body.username,
        message: req.body.message,
        postDate: req.body.postDate
    });
    post.save()
        .then( result => {
            console.log(result);
            res.status(201).json({
                message: "You created a new post.",
                createdPost: post,
                id: post._id
            })
        })
        .catch (err => console.log(err));
});

router.patch('/update/:id', (req, res, next) => {
    let updateOptions = {};
    for (const options of req.body) {
        updateOptions[options.propName] = options.value;
    }
    Post.update({_id: req.params.id}, {$set: updateOptions})
        .exec()
        .then(result => {
            console.log(result);
            res.status(200).json(result);
        })
        .catch(err => {
            console.log(err);
            res.status(500).json({
                error: err
            });
        });
    
});

router.delete('/delete/:id', (req, res, next) => {
    Post.remove({_id: req.params.id})
        .exec()
        .then(result => {
            res.status(200).json(result);
        })
        .catch(err => {
            console.log(err);
            res.status(500).json({
                error: err
            });
        });
});

module.exports = router;