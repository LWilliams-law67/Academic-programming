'use strict';

//Create a variable `backpack` that is an Object with properties:
//  `color` "blue", `height` of 18, `width` of 12, `depth` of 6
//  It should also have a property called `contents` that is an array
//  of these strings: "map", "flashlight", "compass"
// Finally, log out the backpack object in JSON using the JSON.stringify() method
let backpack = {"color" : "blue", "height" : 18, "width" : 12, "depth" : 6, "contents" : ["map", "flashlight", "compass"] };
console.log( JSON.stringify(backpack) );

// Create a function called Backpack that we will call as a constructor using the "new" keyword.
// It should accept five arguments and return an instance of a backpack object matching the 
// backpack pattern described in the first question above. 
function Backpack (color = "gray", height = 18, width = 12, depth = 6, contents = []) {
  this.color = color;
  this.height = height;
  this.width = width;
  this.depth = depth;
  this.contents = contents;

  return this;
}

// Note: The backpack constructor should have default values for each parameter so all five values aren't necessary.
// Use the color and dimensions from the object above, and an empty array for contents.

// Create a method called packBuilder that will take in a "color" parameter and return a promise for a new backpack
// after a random delay between 100 - 1000 ms. You will want to use the setTimeout method to initiate this delay.
// Hint #1: Create a new promise to return. The first answer here could be helpful:
// https://stackoverflow.com/questions/24928846/get-return-value-from-settimeout
function packBuilder ( color = "red" ) {
  const promise = new Promise( function(resolve, reject) {
    setTimeout( function() {
      resolve( Backpack(color) );
    }, Math.random(100, 1000) );
  });

  return promise;
}
// Hint #2: use this algorithm for generating a random number in a range:
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/random#Getting_a_random_integer_between_two_values_inclusive

// Now use packBuilder to create an instance of the Backpack that is "pink". This function call returns
// a promise so you will use "then()" to do run more code after it finishes. Once it's done,
// log out the backpack that was created
let pack = new packBuilder("pink");
pack.then( console.log(pack) );
// Build an async function called scoutTroopPacks() that uses packBuilder() and returns an array of 
// four backpacks with these colors in order every time: red, blue, orange, purple (other values are defaults)
// Note: it is easiest to use async/await for this
async function scoutTroopPacks() {
  let backpacks = [4];
  backpacks[0] = await packBuilder("red");
  backpacks[1] = await packBuilder("blue");
  backpacks[2] = await packBuilder("orange");
  backpacks[3] = await packBuilder("purple");
}
// Call the scoutTroopPacks() function and "then" log out the result
console.log( scoutTroopPacks() );

//Make functions and variables available to tester. DO NOT MODIFY THIS.
if(typeof module !== 'undefined' && module.exports){
    /* eslint-disable */
    if(typeof Backpack !== 'undefined') 
      module.exports.Backpack = Backpack;
    if(typeof packBuilder !== 'undefined') 
      module.exports.packBuilder = packBuilder;
    if(typeof scoutTroopPacks !== 'undefined') 
      module.exports.scoutTroopPacks = scoutTroopPacks;
  }