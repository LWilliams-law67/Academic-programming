#include "passage.hpp"

Passage::Passage() {
	//	Stores default values into object members
	isOpen = false;
	key = "";
}

Passage::Passage(bool isOpen) {
	//	Stores the value of the constructor parameter into the object member
	//	and puts a default value (empty string) into 'key'
	this->isOpen = isOpen;
	key = "";
}

Passage::Passage(bool isOpen, string key) {
	//	Stores the values of the constructor parameters into the object members
	this->isOpen = isOpen;
	this->key = key;
}

bool Passage::IsOpen() {
	return isOpen;
}

bool Passage::RequiresKey() {
	//	If 'string key' is empty the function returns false, but if 'key' has
	//	a value then true is returned.
	if (key == "") 
		return false;
	else
		return true;
}

string Passage::GetRequiredKey() {
	return key;
}

void Passage::Open() {
	isOpen = true;
}