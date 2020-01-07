#include "room.hpp"
#include <algorithm>

Room::Room() {
	name = "";
}

Room::Room(string name, Passage *north, Passage *east, Passage *south, Passage *west) {
	//	Stores the values of the constructor parameters into object members
	this->name = name;
	northPassage = north;
	eastPassage = east;
	southPassage = south;
	westPassage = west;
}

string Room::GetName() {
	return name;
}

Passage* Room::GetNorthPassage() {
	return northPassage;
}

Passage* Room::GetEastPassage() {
	return eastPassage;
}

Passage* Room::GetSouthPassage() {
	return southPassage;
}

Passage* Room::GetWestPassage() {
	return westPassage;
}

void Room::AddItem(string item) {
	items.push_back(item);
}

string Room::AcquireNextItem() {
	string itemToReturn;

	//	Checks to see if vector<items> is empty.
	if (items.empty())
		itemToReturn = "";
	else {
		//	Stores the last item in vector<items> to a string, then deletes the last item in the vector.
		itemToReturn = items.back();
		items.pop_back();
	}
	
	return itemToReturn;
}