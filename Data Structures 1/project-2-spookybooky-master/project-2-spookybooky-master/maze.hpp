#include "room.hpp"
#include <fstream>

using std::ifstream;

#ifndef _MAZE_HPP
#define _MAZE_HPP

class Maze {
	//	An array of Room objects that make up the Maze.
	Room** rooms;
	//	Integers for player to specify the array size via input file.
	int rows;
	int cols;
	//	A input file stream that is specified by the user given file name.
	ifstream mazeFile;

	//	This private helper function is used to read the file and create the
	//	two-dimensional array of Room objects.
	void LoadMaze();
	//	This private helper function takes in a string of '-', '+', or an
	//	item needed to open a door, and returns a pointer to an appropriate Passage object.
	Passage* CreatePassage(string type);

	public:
		Maze(string mazeFile);

		//	Takes in a position in terms of a row and column and returns a pointer to the
		//	Room object at that location in the Maze.
		Room* GetRoom(int row, int col);

		//	Simple getter methods that return the number of rows and columns in the maze.
		int GetNumberRows();
		int GetNumberCols();

		//	A destructor to deallocate the memory used by the array of Room objects.
		~Maze();

};

#endif