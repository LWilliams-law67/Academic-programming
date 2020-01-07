const express = require('express');
const zipcodes = require('zipcodes');
const router = express.Router();
const Store = require('../models/store');

router.get('/', function (req,res) {

    let userLocation = '32514';
    let storeLocation = '32301';
    let dist = zipcodes.distance(userLocation, storeLocation);
    let rad = zipcodes.radius(userLocation, dist);
  
    res.json({
           status : "success",
           data : {
             "distance" : dist,
             "rad": rad
           }
       })
  });

router.get('/stores', (req, res) => {
    Store.find()
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

router.post('/addStore', (req, res) => {
    const store = new Store ({
        name: req.body.name,
        address: req.body.address,
        zipcode: req.body.zipcode,
        items: req.body.items
    });
    store.save()
        .then( result => {
            console.log(result);
            res.status(201).json({
                message: "You added a new store.",
                // addedStore: store,
                id: store._id
            })
        })
        .catch (err => console.log(err));
 });

 router.put('/updateStore/:id', (req, res) => {
    let updatedStore = req.body;
    let id = req.params.id;
    Store.update({_id: id}, updatedStore)
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

 router.delete('/deleteStore/:id', (req, res) => {
    Store.remove({_id: req.params.id})
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

 router.get('/search/items', (req, res) => {
    // Ensures search term is present in request query
    if(!req.query.item) {
        res.status(400).json({
            "status": "error",
            "message": "No search term provided."
        });
    }

    let searchStores = []; // array of stores that contain searched item
    let radius = req.query.radius || 20; // set radius to query value or 20 by default

    if(!req.query.zipcode && !(req.query.city && req.query.state)) { // if no zip and no city, st then search global
        Store.find()
            .exec()
            .then(result => {
                for(let i = 0; i < result.length; i++) {                    // every store within zipcode
                    for(let j = 0; j < result[i].items.length; j++) {       // every item in each store
                        if(result[i].items[j].name == req.query.item) {     // if searched item is in the store
                            searchStores.push(result[i])                    // add store to list 
                        }
                    }
                }
                console.log(searchStores);
                res.status(200).json({
                    message: "stores containing " + req.query.item,
                    stores: searchStores
                });
            })
            .catch(err => {
                console.log(err);
                res.status(500).json({
                    error: err
                });
            });
    } else if (!req.query.zipcode) {
        let zipcodesForCityStateProvided = zipcodes.lookupByName(req.query.city, req.query.state);
        Store.find({zipcode: zipcodesForCityStateProvided[0].zipcode})
            .exec()
            .then(result => {
                for(let i = 0; i < result.length; i++) {                    // every store within zipcode
                    for(let j = 0; j < result[i].items.length; j++) {       // every item in each store
                        if(result[i].items[j].name == req.query.item) {     // if searched item is in the store
                            searchStores.push(result[i])                    // add store to list 
                        }
                    }
                }
                console.log(searchStores);
                res.status(200).json({
                    message: "stores containing " + req.query.item + " within " + req.query.city + ", " + req.query.state,
                    stores: searchStores
                });
            })
            .catch(err => {
                console.log(err);
                res.status(500).json({
                    error: err
                });
            });
    } else {
        Store.find({zipcode: req.query.zipcode})
            .exec()
            .then(result => {
                for(let i = 0; i < result.length; i++) {                    // every store within zipcode
                    for(let j = 0; j < result[i].items.length; j++) {       // every item in each store
                        if(result[i].items[j].name == req.query.item) {     // if searched item is in the store
                            searchStores.push(result[i])                    // add store to list 
                        }
                    }
                }
                console.log(searchStores);
                res.status(200).json({
                    message: "stores containing " + req.query.item + " within the zipcode " + req.query.zipcode,
                    stores: searchStores
                });
            })
            .catch(err => {
                console.log(err);
                res.status(500).json({
                    error: err
                });
            });
    }
});

module.exports = router;