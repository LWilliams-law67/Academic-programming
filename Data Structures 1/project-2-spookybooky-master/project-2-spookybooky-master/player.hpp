#include <iostream>
#include <string>
#include <vector>

using std::string;
using std::vector;

#ifndef _PLAYER_HPP
#define _PLAYER_HPP

class Player {
	//	Integers to determine player's current position and number of total moves.
	int row;
	int col;
	int moves;
	//	A vector of type 'string' to store player's items.
	vector<string> items;

	public:
		Player();

		//	Simple getter functions for determining player's current position in the Maze.
		int GetRow();
		int GetCol();

		//	A setter method that updates the player's row and column.
		void SetPosition(int newRow, int newCol);

		//	Add an item to the current collection of items that the player has.
		void AddItem(string item);

		//	Returns a boolean value that says whether the player has obtained a given item.
		bool HasItem(string item);

		//	Items are consumables, which means that when they are used, they should be removed completely from the player.
		void UseItem(string item);

		//	Returns the number of moves the player has made in the maze.
		int GetMoveCount();
		
		//	Function used to update the total number of moves each time the player makes a move.
		void IncrementMoves();

};

#endif