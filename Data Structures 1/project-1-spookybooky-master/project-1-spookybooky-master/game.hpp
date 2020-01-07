#include "question_bank.hpp"

#ifndef _GAME_H
#define _GAME_H

class Game {
		QuestionBank *questions;	//	A pointer to a 'QuestionBank' class object
		int amountWagered;	//	An integer to store the player's wager
		int currentScore;	//	An integer to store the player's point total

	public:
		Game();
		Game(QuestionBank *qs);	//	parameterized constructor that takes in a 'QuestionBank' pointer
								//	to create a 'Game' class object
		int AskQuestion();	//	should be implemented as a void function to implement gameplay to player

		void AdjustPoints(bool increasePoints);	//	A function to increase points if 'increasePoints' is true
												//	or decrease points if false
		void SetWager(int wager);	//	sets wager from player input

		int GetWager();	//	returns player's current wager

		int GetCurrentScore();	//	returns player's current point total
};

#endif