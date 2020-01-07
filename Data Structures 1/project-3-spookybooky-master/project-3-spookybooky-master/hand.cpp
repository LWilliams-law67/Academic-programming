#include "hand.hpp"
#include <cstdlib>

using std::to_string;

Hand::Hand() {
	lowestCard = nullptr;
	numberOfCardsInHand = 0;
}

void Hand::AddToHand(Card* card) {
	if (lowestCard == nullptr) {
		lowestCard = card;
		numberOfCardsInHand++;
	}
	else {
		card->SetNext(lowestCard);
		lowestCard->SetPrev(card);
		lowestCard = card;
		numberOfCardsInHand++;
	}
	
}

Card* Hand::SwapOutCard(Card* card, int position) {
	if (lowestCard != nullptr) {
		Card* cardToSwap = lowestCard;

		if (position > 1) {
			for(int iteration = 1; iteration < position; iteration++)
				cardToSwap = cardToSwap->GetNext();
		}
		if (position == numberOfCardsInHand) {
			card->SetPrev(cardToSwap->GetPrev());
			cardToSwap->GetPrev()->SetNext(card);
		}
		else if (position == 1) {
			card->SetNext(cardToSwap->GetNext());
			cardToSwap->GetNext()->SetPrev(card);
			lowestCard = card;
		}
		else {
			card->SetNext(cardToSwap->GetNext());
			card->SetPrev(cardToSwap->GetPrev());
			cardToSwap->GetPrev()->SetNext(card);
			cardToSwap->GetNext()->SetPrev(card);
		}

		cardToSwap->SetNext(nullptr);
		cardToSwap->SetPrev(nullptr);

		return cardToSwap;
	}
	return nullptr;
}

bool Hand::HasRacko() {
	bool gameOver = false;
	if (lowestCard != nullptr) {
		Card* head = lowestCard;

		for (int iteration = 0; iteration < (numberOfCardsInHand - 1); iteration++) {
			if (head->GetValue() < head->GetNext()->GetValue()) {
				gameOver = true;
			}
			else {
				gameOver = false;
				break;
			}
			head = head->GetNext();
		}
	}
	return gameOver;
}

string Hand::ShowHand() {
	string handString = "";

	for (int forEachCard = 1; forEachCard <= numberOfCardsInHand; forEachCard++) {
		// handString += "Card ";
		handString += to_string(forEachCard);
		handString += ":";

		Card* cardToPrint;
		if (lowestCard != nullptr)
			cardToPrint = lowestCard;
		else
			return handString;
		
		if (forEachCard != 1)
			for (int iterator = 1; iterator < forEachCard; iterator++)
				cardToPrint = cardToPrint->GetNext();
		
		for (int printCardLine = 0; printCardLine < cardToPrint->GetValue(); printCardLine++) {
			handString += " ";
		}
		handString += to_string(cardToPrint->GetValue());
		handString += "\n";
	}

	return handString;
}

Card* Hand::GetLowestCard() {
	return lowestCard;
}

int Hand::GetNumberOfCardsInHand() {
	return numberOfCardsInHand;
}