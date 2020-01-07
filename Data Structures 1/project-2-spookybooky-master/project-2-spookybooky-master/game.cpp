#include "game.hpp"
#include "maze.hpp"
#include "player.hpp"
#include <locale>

using std::cout;
using std::endl;

Game::Game(Maze* newMaze, Player* newPlayer) {
	maze = newMaze;
	player = newPlayer;
	currentRoom = maze->GetRoom(0,0);
}

void Game::DisplayItems() {
	if (currentRoom->items.empty())
		cout << currentRoom->GetName() << " does not contain any items." << endl;
	else {
		cout << "This room contains:" << endl;
		for (auto i = currentRoom->items.cbegin(); i != currentRoom->items.cend(); i++) 
	        cout << *i << endl;
	    LootRoom();
	    cout << "You have acquired these items.\n" << endl;
	}
}

void Game::DisplayPassages() {
	cout << "To the north is ";
	if (currentRoom->GetNorthPassage()->IsOpen())
		cout << "an open wall." << endl;
	else if (!currentRoom->GetNorthPassage()->IsOpen()) {
		if (currentRoom->GetNorthPassage()->RequiresKey())
			cout << "a closed door that requires " << currentRoom->GetNorthPassage()->GetRequiredKey() << endl;
		else
			cout << "a solid wall." << endl;
	}

	cout << "To the east is ";
	if (currentRoom->GetEastPassage()->IsOpen())
		cout << "an open wall." << endl;
	else if (!currentRoom->GetEastPassage()->IsOpen()) {
		if (currentRoom->GetEastPassage()->RequiresKey())
			cout << "a closed door that requires " << currentRoom->GetEastPassage()->GetRequiredKey() << endl;
		else
			cout << "a solid wall." << endl;
	}

	cout << "To the south is ";
	if (currentRoom->GetSouthPassage()->IsOpen())
		cout << "an open wall." << endl;
	else if (!currentRoom->GetSouthPassage()->IsOpen()) {
		if (currentRoom->GetSouthPassage()->RequiresKey())
			cout << "a closed door that requires " << currentRoom->GetSouthPassage()->GetRequiredKey() << endl;
		else
			cout << "a solid wall." << endl;
	}

	cout << "To the west is ";
	if (currentRoom->GetWestPassage()->IsOpen())
		cout << "an open wall." << endl;
	else if (!currentRoom->GetWestPassage()->IsOpen()) {
		if (currentRoom->GetWestPassage()->RequiresKey())
			cout << "a closed door that requires " << currentRoom->GetWestPassage()->GetRequiredKey() << endl;
		else
			cout << "a solid wall." << endl;
	}
}

string Game::GetCurrentRoomName() {
	return currentRoom->GetName();
}

void Game::LootRoom() {
	while (!currentRoom->items.empty())
		player->AddItem(currentRoom->AcquireNextItem());
}

bool Game::ValidDirection(string direction) {
	char dir = toupper(direction.at(0));
	switch (dir) {
		case 'N':
			if (player->GetRow() == 0)
				return false;
			else if ((currentRoom->GetNorthPassage()->RequiresKey()) && (player->HasItem(currentRoom->GetNorthPassage()->GetRequiredKey()))) {
				currentRoom->GetNorthPassage()->Open();
				player->UseItem(currentRoom->GetNorthPassage()->GetRequiredKey());
				return true;
			}
			else if ((currentRoom->GetNorthPassage()->RequiresKey()) && (!player->HasItem(currentRoom->GetNorthPassage()->GetRequiredKey())))
				cout << "You do not have the required key for that door." << "\n" << endl;
			else if (!currentRoom->GetNorthPassage()->IsOpen())
				return false;
			else
				return true;
		case 'E':
			if (player->GetCol() == (maze->GetNumberCols() - 1))
				return false;
			else if ((currentRoom->GetEastPassage()->RequiresKey()) && (player->HasItem(currentRoom->GetEastPassage()->GetRequiredKey()))) {
				currentRoom->GetEastPassage()->Open();
				player->UseItem(currentRoom->GetEastPassage()->GetRequiredKey());
				return true;
			}
			else if ((currentRoom->GetEastPassage()->RequiresKey()) && (!player->HasItem(currentRoom->GetEastPassage()->GetRequiredKey())))
				cout << "You do not have the required key for that door." << "\n" << endl;
			else if (!currentRoom->GetEastPassage()->IsOpen())
				return false;
			else
				return true;	
		case 'S':
			if (player->GetRow() == (maze->GetNumberRows() - 1))
				return false;
			else if ((currentRoom->GetSouthPassage()->RequiresKey()) && (player->HasItem(currentRoom->GetSouthPassage()->GetRequiredKey()))) {
				currentRoom->GetSouthPassage()->Open();
				player->UseItem(currentRoom->GetSouthPassage()->GetRequiredKey());
				return true;
			}
			else if ((currentRoom->GetSouthPassage()->RequiresKey()) && (!player->HasItem(currentRoom->GetSouthPassage()->GetRequiredKey())))
				cout << "You do not have the required key for that door." << "\n" << endl;
			else if (!currentRoom->GetSouthPassage()->IsOpen())
				return false;
			else
				return true;	
		case 'W':
			if (player->GetCol() == 0)
				return false;
			else if ((currentRoom->GetWestPassage()->RequiresKey()) && (player->HasItem(currentRoom->GetWestPassage()->GetRequiredKey()))) {
				currentRoom->GetWestPassage()->Open();
				player->UseItem(currentRoom->GetWestPassage()->GetRequiredKey());
				return true;
			}
			else if ((currentRoom->GetWestPassage()->RequiresKey()) && (!player->HasItem(currentRoom->GetWestPassage()->GetRequiredKey())))
				cout << "You do not have the required key for that door." << "\n" << endl;
			else if (!currentRoom->GetWestPassage()->IsOpen())
				return false;
			else
				return true;
		default:
			cout << "That is an invalid command.\n" << endl;
			return false;
	}
}

void Game::MoveDirection(string direction) {
	if (ValidDirection(direction)) {
		char dir = toupper(direction.at(0));
		switch (dir) {
			case 'N':	player->SetPosition(player->GetRow()-1, player->GetCol());
						player->IncrementMoves();
						currentRoom = maze->GetRoom(player->GetRow(), player->GetCol());
						break;
			case 'E':	player->SetPosition(player->GetRow(), player->GetCol()+1);
						player->IncrementMoves();
						currentRoom = maze->GetRoom(player->GetRow(), player->GetCol());
						break;
			case 'S':	player->SetPosition(player->GetRow()+1, player->GetCol());
						player->IncrementMoves();
						currentRoom = maze->GetRoom(player->GetRow(), player->GetCol());
						break;
			case 'W':	player->SetPosition(player->GetRow(), player->GetCol()-1);
						player->IncrementMoves();
						currentRoom = maze->GetRoom(player->GetRow(), player->GetCol());
						break;
			default :	cout << "That is not a direction." << endl;
						break;
		}
	}
}

bool Game::ExitFound() {

	string name = currentRoom->GetName();
	for (unsigned i = 0; i < name.length(); i++)
		name[i] = toupper(name[i]);

	if (name.find("EXIT") != string::npos)
		return true;
	else
		return false;
}