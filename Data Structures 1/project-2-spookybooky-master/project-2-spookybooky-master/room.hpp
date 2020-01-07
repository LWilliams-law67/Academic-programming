#include "passage.hpp"
#include <vector>

using std::vector;

#ifndef _ROOM_HPP
#define _ROOM_HPP

class Room {
	//	A string to store the name of the current room.
	string name;

	//	Pointers to the passages for the current room.
	Passage* northPassage;
	Passage* eastPassage;
	Passage* southPassage;
	Passage* westPassage;

	public:
		//	A vector of type 'string' to store player's items.
		vector<string> items;

		Room();
		Room(string name, Passage* north, Passage* east, Passage* south, Passage* west);

		//	Returns the name of the Room.
		string GetName();

		//	Each of these methods returns a pointer to the corresponding Passage.
		Passage* GetNorthPassage();
		Passage* GetEastPassage();
		Passage* GetSouthPassage();
		Passage* GetWestPassage();

		//	Adds an item to the items vector of the Room object.
		void AddItem(string item);

		//	When a player enters a room, they receive all items in that room one at a time.
		string AcquireNextItem();
};

#endif