#ifndef HAND_HPP
#define HAND_HPP

#include "card.hpp"
#include <string>

using std::string;

class Hand {
	Card* lowestCard;
	int numberOfCardsInHand;

public:
	Hand();
	void AddToHand(Card* card);
	Card* SwapOutCard(Card* card, int position);
	bool HasRacko();
	string ShowHand();
	Card* GetLowestCard();
	int GetNumberOfCardsInHand();	
};

#endif