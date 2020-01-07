#include "game.hpp"
#include <iostream>

using std::cout;
using std::cin;
using std::endl;

int main() {
	int numberOfPlayers;
	string name;
	bool isComputer;

	cout << "Get Ready to play Racko!" << endl;
	cout << "How many players (including computer, max 4): ";
	cin >> numberOfPlayers;
	cout << endl;

	vector<Player> players;

	int iterate = 0;
	while (iterate < numberOfPlayers) {
		Player* nextPlayer = new Player();
		players.push_back(*nextPlayer);

		iterate++;
	}

	int playerCount = 0;
	for (auto i = begin(players); i < end(players); i++) {
		cout << "Enter player " << playerCount+1 << "'s name: ";
		cin >> name;

		i->SetName(name);

		cout << "Is this player a person ('1' for yes or '0' for no)? ";
		cin >> isComputer;
		cout << endl;

		i->SetIsComputer(isComputer);

		playerCount++;
	}
	cin.ignore(256, '\n');
	Game game(players);
	game.DoNextTurn();

	return 0;
}
