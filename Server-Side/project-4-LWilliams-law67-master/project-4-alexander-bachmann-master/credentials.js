 
module.exports = {
    mongo: {
        development: {
            connectionString: 'mongodb+srv://abachmann:mongodb@cluster0-zozah.mongodb.net/test?retryWrites=true&w=majority'
        },
        production: {
            connectionString: 'mongodb+srv://abachmann:mongodb@cluster0-zozah.mongodb.net/test?retryWrites=true&w=majority'
        }
    },
    session: {
        secret: 'some kind of secret',
        resave: false,
        saveUninitialized: true,
        cookie: { secure: false } // This needs to be true if in prod under https
    }
};