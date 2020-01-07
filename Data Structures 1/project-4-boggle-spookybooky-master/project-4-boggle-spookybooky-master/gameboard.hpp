#ifndef _GAMEBOARD_HPP
#define _GAMEBOARD_HPP
#include <string>
using std::string;

class GameBoard {
	char letters[4][4];
	
	public:
		GameBoard(string letters);
		char GetLetterByRowCol(int row, int col);
		string ShowBoard();
};

#endif