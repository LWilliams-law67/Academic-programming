#include "gameboard.hpp"

GameBoard::GameBoard(string letters) {
	int strIterator = 0;

	for (int row = 0; row < 4; row++)
		for (int col = 0; col < 4; col++) {
			this->letters[row][col] = letters.at(strIterator);
			if (strIterator != 15)
				strIterator++;
		}
}

char GameBoard::GetLetterByRowCol(int row, int col) {
	return this->letters[row][col];
}

string GameBoard::ShowBoard() {
	string board = "";

	for (int row = 0; row < 4; row++)
		for (int col = 0; col < 4; col++) {
			board += this->letters[row][col];
			if (col == 3) {
				board += "\n";
				continue;
			}
			board += " ";
			
		}

	return board;
}
