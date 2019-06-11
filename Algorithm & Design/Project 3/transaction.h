/*
 *      File  : transaction.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The declaration of the class that contains the objects members
 *              of transactions for adding and removing from the summary for the day.
*/
#include<iostream>
#include<string>
#include "item.h"
#include "time.h"

#ifndef TRANSACTION_H_
#define TRANSACTION_H_
class transaction{
	public:
		transaction();
		transaction(int hour, int minute, int second, std::string name, double sellPrice, double costPrice);
		void setTransactionID();
		void setTransactionProfit(double sellPrice, double CostPrice);
		void getTransactionTime();
		int getTransactionID();
		double getTransactionProfit();
		double getItemSell();
		double getItemCost();
		std::string getItemName();
		
		
	private:
		int ID;
		double profit;
		item transactionItem;
		time transactionTime;
};
#endif
