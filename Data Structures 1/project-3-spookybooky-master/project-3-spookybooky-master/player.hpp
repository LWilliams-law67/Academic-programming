#ifndef PLAYER_HPP
#define PLAYER_HPP

#include "hand.hpp"

class Player {
	string playerName;
	Hand hand;
	bool isComputer;

public:
	Player();
	Player(string name, Hand hand, bool isComputer = false);
	void SetName(string name);
	void SetHand(Hand hand);
	void SetIsComputer(bool isComputer);
	string TurnPrompt();
	string ShowHand();
	Card* SwapOutCard(Card* card, int position);
	bool HasRacko();
	string GetName();
	bool IsComputer();
	string MakeChoice(int discardOption);
	int ComputerChoosesSlot(int cardValue);
};

#endif