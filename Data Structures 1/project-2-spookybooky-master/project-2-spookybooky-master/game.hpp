#include "player.hpp"
#include "maze.hpp"

#ifndef _GAME_HPP
#define _GAME_HPP

class Game {
	//	Pointer variables for the current objects of the Game
	Maze* maze;
	Player* player;
	Room* currentRoom;

	//	This helper function returns a string that describes the given Passage.
	string GetPassageDescription(Passage*);

	public:
		//	A vector of the Game's current items: used to transfer items from Room to Player.
		vector<string> currentItems;
		
		Game(Maze* newMaze, Player* newPlayer);

		//	Prints all the current items in the room.
		void DisplayItems();

		//	Prints all details about the passages connected to this room.
		void DisplayPassages();

		//	Returns the name of the room that the player is currently in.
		string GetCurrentRoomName();

		//	removes all items from the Room object and adds them to the Player object.
		void LootRoom();

		//	Returns a boolean for whether the player can travel in a specific direction.
		bool ValidDirection(string direction);

		//	Moves a player in a legal direction.
		void MoveDirection(string direction);

		//	Returns a boolean for whether the player has reached a room with an exit.
		bool ExitFound();

};

#endif