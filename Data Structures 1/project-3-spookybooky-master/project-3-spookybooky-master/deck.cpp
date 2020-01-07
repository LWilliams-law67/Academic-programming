#include "deck.hpp"
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <iostream>

using std::vector;
using std::random_shuffle;
using std::cout;
using std::endl;

Deck::Deck() {
	top = new Card(-1);
	numberOfCardsInDeck = 0;
}

void Deck::MakeFullDeck() {

	for(int iteration = 1; iteration <= NUMBER_OF_CARDS_IN_RACKO_DECK; iteration++) {
		Push(iteration);
	}
}

void Deck::Push(int value) {
	if(value == 1) {
		top = new Card(value);
		top->SetNext(nullptr);
	}
	else {
		Card* temp = nullptr;
		temp = new Card(value);
		top->SetPrev(temp);
		temp->SetNext(top);
		temp->SetPrev(nullptr);
		top = temp;
	}

	numberOfCardsInDeck++;
}

void Deck::Discard(Card* card) {
	if (top == nullptr) {
		top = card;
		numberOfCardsInDeck++;
	}
	else {
		card->SetNext(top);
		top->SetPrev(card);
		top = card;
		numberOfCardsInDeck++;
	}
}

Card* Deck::Draw() {
	if (top != nullptr) {
		Card* cardToDraw = top;

		if (cardToDraw->GetNext() == nullptr) {
			top = nullptr;
			cardToDraw->SetPrev(nullptr);
			cardToDraw->SetNext(nullptr);
			numberOfCardsInDeck--;
			return cardToDraw;
		}

		else {
			top = cardToDraw->GetNext();
			top->SetPrev(nullptr);
			cardToDraw->SetPrev(nullptr);
			cardToDraw->SetNext(nullptr);
			numberOfCardsInDeck--;
			return cardToDraw;
		}
	}
	return nullptr;
}

int Deck::Peek() {
	if (top == nullptr)
		return -1;
	return top->GetValue();
}

void Deck::Shuffle() {
	vector<Card*> vectorDeck;
	int randomIterator;

	srand(time(NULL));
	randomIterator = rand() % 100 + 10;

	for (int iteration = 0; iteration < NUMBER_OF_CARDS_IN_RACKO_DECK; iteration++) {
		vectorDeck.push_back(Deck::Draw());
	}

	for (int i = 0; i < randomIterator; i++)
		random_shuffle(vectorDeck.begin(), vectorDeck.end());

	for (int iteration = 0; iteration < NUMBER_OF_CARDS_IN_RACKO_DECK; iteration++) {
		Card* temp = vectorDeck.at(iteration);
		Deck::Discard(temp);
	}
}

void Deck::InsertAt(Card* card, int index) {

}

Card* Deck::GetTop() {
	if (top == nullptr) 
		return nullptr;
	else
		return top;
}


void Deck::print() const
{
	Card* current = top;
	int totalCards = 0;

	while (current != nullptr)
	{
		cout << current->GetValue() << endl;
		totalCards++;
		current = current->GetNext();
	}
	cout << "\nThe total number of cards is: " << totalCards << "\n" << endl;
}