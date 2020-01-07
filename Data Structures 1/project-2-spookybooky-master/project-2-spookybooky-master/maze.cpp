#include "maze.hpp"
#include <sstream>

using std::cout;
using std::endl;

using std::getline;
using std::stringstream;

Maze::Maze(string mazeFile) {
	//	Opens a file when the file name is provided by the user.
	this->mazeFile.open(mazeFile.c_str());
	
	//	Calls helper function to load the maze data from the file.
	LoadMaze();
}

void Maze::LoadMaze() {
	//	Extracts and stores the number of rows and columns specified by the file.
	mazeFile >> rows;
	mazeFile >> cols;
	//	Discards the newline from the first line in the file.
	mazeFile.ignore(256, '\n');

	//	String variables to extract the data from each individual line of the file.
    string line;
	string roomName, passN, passE, passS, passW, item;

	//	A loop to allocate memory for the array of Room objects.
	rooms = new Room *[rows];
	for (int i = 0; i < rows; i++)
		rooms[i] = new Room [cols];

	int R = 0;
	//	A loop to iterate through the total number of rooms in the file.
	do {
		//	FOR loop to extract from stringstream and populate the array with Room objects.
		for (int C = 0; C < cols; C++) {
			//	Extracts a string line from the file.
			getline(mazeFile, line, '\n');
			//	Creates a string stream to parse each line in the file.
			stringstream streamline(line);
			getline(streamline, roomName, ',');
			getline(streamline, passN, ',');
			getline(streamline, passE, ',');
			getline(streamline, passS, ',');
			getline(streamline, passW, ',');
			//	Populates the rooms array with Room objects.
			rooms[R][C] = Room(roomName, CreatePassage(passN), CreatePassage(passE), CreatePassage(passS), CreatePassage(passW));
			//	A loop to extract all items from the file that belong to each specific Room object.
			while (streamline) {
				if (streamline.rdbuf()->in_avail() < 2)
					break;
				streamline >> item;
				rooms[R][C].AddItem(item);
			}
			//	discards the newline at the end of each line of the file.
			streamline.ignore(256, '\n');
		}
		R++;		
		
	}while (R < rows);
}

Passage* Maze::CreatePassage(string type) {
	//	If-else statements to make sure the appropriate Passage constructor is used to create new Passages.
	if (type == "-") {
		Passage* pass = new Passage(false);
		return pass;
	}
	else if (type == "+") {
		Passage* pass = new Passage(true);
		return pass;
	}
	else {
		Passage* pass = new Passage(false, type);
		return pass;
	}
}

Room* Maze::GetRoom(int row, int col) {
	return &rooms[row][col];
}

int Maze::GetNumberRows() {
	return rows;
}

int Maze::GetNumberCols() {
	return cols;
}

Maze::~Maze() {
/*
	for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
			delete rooms[i][j];
*/
}