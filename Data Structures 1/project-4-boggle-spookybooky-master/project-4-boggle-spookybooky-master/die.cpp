#include "die.hpp"
#include <cstdlib>

Die::Die(string possibleLetters) {
	for (int iterate = 0; iterate < 6; iterate++)
		this->possibleLetters[iterate] = possibleLetters.at(iterate);
}

char Die::Roll() {
	int index = rand() % 6 + 1;
	
	return this->possibleLetters[index];
}