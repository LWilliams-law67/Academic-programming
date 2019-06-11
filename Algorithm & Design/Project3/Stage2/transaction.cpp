/*
 *      File  : transaction.cpp
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The definition of the class that contains the initialized members
 *              of transactions for adding and removing from the summary for the day.
 */
#include "transaction.h"
#include <iostream>

/*
transaction::transaction(int id, double sellPrice, double costPrice){
	setTransactionID(id);
	setTransactionProfit(sellPrice, costPrice);
}
*/

transaction::transaction(){
	ID = 0;
	profit = 0.0;
}

transaction::transaction(int hour, int minute, int second, std::string name, double sellPrice, double costPrice){
	setTransactionProfit(sellPrice, costPrice);
	setTransactionID();
	this->transactionItem.setItemName(name);
	this->transactionItem.setItemSell(sellPrice);
	this->transactionItem.setItemCost(costPrice);
	this->transactionTime.setTime(hour, minute, second);
}

void transaction::setTransactionID(){
	ID = (rand() % 900) + 100;	//sets transaction ID to a random number from 100 to 900.
}

void transaction::setTransactionProfit(double sellPrice, double costPrice){
	profit = sellPrice - costPrice;
}

int transaction::getTransactionID(){
	return ID;
}

double transaction::getTransactionProfit(){
	return profit;
}
