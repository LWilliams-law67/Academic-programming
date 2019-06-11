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

class transaction{
	public:
		transaction();
		~transaction();
		transaction(int hour, int minute, int second, std::string name, double sellPrice, double costPrice);
		void setTransactionID();
		void setTransactionProfit(double sellPrice, double CostPrice);
		int getTransactionID();
		double getTransactionProfit();
		
	private:
		int ID;
		double profit;
		item transactionItem;
		time transactionTime;		 // items = new item();
};
