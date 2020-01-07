#ifndef CARD_HPP
#define CARD_HPP

class Card {
	int value;
	Card* prev;
	Card* next;

	public:
		Card(int value);
		Card(int value, Card* next);
		Card(int value, Card* prev, Card* next);
		void SetNext(Card* next);
		void SetPrev(Card* prev);
		int GetValue();
		Card* GetPrev();
		Card* GetNext();
};

#endif