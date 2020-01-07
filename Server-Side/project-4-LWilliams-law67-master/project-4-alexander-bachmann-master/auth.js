// This is the authentication function, should be moved to a module
function auth (key, callback) {

    // If the API key matches 'test'
    if ('test' === key)
      // Return a user object
      callback(null, { id: '1', name: 'Test Person'}); // Fake user object for this key
    else
      // Otherwise return null as second param (first param is reserved for an error)
      callback(null, null)
  }

  module.exports = auth;