#ifndef GAME_HPP
#define GAME_HPP

#include "deck.hpp"
#include "player.hpp"
#include <vector>

using std::vector;

class Game {
	vector<Player> players;
	int numberOfPlayers;
	int currentPlayerTurn;
	int currentRound;
	Deck deck;
	Deck discard;

public:
	Game(vector<Player> players);
	void Deal();
	void DoNextTurn();
	bool IsGameOver();
	Player* GetPlayer(int playerNumber);
	int ShowTopOfDiscardPile();
	Card* DrawFromDeck();
	void Discard(Card* card);
};

#endif