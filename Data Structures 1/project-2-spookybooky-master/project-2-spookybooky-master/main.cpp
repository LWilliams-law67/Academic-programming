#include "game.hpp"
#include <iostream>
#include <string>

using std::cout;
using std::cin;
using std::endl;
using std::string;

void passageTEST();
void roomTEST();
void mazeTEST();
void playerTEST();
void gameTEST();

int main(){

		// passageTEST();
		// roomTEST();
		// mazeTEST();
		// playerTEST();
		// gameTEST();
	string fileName;
	string directionToMove;

	cout << "Welcome to \"The Text-Based Maze Game\"" << endl;
	cout << "please enter the name of a maze file." << endl;
	cin >> fileName;
	cout << "\n" << endl;

	Maze* newMaze = new Maze(fileName);
	Player* newPlayer = new Player();
	Game newGame(newMaze, newPlayer);

	bool escaped;
	do {
		cout << "You are in " << newGame.GetCurrentRoomName() << endl;
		newGame.DisplayItems();
		newGame.DisplayPassages();

		cout << "\nWhich direction would you like to go?" << endl;
		cin >> directionToMove;
		cout << endl;

		newGame.MoveDirection(directionToMove);
		escaped = newGame.ExitFound();

	}while (!escaped);

	cout << "You have escaped The Maze!" << endl;
	cout << "Total moves = " << newPlayer->GetMoveCount() << endl;

	return 0;
}

void passageTEST() {

	Passage *north = new Passage(false);
	cout << "Solid wall north returns: " << north->IsOpen() << " " << north->RequiresKey() << endl;

	Passage *east = new Passage(true);
	cout << "Open wall east returns: " << east->IsOpen() << " " << east->RequiresKey() << endl;

	Passage *west = new Passage(false, "red_key");
	cout << "Closed door west returns: " << west->IsOpen() << " " << west->RequiresKey() << " ";
	cout << west->GetRequiredKey() << endl;

	west->Open();
	cout << "Opening west door returns: " << west->IsOpen() << endl;

	Passage *south = new Passage(true, "red_key");
	cout << "Open door south returns: " << south->IsOpen() << " " << south->RequiresKey() << " ";
	cout << south->GetRequiredKey() << endl;

}

void roomTEST() {
	
	Passage* northPassage = new Passage(false);
	Passage* eastPassage = new Passage(true);
	Passage* southPassage = new Passage(false, "red_key");
	Passage* westPassage = new Passage(false);
	
	Room* start = new Room("The Start", northPassage, eastPassage, southPassage, westPassage);
	cout << "Start room name is: " << start->GetName() << endl;
	cout << "North passage returns: " << start->GetNorthPassage()->IsOpen() << start->GetNorthPassage()->RequiresKey() << endl;	
	cout << "East passage returns: " << start->GetEastPassage()->IsOpen() << start->GetEastPassage()->RequiresKey() << endl;	
	cout << "South passage returns: " << start->GetSouthPassage()->IsOpen() << start->GetSouthPassage()->RequiresKey();
	cout << start->GetSouthPassage()->GetRequiredKey() << endl;	
	cout << "West passage returns: " << start->GetWestPassage()->IsOpen() << start->GetWestPassage()->RequiresKey() << endl;

	start->AddItem("axe");
	start->AddItem("blue_key");
	
	cout << "Items in room returns: " << start->AcquireNextItem() << " ";
	cout << start->AcquireNextItem() << " ";
	cout << start->AcquireNextItem() << endl;

}

void mazeTEST() {

	Maze* newMaze = new Maze("testMaze.txt");
	cout << "GetNumberRows() and GetNumberCols() returns: " << newMaze->GetNumberRows() << newMaze->GetNumberCols() << endl;
	cout << "GetName returns: " << newMaze->GetRoom(0,0)->GetName() << endl; 
	cout << "Start north passage isOpen() returns: " << newMaze->GetRoom(0,0)->GetNorthPassage()->IsOpen() << endl;
	cout << "Start east passage isOpen() returns: " << newMaze->GetRoom(0,0)->GetEastPassage()->IsOpen() << endl;
	cout << "Start south passage isOpen() returns: " << newMaze->GetRoom(0,0)->GetSouthPassage()->IsOpen() << endl;
	cout << "Start west passage isOpen() returns: " << newMaze->GetRoom(0,0)->GetWestPassage()->IsOpen() << endl;

	cout << "The next room name is: " << newMaze->GetRoom(0,1)->GetName() << endl; 
	cout << "The landing north passage isOpen() returns: " << newMaze->GetRoom(0,1)->GetNorthPassage()->IsOpen() << endl;
	cout << "The landing east passage isOpen() returns: " << newMaze->GetRoom(0,1)->GetEastPassage()->IsOpen() << endl;
	cout << "The landing south passage isOpen() returns: " << newMaze->GetRoom(0,1)->GetSouthPassage()->IsOpen() << endl;
	cout << "The landing west passage isOpen() returns: " << newMaze->GetRoom(0,1)->GetWestPassage()->IsOpen() << endl;

}

void playerTEST() {

	Player newPlayer;
	cout << "newPlayer GetRow() and GetCol() returns: " << newPlayer.GetRow() << newPlayer.GetCol() << endl;
	
	newPlayer.SetPosition(1,1);
	cout << "Set position(1,1), GetRow() and GetCol() returns: " << newPlayer.GetRow() << newPlayer.GetCol() << endl;

	newPlayer.AddItem("red_key");
	cout << "AddItem(red_key) then HasItem(red_key) returns: " << newPlayer.HasItem("red_key") << endl;

	newPlayer.UseItem("red_key");
	cout << "UseItem(red_key) then HasItem returns: " << newPlayer.HasItem("red_key") << endl;

}

void gameTEST() {

	Maze* newMaze = new Maze("testMaze.txt");
	Player* newPlayer = new Player();
	Game newGame(newMaze, newPlayer);
	cout << "GetCurrentRoom() returns: " << newGame.GetCurrentRoomName() << endl;
	cout << "ExitFound() should return false: " << newGame.ExitFound() << endl;
	
	newGame.MoveDirection("E");
	newGame.MoveDirection("E");
	newGame.LootRoom();
	cout << "After moving E, E room name is : " << newGame.GetCurrentRoomName() << endl;
	cout << "Looting room then HasItem() returns: " << newPlayer->HasItem("red_key") << endl;
	cout << "ExitFound() returns: " << newGame.ExitFound() << endl;

	newGame.MoveDirection("W");
	newGame.MoveDirection("W");
	newGame.MoveDirection("S");
	cout << "After moving W, W, S room name returns: " << newGame.GetCurrentRoomName() << endl;
	cout << "ExitFound() should still return false: " << newGame.ExitFound() << endl;
	cout << "HasItem(red_key) returns: " << newPlayer->HasItem("red_key") << endl;

	newGame.MoveDirection("E");
	newGame.MoveDirection("E");
	cout << "After moving E, E room name returns: " << newGame.GetCurrentRoomName() << endl;
	cout << "ExitFound() should now return true: " << newGame.ExitFound() << endl;

}