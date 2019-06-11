/*
 *      File  : summary.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The declaration of the class that contains the object members
 *              of a summary for displaying transactions for the day.
*/
#include<iostream>
#include<array>
#include "transaction.h"

class summary{
	public:
		summary();
		~summary();
		void newSummaryTransaction();
		void removeSummaryTransaction();
		void printSummary();
		
	private:
		std::array<transaction, 10> today;
		int totalTransactions, completedTransactions, voidedTransactions;
};

