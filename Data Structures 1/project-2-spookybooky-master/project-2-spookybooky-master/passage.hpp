#include <iostream>
#include <string>

using std::string;

#ifndef _PASSAGE_HPP
#define _PASSAGE_HPP

class Passage {
		//	std::string variable for containing the key.
		string key;
		//	boolean variable when 'true' passage is open.
		bool isOpen;
	public:
		Passage();
		Passage(bool isOpen);
		Passage(bool isOpen, string key);

		//	Returns a boolean value to state whether the passage is currently open.
		bool IsOpen();

		//	Returns a boolean for: does the passage require a key to open?
		bool RequiresKey();

		//	Returns a string of the key needed to open the door.
		string GetRequiredKey();
		
		//	Opens a closed door if player has required key.
		void Open();
};
#endif