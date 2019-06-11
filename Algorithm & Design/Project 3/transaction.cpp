/*
 *      File  : transaction.cpp
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The definition of the class that contains the initialized members
 *              of transactions for adding and removing from the summary for the day.
 */
#include<iostream>
#include<string>
#include "transaction.h"

using namespace std;

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

double transaction::getItemSell(){
	return transactionItem.getItemSell();
}

double transaction::getItemCost(){
	return transactionItem.getItemCost();
}

string transaction::getItemName(){
	return transactionItem.getItemName();
}

void transaction::getTransactionTime(){
	transactionTime.getTime();
}
