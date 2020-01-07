const axios = require('axios');

let tvService = {};

tvService.getShows = (input) => {
    return axios.get(`http://api.tvmaze.com/search/shows?q=${input}`)
    .then( (searchResponse) => {
        console.log( searchResponse.data[0].show.name);
        return searchResponse.data;
    })
    .catch( (error) => {
        console.log(error);
        return [];
    });
};

tvService.getShow = (id) => {
    return axios.get(`http://api.tvmaze.com/shows/${id}`)
    .then( (searchResponse) => {
        console.log( searchResponse.data.name);
        return searchResponse.data;
    })
    .catch( (error) => {
        console.log(error);
        return {};
    });
};

module.exports = tvService;

