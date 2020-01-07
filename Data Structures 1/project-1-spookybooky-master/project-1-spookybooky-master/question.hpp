#include <iostream>
#include <string>
#include <vector>

using std::string;
using std::vector;

#ifndef _QUESTION_H
#define _QUESTION_H

class Question {
		string text;	//	std::string variable for containing the question
		string answer;	//	std::string variable for containing the answer
	public:
		Question();
		Question(string question, string answer);	//	parameterized constructor to take in a std::string answer and a std::string question
													//	available for the 'LoadQuestions' function of the QuestionBank class
		string GetText();	//	Returns a std::string that is the question body
		
		bool AnswerContainsDigit(char digit);	//	Returns a boolean (true or false) if the answer contains the character passed in
												//	useful for knowing when to increment the number of incorrect guesses
		string GetAnswerWithPlaceholders(const vector<char> &playerGuesses);	//	Returns an std::string of the answer but digits that 
																		//	have not been guessed by the user should show an underscore
		bool AllDigitsGuessed(string correctGuess);	//	Returns true if no underscore is present in the input string, false otherwise
													//	A simple check to search an input string for the underscore character
};

#endif