#include "dictionary.hpp"

Dictionary::Dictionary() {
	ifstream wordFile;
	wordFile.open("words.txt"/*, ifstream::in*/);
	string word;

	if (!wordFile.is_open())
		perror("Error opening file");
	else {
		while (!wordFile.eof()) {
			getline(wordFile, word);
			this->dictionary.insert(word);
		}
		wordFile.close();
	}
}

bool Dictionary::IsWord(string word) {
	if (dictionary.find(word) == dictionary.end())
		return false;

	return true;
}