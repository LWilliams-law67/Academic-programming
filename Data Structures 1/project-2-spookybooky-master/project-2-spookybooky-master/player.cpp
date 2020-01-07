#include "player.hpp"
#include <algorithm>
#include <vector>

using std::find;

Player::Player() {
	//	Initializes object members to default values.
	row = 0;
	col = 0;
	moves = 0;

}

int Player::GetRow() {
	return row;
}

int Player::GetCol() {
	return col;
}

void Player::SetPosition(int newRow, int newCol) {
	this->row = newRow;
	this->col = newCol;
}

void Player::AddItem(string item) {
	items.push_back(item);
}

bool Player::HasItem(string item) {
	//	A boolean variable to be returned from function with a default value of 'false'.
	bool playerHasItem = false;

	//	Iterator used to search through the 'items' vector.
	vector<string>::iterator stringIterator;

	stringIterator = find(items.begin(), items.end(), item);
	if (stringIterator != items.end())
		playerHasItem = true;
	
	return playerHasItem;
}

void Player::UseItem(string item) {
	//	Iterator used to search through the 'items' vector.
	vector<string>::iterator stringIterator;

	stringIterator = find(items.begin(), items.end(), item);
	if (stringIterator != items.end())
		items.erase(stringIterator);

}

int Player::GetMoveCount() {
	return moves;
}

void Player::IncrementMoves() {
	moves++;
}