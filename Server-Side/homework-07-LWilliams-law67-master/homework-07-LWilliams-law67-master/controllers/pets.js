let votes = {
  toby: [],
  scout: []
};

const showPets = function (req, res) {
  res.render('home', {
    votes: votes
  });
};


const petVote = function (req, res) {
  const thisUser = req.cookies["connect.sid"];
  // Has this person already voted?
  if ( votes.toby.includes(thisUser) || votes.scout.includes(thisUser) ) {
    // If so, tell them so in a flash message
    req.session.flash = {
      message: "Sorry, you've already voted!"
    };
  }
  else {
    // If not, count their vote
    votes[req.params.pet].push(thisUser);

    // Then give them a flash message thanking them
    req.session.flash = {
      message: "Thanks for you vote!"
    };
  }
  // Transfer the user home either way
  res.redirect('/');
};

module.exports = {
  showPets,
  petVote
};
