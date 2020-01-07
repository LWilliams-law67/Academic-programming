#include "game.hpp"
#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cctype>

using std::toupper;
using std::cout;
using std::cin;
using std::getline;
using std::endl;

Game::Game(vector<Player> players) {
	this->players = players;
	numberOfPlayers = this->players.size();
	currentPlayerTurn = 1;
	currentRound = 1;
	Deal();
}

void Game::Deal() {
	deck.MakeFullDeck();
	deck.Shuffle();

	for(auto i = begin(players); i != end(players); i++) {
		Hand* tempHand = new Hand();
		for (int j = 0; j < 10; j++) {
			tempHand->AddToHand(deck.Draw());
		}
		i->SetHand(*tempHand);
		delete tempHand;
	}

	discard.Discard(deck.Draw());
}

void Game::DoNextTurn() {

	string drawOption = "d";
	int slotOption = 0;

	auto i = begin(players);
	do {
		if (i == begin(players))
			cout << "Round " << currentRound << endl;
		if (!i->IsComputer()) {
			cout << i->TurnPrompt() << endl;
			cout << i->ShowHand() << endl;;

			cout << "Available card in discard pile: " << discard.Peek() << endl;
			
			cout << "Enter 'p' to get the card from the discard pile, or 'd' to draw the unknown card from the top of the deck: ";
			getline(cin, drawOption);
			cout << endl;

			if (drawOption[0] == 'd') {
				cout << "Enter the slot number from the left edge of the display that you want to replace with " << deck.Peek() << ". Less than 1 simply discards the card: ";
				cin >> slotOption;
				cin.ignore(256, '\n');
				cout << endl;

				if (slotOption < 1 || slotOption > 10)
					discard.Discard(deck.Draw());
				else
					discard.Discard(i->SwapOutCard(deck.Draw(), slotOption));
			}
			else {
				cout << "Enter the slot number from the left edge of the display that you want to replace with " << discard.Peek() << ": ";
				cin >> slotOption;
				cin.ignore(256, '\n');
				cout << endl;

				if (slotOption >= 1 && slotOption <=10)
					discard.Discard(i->SwapOutCard(discard.Draw(), slotOption));
			}
		}

		else {
			cout << i->TurnPrompt() << endl;
			cout << i->ShowHand() << endl;
			drawOption = i->MakeChoice(discard.Peek());

			cout << drawOption << endl;

			if (drawOption[0] == 'd') {
				cout << "Enter the slot number from the left edge of the display that you want to replace with " << deck.Peek() << ". Less than 1 simply discards the card: ";
				slotOption = i->ComputerChoosesSlot(deck.Peek());
				cout << slotOption << endl;
				if (slotOption < 1 || slotOption > 10)
					discard.Discard(deck.Draw());
				else
					discard.Discard(i->SwapOutCard(deck.Draw(), slotOption));
			}
			else {
				slotOption = i->ComputerChoosesSlot(discard.Peek());
				if (slotOption < 1 || slotOption > 10)
					slotOption = 5;
				discard.Discard(i->SwapOutCard(discard.Draw(), slotOption));
			}
		}

		if (i->HasRacko()) {
			cout << "RRRRRRRRRRRRAAAAAAAAAACCCCCCCCKKKKKKKKOOOOOOOOOO!! " << i->GetName() << " won the game!" << endl;
			cout << "Number of rounds: " << currentRound << endl;
			break;
		}

		if (i == end(players)-1) {
			currentRound++;
			i = begin(players);
		}
		else
			i++;

	}while (!i->HasRacko());

}

bool Game::IsGameOver() {
	return players[currentPlayerTurn-1].HasRacko();
}

Player* Game::GetPlayer(int playerNumber) {
	Player* player = &players.at(playerNumber - 1);
	return player;
}

int Game::ShowTopOfDiscardPile() {
	return discard.Peek();
}

Card* Game::DrawFromDeck() {
	cout << "I am in the DRAW FROM DECK function" << endl;
	if (deck.GetTop()->GetNext() == nullptr) {
		//Shuffle discard pile into deck
		discard.Shuffle();
		cout << "discard pile is shuffled" << endl;
		deck = discard;
		cout << "discard pile is now the deck" << endl;
		//create an empty deck object for the discard pile
		Deck* tempDeck = new Deck();
		cout << "temp deck is created" << endl;
		discard = *tempDeck;
		cout << "discard pile is now a empty deck (temp deck)" << endl;
		//Draw the top card from the shuffled deck, and discard to discard pile
		Card* toDiscardPile = deck.Draw();
		discard.Discard(toDiscardPile);
		cout << "top card of the deck is now the first card in discard pile" << endl;
		//Delete the empty deck object
		delete tempDeck;
		cout << "the re-shuffle process is complete" << endl;
	}

	return deck.Draw();
}

void Game::Discard(Card* card) {

}