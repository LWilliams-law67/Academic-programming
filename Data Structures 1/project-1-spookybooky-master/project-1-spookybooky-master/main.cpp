/*
**
**	Author: Luke Williams
**	Date: 30 Jan. 2019
**	Description: COP3530 Data Stuctures & Algorithms Programming Project 1
**			This program executes a game called 'Numerical Wagers'. The player is able to wager points
**			and answer questions from a specified file. The player will guess digits until the correct answer
**			is found, or until guessing is extinguished. Players get a maximum of 2 incorrect guesses per question;
**			as well as, 3 maximum rounds of questions. 
**
*/

#include <limits>
#include <cctype>
#include "game.hpp"

using std::cout;
using std::cin;
using std::string;
using std::endl;
using std::numeric_limits;
using std::streamsize;

int main(){

	char playAgain = 'y';	//	character variable to input Y or N for playing again
	do {
		int points = 200;
		int wager = 0;	//	integer to take in player's wager
		int round = 1;	//	integer to increment the number of rounds played
		string file;	//	a string to take in file name from user

		cout << "Welcome to NUMERICAL WAGERS!" << endl;
		cout << "Please input a file name that contains your questions: ";
		getline(cin, file);
		cout << '\n' << endl;
		QuestionBank *questions = new QuestionBank(file.c_str());
		Game game = Game(questions);

		do {

			cout << "Round " << round << endl;
			cout << "Next Question: " << questions->GetNextQuestion().GetText() << endl;
			cout << "Current Points: " << points << endl;
			cout << "Please make a wager: ";
			cin >> wager;
			cout << '\n' << endl;

			game.SetWager(wager);
			points = game.AskQuestion();

			if (points < 1) {	//	ensures player has points left to wager
				round = 4;		//	forces game out of loop
				cout << "You have nothing left to wager." << endl;
			}

			round++;

		}while (round < 4);

		cout << "Would you like to play again? ";
		cin >> playAgain;
		cin.ignore(256, '\n');	//	takes in first character of player's response
		

		delete questions;

	}while (toupper(playAgain) == 'Y');

	cout << "Exiting..." << endl;

	return 0;
}