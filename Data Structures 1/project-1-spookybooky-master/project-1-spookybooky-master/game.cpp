#include "game.hpp"

using std::cout;
using std::cin;
using std::endl;

Game::Game(){}
Game::Game(QuestionBank *qs) {
	questions = qs;
	amountWagered = 0;
	currentScore = 200;
}

int Game::AskQuestion() {

	int missedGuesses = 0;	//	an integer to increment the number of times the player guesses incorrectly
	vector<char> guesses;	//	a vector to store the players sequence of guesses
	char digit;		//	a character variable for player to inupt a guess

	do {

		cout << "Current Question: " << questions->GetNextQuestion().GetText() << endl;
		cout << "Current Answer: " << questions->GetNextQuestion().GetAnswerWithPlaceholders(guesses) << endl;
		cout << "Missed Guesses: " << missedGuesses << endl;
		cout << "Please guess a digit: ";
		cin >> digit;
		cout << '\n' << endl;

		guesses.push_back(digit);	//	puts player's guess into vector

		if (questions->GetNextQuestion().AnswerContainsDigit(digit) == false){		//	forces loop into next iteration if player's guess is not in answer
			missedGuesses += 1;
			continue;
		}
		if (questions->GetNextQuestion().AllDigitsGuessed(questions->GetNextQuestion().GetAnswerWithPlaceholders(guesses)) == true)
			break;	//	breaks out of loop if answer is correctly guessed

	}while (missedGuesses < 3);	//	ensures the player has a maximum of two incorrect guesses

	//	adjusts player points based whether complete answer is guessed
	AdjustPoints(questions->GetNextQuestion().AllDigitsGuessed(questions->GetNextQuestion().GetAnswerWithPlaceholders(guesses)));

	questions->iterator++;

	return currentScore;

}

void Game::AdjustPoints(bool increasePoints) {
	if (increasePoints == true)
		currentScore += amountWagered;	//	adds wager to current point total
	else
		currentScore -= amountWagered;	//	subtracts wager from point total
}

void Game::SetWager(int wager) {
	if (wager < 1)	//	checks if player's wager is lower than the minimum amount
		amountWagered = 1;
	else if (wager > currentScore)	//	checks if player's wager is greater than their point total
		amountWagered = currentScore;
	else
		amountWagered = wager;	//	sets 'amountWagered' to player's input for wager
}


int Game::GetWager() {
	return amountWagered;	//	returns current wager
}

int Game::GetCurrentScore() {
	return currentScore;	//	returns current player point total
}