#ifndef _DICTIONARY_HPP
#define _DICTIONARY_HPP

#include <iostream>
#include <unordered_set>
#include <fstream>
using std::unordered_set;
using std::string;
using std::ifstream;
using std::getline;

class Dictionary {
	unordered_set<string> dictionary;

	public:
		Dictionary();
		bool IsWord(string word);
};

#endif