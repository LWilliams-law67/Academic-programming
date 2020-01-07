#ifndef _DIE_HPP
#define _DIE_HPP

#include <string>
using std::string;

class Die {
	char possibleLetters[6];

	public:
		Die(string possibleLetters);
		char Roll();
};

#endif