#ifndef DECK_HPP
#define DECK_HPP

#include "card.hpp"

class Deck {
	static const int NUMBER_OF_CARDS_IN_RACKO_DECK = 60;
	int numberOfCardsInDeck;
	Card* top;

	public:
		Deck();
		void MakeFullDeck();
		void Push(int value);
		void Discard(Card* card);
		Card* Draw();
		int Peek();
		void Shuffle();
		void InsertAt(Card* card, int index);	
		Card* GetTop();
		void print() const;

};

#endif