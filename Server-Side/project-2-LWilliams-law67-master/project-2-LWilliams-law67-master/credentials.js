module.exports = {
    mongo: {
        development: {
            connectionString: 'mongodb+srv://rando:co8UgsoFdgfTMqdw@cluster0-53bvm.mongodb.net/test?retryWrites=true&w=majority'
        },
        production: {
            connectionString: 'mongodb+srv://rando:co8UgsoFdgfTMqdw@cluster0-53bvm.mongodb.net/test?retryWrites=true&w=majority'
        }
    },
    session: {
        secret: 'some kind of secret',
        resave: false,
        saveUninitialized: true,
        cookie: { secure: false } // This needs to be true if in prod under https
    }
};