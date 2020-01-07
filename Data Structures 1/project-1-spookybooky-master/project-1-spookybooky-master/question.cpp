#include "question.hpp"

using std::size_t;

Question::Question(){}
Question::Question(string question, string answer){
	text = question;
	this->answer = answer;
}

string Question::GetText(){
	return text;
}

bool Question::AnswerContainsDigit(char digit) {
	bool isDigitInAns = false;	//	'isDigitInAns' is a variable to hold a true or false value for
								//	if player's guess is in the answer
	size_t found = answer.find(digit);

	if (found != std::string::npos)
		isDigitInAns = true;

	return isDigitInAns;
}

string Question::GetAnswerWithPlaceholders(const vector<char> &guesses) {
	string placeholder = answer;	//	a string to assign with correct guesses and '_' placeholders
									//	to be returned from function with initial value equal to answer
	for (unsigned a = 0; a < placeholder.length(); a++)
		placeholder[a] = '_';	//	replaces each digit with '_' character

	for (unsigned a = 0; a < answer.length(); a++)	//	loop to cycle through answer
		for(unsigned b = 0; b < guesses.size(); b++)	//	loop to cycle through player guesses
			if (answer[a] == guesses.at(b))	//	if a player guess matches answer digit
				placeholder[a] = answer[a];	//	then placeholder becomes answer digit

	return placeholder;
}

bool Question::AllDigitsGuessed(string correctGuess) {
	bool completeAnswer = true;	//	bool variable to be returned from function

	for (unsigned i = 0; i < answer.size(); i++) {	//	loop cycles through string to find '_' character
		if (correctGuess.at(i) == '_') {	//	if '_' character is found in 'correectGuess'
			completeAnswer = false;			//	then 'completeAnswer' is assigned with false
			break;							//	and loop ends
		}
	}

	return completeAnswer;
}