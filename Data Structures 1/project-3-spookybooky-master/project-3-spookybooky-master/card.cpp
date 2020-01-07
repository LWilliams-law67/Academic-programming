#include "card.hpp"

Card::Card(int value) {
	this->value = value;
	prev = nullptr;
	next = nullptr;
}

Card::Card(int value, Card* next) {
	this->value = value;
	this->next = next;
	prev = nullptr;
}

Card::Card(int value, Card* prev, Card* next) {
	this->value = value;
	this->prev = prev;
	this->next = next;
}

void Card::SetNext(Card* next) {
	this->next = next;
}

void Card::SetPrev(Card* prev) {
	this->prev = prev;
}

int Card::GetValue() {
	return value;
}

Card* Card::GetPrev() {
	return prev;
}

Card* Card::GetNext() {
	return next;
}