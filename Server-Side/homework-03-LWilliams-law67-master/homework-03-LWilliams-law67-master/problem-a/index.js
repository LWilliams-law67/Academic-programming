'use strict';

/* Define a function `addFour()` that takes a single argument 
   and returns a value 4 greater than the input.*/
function addFour(num) {
  return num+4;
}
   
/* Create and log a variable `twelve` that is the result of passing 8 to your
   addFour() function. */   
let twelve = addFour(8);
console.log(twelve);
   
/* Create and log a variable `twelveString` that is the result of passing "8" 
   (a string) to your addFour() function. Consider what this tells you about how
  the function should be explained (e.g., in a comment). */
let twelveString = addFour("8");
console.log(twelveString);
//javascript does not parse the integer value from the String.   

/* Define a function `compoundInterest()` that takes three parameters: 
     1. an initial bank balance (principle, in dollars)
     2. an annual interest rate (as a decimal, e.g., 0.01) 
     3. a number of years
   The function should calculate the continuous compound interest
     (https://en.wikipedia.org/wiki/Compound_interest#Continuous_compounding) 
   and *return* the resulting total balance after that many number of years

   You can call the method and log the result to check your work. Compare to
     http://www.mathwarehouse.com/calculators/continuous-compound-interest-calculator.php
*/
function compoundInterest(principle, annualRate, years) {
  return principle * Math.pow( Math.E, (annualRate * years) );
}
// let balance = compoundInterest(5000, 0.05, 2);
// console.log( balance.toFixed(2) );

/* Define a function `getLetterFrequencies()` that takes in a single string as 
   an argument. The function should *return* an Object whose keys are characters
   (letters) and whose values are the number of times that character appears in
   the argument. Your function should be case sensitive.
   _Hint:_ start with an empty Object, then loop through the letters one at a
   time (you can access them with bracket notation, like with an array). For 
   each letter, increase the value associated with that key by one. Watch out 
   for if the letter is not in the Object yet!
   You can test this method with a word like "Mississippi". */
function getLetterFrequencies(letters) {
  let letterFreq = new Object();
  let character = "";
  var i;
  for (i = 0; i < letters.length; i++) {
    character = letters.charAt(i);
    letterFreq[character] = null;
  }

  for (i = 0; i < letters.length; i++) {
    character = letters.charAt(i);
    if ( letterFreq[character] !== null)
      letterFreq[character] += 1;
    else
      letterFreq[character] = 1;
  }
  return letterFreq;
}
// console.log( getLetterFrequencies("Mississippi") );
   

/* Create a variable `deck` that represents a deck of modern playing cards
   (https://en.wikipedia.org/wiki/Playing_card). This variable should be an
   *array* of 52 elements, each of which is an Object with properties:
     - `suit`, with a string value that is either `"hearts"`, `"diamonds"`, 
       `"clubs"`, or `"spades"`
     - `rank`, with an integer value ranging from 2 to 14 inclusive (values 
        11-14 represent a Jack, Queen, King, or Ace respectively).
    Tip: use a pair of nested loops to add each combination of suit and rank to 
    the `deck` array! 
    
    You can log out the `deck` to check your work! */
let deck = new Array();
for(var row = 0; row < 4; row++) {
  for(var col = 0; col < 13; col++) {
      if (row === 0) {
          deck.push({suit : "hearts", rank : col + 2});
      } else if (row === 1) {
          deck.push({suit : "diamonds", rank : col + 2});
      } else if (row === 2) {
          deck.push({suit : "clubs", rank : col + 2});
      } else {
          deck.push({suit : "spades", rank : col + 2});
      }
    }
}
// console.log(deck);
    

//You can test the below functions by creating e.g., a `pokerHand` array that 
//contains five cards from the `deck`.

/* Define a function `containsQueenOfHearts()` that takes in an array of "card"
   objects (e.g., a Poker hand) and returns whether or not the Queen of Hearts
   is in that array.
   Hint: use a loop to check each card. */
function containsQueenOfHearts(hand) {
  let inHand = false;
  for (var i = 0; i < hand.length; i++) {
    if (hand[i].suit === "hearts" && hand[i].rank === 12) {
      inHand = true;
      break;
    }
  }
  return inHand;
}
   

/* Define a function `getHighCard()` that takes in an array of "card" objects
  and returns the card object with the highest value. The "high card" is the one
  with the highest rank. Cards of different suits but the same rank are 
  considered to have the same value, and either is a valid result */
function getHighCard(hand) {
  let highest = hand[0];
  for (var i  = 0; i < hand.length; i++) {
    if (hand[i].rank > highest.rank) {
      highest = hand[i];
    }
  }
  return highest;
}
  

/* Define a function `isFlush()` that takes in an array of "card" objects and
   returns whether or not the cards all have the same _suit_. */
function isFlush(hand) {
  let sameSuit = hand[0];
  for (var i = 0; i < hand.length; i++) {
    if (sameSuit.suit !== hand[i].suit)
      return false;
  }
  return true;
}
   

/* Extra challenge: define a function `hasPair()` that takes in an array of 
   "card" objects and returns whether or not there is at least one _pair_ (two 
   cards with the same _rank_) in the array.
   Double challenge: return the rank of the pair of cards with the highest rank 
   (e.g., if the hand contains more than one pair!) */



//Make functions and variables available to tester. DO NOT MODIFY THIS.
if(typeof module !== 'undefined' && module.exports){
  /* eslint-disable */
  if(typeof addFour !== 'undefined') 
    module.exports.addFour = addFour;
  if(typeof twelveString !== 'undefined') 
    module.exports.twelveString = twelveString;
  if(typeof compoundInterest !== 'undefined') 
    module.exports.compoundInterest = compoundInterest;
  if(typeof fizzBuzz !== 'undefined') 
    module.exports.fizzBuzz = fizzBuzz;
  if(typeof getLetterFrequencies !== 'undefined')
    module.exports.getLetterFrequencies = getLetterFrequencies;
  if(typeof deck !== 'undefined')
    module.exports.deck = deck;
  if(typeof containsQueenOfHearts !== 'undefined')
    module.exports.containsQueenOfHearts = containsQueenOfHearts;
  if(typeof getHighCard !== 'undefined')
    module.exports.getHighCard = getHighCard;
  if(typeof isFlush !== 'undefined')
    module.exports.isFlush = isFlush;
}