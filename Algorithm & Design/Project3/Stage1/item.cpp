/*
 *      File  : item.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The definition of the class that contains the initialized members
 *              of items for selling and generating a profit to print in the summary for the day.
*/

#include "item.h"
#include<iostream>

using namespace std;

void item::setItemName(){
	cout << "Input item name: ";
	getline(cin, name);
	//cin.ignore('\r', '\n', 0);
	cout << endl;
}

void item::setItemCost(){
	cout << "Item cost: ";
	cin >> this->cost;
	//cin.ignore('\r', '\n', 0);
	cout << endl;
}

void item::setItemSell(){
	cout << "Item selling price: ";
	cin >> this->sell;
	//cin.ignore('\r', '\n', 0);
	cout << endl;
}

char* item::getItemName(){
	name_ptr = &name[0];
	return name_ptr;
}

double item::getItemCost(){
	return cost;
}

double item::getItemSell(){
	return sell;
}
