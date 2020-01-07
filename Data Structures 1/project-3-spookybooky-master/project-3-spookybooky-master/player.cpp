#include "player.hpp"
#include <cctype>

Player::Player() {
	playerName = "";
	isComputer = true;
}

Player::Player(string name, Hand hand, bool isComputer) {
	this->playerName = name;
	this->hand = hand;
	this->isComputer = isComputer;
}

void Player::SetName(string name) {
	this->playerName = name;
}

void Player::SetHand(Hand hand) {
	this->hand = hand;
}

void Player::SetIsComputer(bool isComputer) {
	this->isComputer = isComputer;
}

string Player::TurnPrompt() {
	string turnPrompt = playerName;
	turnPrompt += "'s turn";

	return turnPrompt;
}

string Player::ShowHand() {
	if (this->hand.ShowHand() == "") {
		string playerHand = playerName;
		playerHand += "'s hand is empty.";
		return playerHand;
	}
	else
		return this->hand.ShowHand();
}

Card* Player::SwapOutCard(Card* card, int position) {
	return this->hand.SwapOutCard(card, position);
}

bool Player::HasRacko() {
	return this->hand.HasRacko();
}

string Player::GetName() {
	return this->playerName;
}

bool Player::IsComputer() {
	return this->isComputer;
}

string Player::MakeChoice(int discardOption) {
	string computerChoice = "d";

	return computerChoice;
}

int Player::ComputerChoosesSlot(int cardValue) {
	int slotInHand = -1;

	if (HasRacko())
		return slotInHand;

	if (cardValue < 10)
		slotInHand = 1;

	if (cardValue > 4 && cardValue < 16)
		slotInHand = 2;

	if (cardValue > 10 && cardValue < 22)
		slotInHand = 3;

	if (cardValue > 16 && cardValue < 28)
		slotInHand = 4;

	if (cardValue > 22 && cardValue < 34)
		slotInHand = 5;

	if (cardValue > 28 && cardValue < 40)
		slotInHand = 6;

	if (cardValue > 34 && cardValue < 46)
		slotInHand = 7;

	if (cardValue > 40 && cardValue < 52)
		slotInHand = 8;

	if (cardValue > 46 && cardValue < 58)
		slotInHand = 9;

	if (cardValue > 52)
		slotInHand = 10;


	return slotInHand;
}